package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
	private final ServerSocket serverSocket;
	
	public Server(Integer port) throws IOException {
		this.serverSocket = new ServerSocket(port);
	}

	public void run() {
		try {
			while (!this.isInterrupted()) {
				
				Socket clientSocket = serverSocket.accept();

				ServerThread thread = new ServerThread(clientSocket);

				thread.start();
				
				System.out.println("Started new ServerThread for client: " + clientSocket.getInetAddress().getCanonicalHostName());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				this.serverSocket.close();
				System.out.println("ServerSocket closed");
			} catch (IOException e1) {e1.printStackTrace();}
		}
	}
}