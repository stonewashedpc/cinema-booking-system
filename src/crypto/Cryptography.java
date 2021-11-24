package crypto;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Cryptography {
	
	private static final int RSA_KEY_SIZE = 2048;
	private static final int AES_KEY_SIZE = 128;
	
	public static KeyPair generateKeyPair() {
		KeyPairGenerator generator;
		try {
			generator = KeyPairGenerator.getInstance("RSA");
			generator.initialize(RSA_KEY_SIZE);
			return generator.generateKeyPair();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace(); // Ignore Exception, as the used algorithm will not change
		}
		return null;
	}
	
	public static SecretKey generateSecretKey() {
		KeyGenerator generator;
		try {
			generator = KeyGenerator.getInstance("AES");
			generator.init(AES_KEY_SIZE);
			return generator.generateKey();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace(); // Ignore Exception, as the used algorithm will not change
		}
		return null;
	}
}
