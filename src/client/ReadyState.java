package client;

import java.io.IOException;
import java.net.SocketTimeoutException;

import commands.Command;

public class ReadyState extends ClientState {

	public ReadyState(Client myClient) {
		super(myClient);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void connect() throws IOException {
		return; // Already connected
	}
	
	@Override
	public <R> Command<R> executeCommand(Command<R> command)
			throws IOException, InterruptedException, ClassNotFoundException {
		this.getMyClient().getMutex().acquire();
		Command<R> commandResult = null;
		try {
			this.getMyClient().getOut().writeObject(command);
		        commandResult = (Command<R>) this.getMyClient().getIn().readObject();
		} catch (SocketTimeoutException e) {
		        // handle timeout (return command with exception?)
		} finally {
			this.getMyClient().getMutex().release();
		}
		return commandResult;
	}
}
