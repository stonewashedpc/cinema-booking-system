package exceptions;

import java.io.Serializable;

public class ClientException extends Exception implements Serializable {
	private static final long serialVersionUID = 1L;
	public ClientException(String message) {
		super(message);
	}
	public ClientException(String message, Throwable cause) {
		super(message, cause);
	}
}
