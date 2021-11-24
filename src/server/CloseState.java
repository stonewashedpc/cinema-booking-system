package server;

import java.io.IOException;

public class CloseState extends ServerState {

	public CloseState(ServerThread myServerThread) {
		super(myServerThread);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handle() throws IOException, ClassNotFoundException {
		System.out.println("ServerThread interrupt");
		this.getMyServerThread().interrupt();
	}

}
