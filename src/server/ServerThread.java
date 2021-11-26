package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import exceptions.ServerException;

public class ServerThread extends Thread {
	private final Socket clientSocket;
	private ServerState serverState;
	
	private ObjectOutputStream out;
	private ObjectInputStream in;

	public ServerThread(Socket clientSocket) {
		this.clientSocket = clientSocket;
		this.serverState = new HandshakeState(this);
	}

	public void run() {
		
		try {
			while(!this.isInterrupted()) {
				this.serverState.handle();
			}
			
		} catch (ServerException e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) out.close();
				if (in != null) in.close();
				clientSocket.close();
				System.out.println("Connection closed for client: " + this.getClientHostname());
			} catch (IOException e2) {e2.printStackTrace();}
		}
	}

	public ServerState getServerState() {
		return serverState;
	}
	
	public void setServerState(ServerState serverState) {
		this.serverState = serverState;
	}

	public Socket getClientSocket() {
		return clientSocket;
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
	
	public String getClientHostname() {
		return this.clientSocket.getInetAddress().getCanonicalHostName();
	}
}