package server;

import exceptions.ServerException;

public abstract class ServerState {
	
	private ServerThread myServerThread;
	public ServerState(ServerThread myServerThread) {
		super();
		this.myServerThread = myServerThread;
	}
	
	public abstract void handle() throws ServerException;
	
	protected void endOfProcessing(){
		this.getMyServerThread().setServerState(new CloseState(this.getMyServerThread()));
	}
	protected ServerThread getMyServerThread(){
		return this.myServerThread;
	}
}
