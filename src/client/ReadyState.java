package client;

import commands.Command;
import exceptions.ClientException;

public class ReadyState extends ClientState {

	public ReadyState(Client myClient) {
		super(myClient);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void connect() throws ClientException {
		throw new ClientException("already connected");
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <R> Command<R> executeCommand(Command<R> command) {
		Command<R> commandResult = null;
			try {
				this.getMyClient().getMutex().acquire();
				this.getMyClient().getOut().writeObject(command);
			        commandResult = (Command<R>) this.getMyClient().getIn().readObject();
			} catch (Exception e) {
				// handle exceptions (return command with Exception)
				command.setE(e);
				return command;
			} finally {
				this.getMyClient().getMutex().release();
			}
		return commandResult;
	}
}
