package client;

import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.security.PublicKey;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

import commands.Command;
import crypto.Cryptography;
import exceptions.ClientException;

public class HandshakeState extends ClientState {

	public HandshakeState(Client myClient) {
		super(myClient);
	}

	@Override
	public void connect() throws ClientException {
		try {
			this.getMyClient().setClientSocket(new Socket(this.getMyClient().getIp(), this.getMyClient().getPort()));
			this.getMyClient().getClientSocket().setSoTimeout(1000); // Timout read from inputstream
			
			SecretKey aesKey = Cryptography.generateSecretKey();
			
			// Receiving the RSA - PublicKey
	        ObjectInputStream objectInputStream = new ObjectInputStream(this.getMyClient().getClientSocket().getInputStream());
	        System.out.println("Client > INFO > created objectInputStream: " + objectInputStream.toString());

	        PublicKey publicKey1 = (PublicKey) objectInputStream.readObject();
	        System.out.println("Client > INFO > publicKey received from server: " + publicKey1.toString());

	        // Creating a Cipher object
	        Cipher rsaCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

	        // Initializing the Cipher object for encrypting
	        rsaCipher.init(Cipher.ENCRYPT_MODE, publicKey1);

	        byte[] encryptedKey = rsaCipher.doFinal(aesKey.getEncoded());
	        //System.out.println("Client > INFO > sending encrypted aesKey: " + Arrays.toString(encryptedKey));

	        // Sending the AES - SecretKey encrypted with the RSA - PublicKey
	        DataOutputStream dataOutputStream = new DataOutputStream(this.getMyClient().getClientSocket().getOutputStream());

	        dataOutputStream.writeInt(encryptedKey.length);
	        dataOutputStream.flush();

	        dataOutputStream.write(encryptedKey);
	        dataOutputStream.flush();

	        // Creating an ObjectOutputStream over a CipherOutputStream
	        //Cipher aesCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
	        Cipher aesCipherEncrypt = Cipher.getInstance("AES/CTR/NoPadding");
	        aesCipherEncrypt.init(Cipher.ENCRYPT_MODE, aesKey, new IvParameterSpec(new byte[16]));
	        
	        Cipher aesCipherDecrypt = Cipher.getInstance("AES/CTR/NoPadding");
			aesCipherDecrypt.init(Cipher.DECRYPT_MODE, aesKey, new IvParameterSpec(new byte[16]));
	        
	        CipherOutputStream cipherOutputStream = new CipherOutputStream(this.getMyClient().getClientSocket().getOutputStream(), aesCipherEncrypt);
	        
	        this.getMyClient().setOut(new ObjectOutputStream(cipherOutputStream));
	        
	        this.getMyClient().getOut().flush();

	        CipherInputStream cipherInputStream = new CipherInputStream(this.getMyClient().getClientSocket().getInputStream(), aesCipherDecrypt);
	        
	        this.getMyClient().setIn(new ObjectInputStream(cipherInputStream));
	        
			this.getMyClient().setClientState(new ReadyState(this.getMyClient()));
			System.out.println("Client ready");
		} catch (Exception e) {
			this.getMyClient().setClientState(new InitialState(this.getMyClient()));
			e.printStackTrace(); // print detailed stack trace for debugging purposes
			throw new ClientException("An exception ocurred while handshaking: " + e.getMessage());
		}
	}

	@Override
	public <R> Command<R> executeCommand(Command<R> command)
			throws ClientException {
		throw new ClientException("cannot send command while handshaking");
	}

}
