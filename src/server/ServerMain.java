package server;

import generated.cinemaService.CinemaService;

public class ServerMain {

	public static void main(String[] args) {
		CinemaService.getInstance();
		Server server = new Server(6666);
		server.start();
	}

}
