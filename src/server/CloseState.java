package server;

public class CloseState extends ServerState {

	public CloseState(ServerThread myServerThread) {
		super(myServerThread);
	}

	@Override
	public void handle() {
		System.out.println("ServerThread interrupted for client: " + this.getMyServerThread().getClientHostname());
		this.getMyServerThread().interrupt();
	}

}
