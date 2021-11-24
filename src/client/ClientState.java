package client;

import java.io.IOException;

import commands.Command;

public abstract class ClientState {
	
	private Client myClient;
	public ClientState(Client myClient) {
		this.myClient = myClient;
	}
	
	public abstract void connect() throws IOException;
	
	public abstract <R> Command<R> executeCommand(Command<R> command) throws IOException, InterruptedException, ClassNotFoundException;
	
	protected Client getMyClient(){
		return this.myClient;
	}
}
