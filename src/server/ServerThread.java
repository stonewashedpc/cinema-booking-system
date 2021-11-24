package server;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;

import commands.Command;

public class ServerThread extends Thread {
	private static final int SOCKET_TIMEOUT = 600000; // Timeout after 10 minutes (600000 milliseconds)
	private Socket clientSocket;
	private ServerState serverState;
	
	private ObjectOutputStream out;
	private ObjectInputStream in;

	public ServerThread(Socket clientSocket) {
		this.clientSocket = clientSocket;
		this.serverState = new HandshakeState(this);
	}

	public void run() {
		
		try {
			clientSocket.setSoTimeout(SOCKET_TIMEOUT);
			
			while(!this.isInterrupted()) {
				this.serverState.handle();
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
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
				clientSocket.close();
			} catch (IOException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}

	public void setServerState(ServerState serverState) {
		this.serverState = serverState;
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

	public String getIp() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}