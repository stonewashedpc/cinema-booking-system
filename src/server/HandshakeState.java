package server;

import java.io.DataInputStream;
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
import exceptions.ServerException;

public class HandshakeState extends ServerState {

	public HandshakeState(ServerThread myServerThread) {
		super(myServerThread);
	}

	@Override
	public void handle() throws ServerException {
		try {
			this.getMyServerThread().getClientSocket().setSoTimeout(600000); // Timeout after 10 minutes (600000 milliseconds)
			
			// START ============= Generate RSA-KeyPair and send to Client
			KeyPair keyPair = Cryptography.generateKeyPair();
			
			System.out.println("Generated RSA-KeyPair");
			
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(this.getMyServerThread().getClientSocket().getOutputStream());

			objectOutputStream.writeObject(keyPair.getPublic());
			objectOutputStream.flush();
			
			System.out.println("Sent RSA-PublicKey to Client");
			// END =============== Generate RSA-KeyPair and send to Client

			// START ============= Receive encrypted AES-Key from Client
			DataInputStream dataInputStream = new DataInputStream(this.getMyServerThread().getClientSocket().getInputStream());

			int length = dataInputStream.readInt();
			System.out.println("Received encrypted AES-Key length: " + length + " bytes");
			byte[] encryptedKey = null;
			if (length > 0) {
				encryptedKey = new byte[length];
				dataInputStream.readFully(encryptedKey, 0, encryptedKey.length);
			} else {
				System.out.println("ERROR: length received for encrypted AES-Key is <= 0");
				this.endOfProcessing();
			}
			// END =============== Receive encrypted AES-Key from Client

			System.out.println("Received encrypted AES-Key: " + Arrays.toString(encryptedKey));
			
			// Decrypt encrypted AES-Key
			Cipher rsaCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

			rsaCipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());
			byte[] decryptedKey = rsaCipher.doFinal(encryptedKey);

			// Create SecretKey from decrypted AES-Key
			SecretKey aesKey = new SecretKeySpec(decryptedKey, 0, decryptedKey.length, "AES");

			System.out.println("Created AES-SecretKey from decrypted AES-Key: " + Arrays.toString(aesKey.getEncoded()));
			
			// Initialize Ciphers (Important: use CTR-Mode)
			Cipher aesCipherDecrypt = Cipher.getInstance("AES/CTR/NoPadding");
			aesCipherDecrypt.init(Cipher.DECRYPT_MODE, aesKey, new IvParameterSpec(new byte[16]));
			
			Cipher aesCipherEncrypt = Cipher.getInstance("AES/CTR/NoPadding");
	        aesCipherEncrypt.init(Cipher.ENCRYPT_MODE, aesKey, new IvParameterSpec(new byte[16]));
			
	        // Initialize OutputStream
			CipherOutputStream cipherOutputStream = new CipherOutputStream(this.getMyServerThread().getClientSocket().getOutputStream(), aesCipherEncrypt);
			
			this.getMyServerThread().setOut(new ObjectOutputStream(cipherOutputStream));
			
			this.getMyServerThread().getOut().flush();
			
			System.out.println("ObjectOutputStream initialized");

			// Initialize InputStream
			CipherInputStream cipherInputStream = new CipherInputStream(this.getMyServerThread().getClientSocket().getInputStream(), aesCipherDecrypt);
			
			this.getMyServerThread().setIn(new ObjectInputStream(cipherInputStream));
			
			System.out.println("ObjectInputStream initialized");
			
			// Set ServerState to ListeningState (Ready to handle incoming commands)
			this.getMyServerThread().setServerState(new ListeningState(this.getMyServerThread()));
			System.out.println("Handshake successful for client: " + this.getMyServerThread().getClientHostname());
		} catch (Exception e) {
			this.endOfProcessing();
			throw new ServerException("Handshake failed for client: " + this.getMyServerThread().getClientHostname(), e);
		}
	}

}
