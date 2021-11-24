package client;

import java.io.DataOutputStream;
import java.io.IOException;
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

public class InitialState extends ClientState {

	public InitialState(Client myClient) {
		super(myClient);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void connect() throws IOException {
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
	        Cipher aesCipher = Cipher.getInstance("AES/CTR/NoPadding");
	        aesCipher.init(Cipher.ENCRYPT_MODE, aesKey, new IvParameterSpec(new byte[16]));
	        
	        CipherOutputStream cipherOutputStream = new CipherOutputStream(this.getMyClient().getClientSocket().getOutputStream(), aesCipher);
	        
	        this.getMyClient().setOut(new ObjectOutputStream(cipherOutputStream));
	        
	        this.getMyClient().getOut().flush();

	        CipherInputStream cipherInputStream = new CipherInputStream(this.getMyClient().getClientSocket().getInputStream(), aesCipher);
	        
	        this.getMyClient().setIn(new ObjectInputStream(cipherInputStream));
	        
			this.getMyClient().setClientState(new ReadyState(this.getMyClient()));
			System.out.println("Client ready");
		} catch (Exception e) {
			e.printStackTrace();
			// TODO Handle Exception
		}
	}

	@Override
	public <R> Command<R> executeCommand(Command<R> command)
			throws IOException, InterruptedException, ClassNotFoundException {
		return null; // TODO Throw Exception
	}

}
