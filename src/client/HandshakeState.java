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
			
			// Generate AES-SecretKey
			SecretKey aesKey = Cryptography.generateSecretKey();
			
			System.out.println("Generated AES-SecretKey");
			
			// START ============= Receive RSA-PublicKey from Client
	        ObjectInputStream objectInputStream = new ObjectInputStream(this.getMyClient().getClientSocket().getInputStream());

	        PublicKey publicKey = (PublicKey) objectInputStream.readObject();
	        System.out.println("Received RSA-PublicKey from server: " + publicKey.toString());
	        // END =============== Receive RSA-PublicKey from Client
	        
	        // START ============= Initialize Cipher for RSA encryption
	        Cipher rsaCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

	        rsaCipher.init(Cipher.ENCRYPT_MODE, publicKey);
	        // END =============== Initialize Cipher for RSA encryption
	        
	        // Encrypt AES-SecretKey with RSA-Cipher
	        byte[] encryptedKey = rsaCipher.doFinal(aesKey.getEncoded());
	        
	        System.out.println("Encrypted AES-SecretKey using RSA-PublicKey");
	        
	        // START ============= Send RSA-encrypted AES-Key to server
	        DataOutputStream dataOutputStream = new DataOutputStream(this.getMyClient().getClientSocket().getOutputStream());

	        dataOutputStream.writeInt(encryptedKey.length);
	        dataOutputStream.flush();

	        dataOutputStream.write(encryptedKey);
	        dataOutputStream.flush();
	        
	        System.out.println("Sent encrypted AES-Key to server");
	        // END =============== Send RSA-encrypted AES-Key to server

	        // Initialize Ciphers (Important: use CTR-Mode)
	        Cipher aesCipherEncrypt = Cipher.getInstance("AES/CTR/NoPadding");
	        aesCipherEncrypt.init(Cipher.ENCRYPT_MODE, aesKey, new IvParameterSpec(new byte[16]));
	        
	        Cipher aesCipherDecrypt = Cipher.getInstance("AES/CTR/NoPadding");
			aesCipherDecrypt.init(Cipher.DECRYPT_MODE, aesKey, new IvParameterSpec(new byte[16]));
	        
			// Initialize OutputStream
	        //CipherOutputStream cipherOutputStream = new CipherOutputStream(this.getMyClient().getClientSocket().getOutputStream(), aesCipherEncrypt);
	        
	        this.getMyClient().setOut(new ObjectOutputStream(this.getMyClient().getClientSocket().getOutputStream()));
	        
	        this.getMyClient().getOut().flush();
	        
	        System.out.println("ObjectOutputStream initialized");
	        
	        // Initialize InputStream
	        //CipherInputStream cipherInputStream = new CipherInputStream(this.getMyClient().getClientSocket().getInputStream(), aesCipherDecrypt);
	        
	        this.getMyClient().setIn(new ObjectInputStream(this.getMyClient().getClientSocket().getInputStream()));
	        
	        System.out.println("ObjectInputStream initialized");
	        
	        // Set ClientState to ReadyState (Ready to send commands to server)
			this.getMyClient().setClientState(new ReadyState(this.getMyClient()));
			System.out.println("Client ready");
		} catch (Exception e) {
			this.getMyClient().setClientState(new InitialState(this.getMyClient()));
			throw new ClientException("An exception ocurred while handshaking", e);
		}
	}

	@Override
	public <R> Command<R> executeCommand(Command<R> command)
			throws ClientException {
		throw new ClientException("cannot send command while handshaking");
	}

}
