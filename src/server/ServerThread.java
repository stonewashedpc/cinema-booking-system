package server;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;

import commands.Command;

public class ServerThread extends Thread {
	private static final int SOCKET_TIMEOUT = 600000; // Timeout after 10 minutes (600000 milliseconds)
	private Socket clientSocket;

	public ServerThread(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}

	public void run() {
		ObjectOutputStream out = null;
		ObjectInputStream in = null;
		try {
			out = new ObjectOutputStream(clientSocket.getOutputStream());
			in = new ObjectInputStream(clientSocket.getInputStream());

			clientSocket.setSoTimeout(SOCKET_TIMEOUT);
			
			Command next;
			while ((next = (Command) in.readObject()) != null) {
				next.execute();
				out.writeObject(next);
			}
		} catch (EOFException e) {
			// TODO: handle exception
			System.out.println("ServerThread: EOF reached");
		} catch (SocketTimeoutException e) {
			// TODO: handle exception
			System.out.println("ServerThread: Socket timeout");
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				out.close();
				in.close();
				clientSocket.close();
			} catch (IOException e2) {
				// TODO: handle exception
			}
		}
	}
}