package client;

import commands.Command;
import exceptions.ClientException;

public class InitialState extends ClientState {

	public InitialState(Client myClient) {
		super(myClient);
	}

	@Override
	public void connect() throws ClientException {
		this.getMyClient().setClientState(new HandshakeState(this.getMyClient()));
		this.getMyClient().connect();
	}

	@Override
	public <R> Command<R> executeCommand(Command<R> command)
			throws ClientException {
		throw new ClientException("Not connected");
	}

}
