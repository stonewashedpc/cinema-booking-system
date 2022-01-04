package server;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import generated.cinemaService.Back;
import generated.cinemaService.CShow;
import generated.cinemaService.CinemaService;
import generated.cinemaService.Film;
import generated.cinemaService.Hall;
import generated.cinemaService.Middle;
import generated.cinemaService.Parterre;
import generated.cinemaService.Seat;
import generated.cinemaService.SeatingRow;
import generated.cinemaService.User;
import generated.cinemaService.proxies.CShowProxy;

public class ServerMain {

	public static void main(String[] args) {
		CinemaService.getInstance();
		
		// Set prices
		Parterre.getInstance().setPrice(599);
		Middle.getInstance().setPrice(899);
		Back.getInstance().setPrice(1299);
		
		Parterre.getInstance().setName("Parkett");
		Middle.getInstance().setName("Mitte");
		Back.getInstance().setName("Hinten");
		
		Server server;
		try {
			server = new Server(6666);
			server.start();
			System.out.println("Server started.");
		} catch (IOException e) {e.printStackTrace();}
	}
}
