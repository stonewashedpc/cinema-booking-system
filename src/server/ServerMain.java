package server;

import java.io.IOException;

import generated.cinemaService.CinemaService;

public class ServerMain {

	public static void main(String[] args) {
		CinemaService.getInstance();
		Server server;
		try {
			server = new Server(6666);
			server.start();
			System.out.println("Server started.");
		} catch (IOException e) {e.printStackTrace();}
	}
}
