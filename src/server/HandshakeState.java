package server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.KeyPair;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import crypto.Cryptography;

public class HandshakeState extends ServerState {

	public HandshakeState(ServerThread myServerThread) {
		super(myServerThread);
	}

	@Override
	public void handle() throws IOException, ClassNotFoundException {
		try {
			KeyPair keyPair = Cryptography.generateKeyPair();
			
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(this.getMyServerThread().getClientSocket().getOutputStream());
			System.out.println("Server > INFO > created objectOutputStream: " + objectOutputStream.toString());

			objectOutputStream.writeObject(keyPair.getPublic());
			objectOutputStream.flush();

			// Receiving the encrypted AES - SecretKey
			DataInputStream dataInputStream = new DataInputStream(this.getMyServerThread().getClientSocket().getInputStream());

			int length = dataInputStream.readInt();
			System.out.println("Server > INFO > received encrypted aesKey's length: " + length);
			byte[] encryptedKey = null;
			if (length > 0) {
				encryptedKey = new byte[length];
				dataInputStream.readFully(encryptedKey, 0, encryptedKey.length);
			} else {
				System.out.println("Server > ERROR > length received is <= 0");
				this.endOfProcessing();
			}

			System.out.println("Server > INFO > received encrypted aesKey: " + Arrays.toString(encryptedKey));

			// Decrypting the encrypted AES - SecretKey
			Cipher rsaCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

			rsaCipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());
			byte[] decryptedKey = rsaCipher.doFinal(encryptedKey);

			// Converting the decrypted AES - SecretKey to a SecretKey
			SecretKey aesKey = new SecretKeySpec(decryptedKey, 0, decryptedKey.length, "AES");

			System.out.println("Server > INFO > converted decrypted aesKey: " + Arrays.toString(aesKey.getEncoded()));
			
			//Cipher aesCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			Cipher aesCipherDecrypt = Cipher.getInstance("AES/CTR/NoPadding");
			aesCipherDecrypt.init(Cipher.DECRYPT_MODE, aesKey, new IvParameterSpec(new byte[16]));
			
			Cipher aesCipherEncrypt = Cipher.getInstance("AES/CTR/NoPadding");
	        aesCipherEncrypt.init(Cipher.ENCRYPT_MODE, aesKey, new IvParameterSpec(new byte[16]));
			
			CipherOutputStream cipherOutputStream = new CipherOutputStream(this.getMyServerThread().getClientSocket().getOutputStream(), aesCipherEncrypt);
			System.out.println("Server > INFO > created cipherOutputStream");
			
			this.getMyServerThread().setOut(new ObjectOutputStream(cipherOutputStream));
			System.out.println("Server > INFO > created ObjectOutputStream");
			
			this.getMyServerThread().getOut().flush();

			// Creating an ObjectInputStream over a CipherInputStream
			CipherInputStream cipherInputStream = new CipherInputStream(this.getMyServerThread().getClientSocket().getInputStream(), aesCipherDecrypt);
			System.out.println("Server > INFO > created cipherInputStream");
			
			this.getMyServerThread().setIn(new ObjectInputStream(cipherInputStream));
			System.out.println("Server > INFO > created ObjectInputStream");
			
			this.getMyServerThread().setServerState(new ListeningState(this.getMyServerThread()));
		} catch (Exception e) {
			e.printStackTrace();
			this.endOfProcessing();
		}
	}

}
