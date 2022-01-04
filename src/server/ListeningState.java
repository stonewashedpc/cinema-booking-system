package server;

import authentication.AuthenticationService;
import authentication.DefaultWhitelist;
import commands.Command;
import exceptions.ServerException;
import generated.cinemaService.AuthenticationException;

public class ListeningState extends ServerState {

	public ListeningState(ServerThread serverThread) {
		super(serverThread);
	}

	@Override
	public void handle() throws ServerException {
		System.out.println("ServerThread listening to " + this.getMyServerThread().getClientHostname());
		try {
			Command<?> next;
			while ((next = (Command<?>) this.getMyServerThread().getIn().readObject()) != null) {
				System.out.println("Processing new command for client: " + this.getMyServerThread().getClientHostname());
				
				try {
					if (next.getAuthToken() == null) { // No AuthToken
						if(DefaultWhitelist.getInstance().isWhitelisted(next.getClass())) { // Default Permissions sufficient
							next.execute();
						} else throw new AuthenticationException("Insufficient permissions to execute command: " + next.getClass().getCanonicalName()); // Insufficient Default Permissions
					} else if (AuthenticationService.getInstance().findRole(next.getAuthToken()).getCommandWhitelist().isWhitelisted(next.getClass())) { // Role Permissions sufficient
						next.execute();
					} else throw new AuthenticationException("Insufficient permissions to execute command: " + next.getClass().getCanonicalName()); // Insufficient Role Permissions
				} catch (AuthenticationException e) {
					next.setE(e); // Invalid AuthToken
				} finally {
					this.getMyServerThread().getOut().writeObject(next);
				}
				
			}
		} catch (Exception e) {
			throw new ServerException("An error occurred while handling commands for client: "
					+ this.getMyServerThread().getClientHostname(), e);
		}
	}
}
