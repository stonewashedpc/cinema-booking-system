package server;

import java.io.IOException;
import java.net.ServerSocket;

public class Server extends Thread {
	private ServerSocket serverSocket;
	private Integer port;
	
	public Server(Integer port) {
		this.port = port;
	}

	public void run() {
		try {
			serverSocket = new ServerSocket(this.port);

			while (!this.isInterrupted()) {

				ServerThread thread = new ServerThread(serverSocket.accept());
				
				System.out.println("Starting new Server Thread");

				thread.start();
			}
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}