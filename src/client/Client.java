package client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Optional;
import java.util.concurrent.Semaphore;

import commands.Command;
import exceptions.ClientException;

public class Client {
	private String ip;
	private Integer port;
	private Semaphore mutex;
	private Socket clientSocket;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private ClientState clientState;
	private Optional<String> authToken;

	public Client(String ip, Integer port) {
		this.ip = ip;
		this.port = port;
		this.mutex = new Semaphore(1);
		this.clientState = new InitialState(this);
		this.authToken = Optional.empty();
	}
	
	public void connect() throws ClientException {
		this.clientState.connect();
	}

	public <R> Command<R> executeCommand(Command<R> command) throws ClientException {
		if (this.authToken.isPresent()) {
			command.setAuthToken(authToken.get());
		} else command.setAuthToken(null);
		return this.clientState.executeCommand(command);
	}

	public Semaphore getMutex() {
		return mutex;
	}

	public void setMutex(Semaphore mutex) {
		this.mutex = mutex;
	}

	public Socket getClientSocket() {
		return clientSocket;
	}

	public void setClientSocket(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}

	public ObjectOutputStream getOut() {
		return out;
	}

	public void setOut(ObjectOutputStream out) {
		this.out = out;
	}

	public ObjectInputStream getIn() {
		return in;
	}

	public void setIn(ObjectInputStream in) {
		this.in = in;
	}

	public ClientState getClientState() {
		return clientState;
	}

	public void setClientState(ClientState clientState) {
		this.clientState = clientState;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public void setAuthToken(String authToken) {
		this.authToken = Optional.of(authToken);
	}
	
	public String getAuthToken() {
		return this.authToken.orElse("");
	}
	
}