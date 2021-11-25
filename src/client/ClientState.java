package client;

import commands.Command;
import exceptions.ClientException;

public abstract class ClientState {
	
	private Client myClient;
	public ClientState(Client myClient) {
		this.myClient = myClient;
	}
	
	public abstract void connect() throws ClientException;
	
	public abstract <R> Command<R> executeCommand(Command<R> command) throws ClientException;
	
	protected Client getMyClient(){
		return this.myClient;
	}
}
