package server;

import java.io.IOException;

import commands.Command;

public class ListeningState extends ServerState {

	public ListeningState(ServerThread serverThread) {
		super(serverThread);
	}

	@Override
	public void handle() throws IOException, ClassNotFoundException {
		System.out.println("Server listening");
		Command next;
		while ((next = (Command) this.getMyServerThread().getIn().readObject()) != null) {
			System.out.println("Processing new command");
			next.execute();
			this.getMyServerThread().getOut().writeObject(next);
		}
	}
}
