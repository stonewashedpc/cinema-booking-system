package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.Semaphore;

import commands.Command;

public class Client {
	private String ip;
	private Integer port;
	private Semaphore mutex;
	private Socket clientSocket;
	private ObjectOutputStream out;
	private ObjectInputStream in;

	public Client(String ip, Integer port) throws UnknownHostException, IOException {
		this.ip = ip;
		this.port = port;
		this.clientSocket = new Socket(ip, port);
		this.out = new ObjectOutputStream(clientSocket.getOutputStream());
		this.in = new ObjectInputStream(clientSocket.getInputStream());
		this.clientSocket.setSoTimeout(1000); // Timout read from inputstream
		this.mutex = new Semaphore(1);
	}

	public <R> Command<R> executeCommand(Command<R> command) throws IOException, InterruptedException, ClassNotFoundException {
		this.mutex.acquire();
		Command<R> commandResult = null;
		try {
		        this.out.writeObject(command);
		        commandResult = (Command<R>) this.in.readObject();
		} catch (SocketTimeoutException e) {
		        // handle timeout (return command with exception?)
		} finally {
		        this.mutex.release();
		}
		return commandResult;
	}
}