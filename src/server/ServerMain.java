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
		
//		CinemaService.getInstance().register("Erika Musterfrau", "1234512345");
//		
//		Film film1 = CinemaService.getInstance().addFilm("Bob der Baumeister");
//		Film film2 = CinemaService.getInstance().addFilm("Der rosarote Panther");
//		Hall hall1 = CinemaService.getInstance().addHall("Halle 1");
//		
//		SeatingRow row1 = SeatingRow.createFresh(Parterre.getInstance(), 1, hall1);
//		SeatingRow row2 = SeatingRow.createFresh(Middle.getInstance(), 2, hall1);
//		SeatingRow row3 = SeatingRow.createFresh(Back.getInstance(), 3, hall1);
//		
//		Seat seat1 = Seat.createFresh(1, row1);
//		Seat seat2 = Seat.createFresh(2, row1);
//		Seat seat3 = Seat.createFresh(3, row1);
//		
//		Seat seat4 = Seat.createFresh(1, row2);
//		Seat seat5 = Seat.createFresh(2, row2);
//		Seat seat6 = Seat.createFresh(3, row2);
//		
//		Seat seat7 = Seat.createFresh(1, row3);
//		Seat seat8 = Seat.createFresh(2, row3);
//		Seat seat9 = Seat.createFresh(3, row3);
//		
//		CShow show1 = hall1.addShow(film1);
//		CShow show2 = hall1.addShow(film2);
//		show1.setOpenForReservations();
//		show2.setOpenForReservations();
//		
//		CinemaService.getInstance().reserve(CinemaService.getInstance().getUserByUsername("Erika Musterfrau"), seat1, show1);
//		CinemaService.getInstance().reserve(CinemaService.getInstance().getUserByUsername("Erika Musterfrau"), seat2, show1);
//		CinemaService.getInstance().reserve(CinemaService.getInstance().getUserByUsername("Erika Musterfrau"), seat3, show1);
//		CinemaService.getInstance().reserve(CinemaService.getInstance().getUserByUsername("Erika Musterfrau"), seat5, show1);
//		CinemaService.getInstance().reserve(CinemaService.getInstance().getUserByUsername("Erika Musterfrau"), seat8, show1);
//		CinemaService.getInstance().reserve(CinemaService.getInstance().getUserByUsername("Erika Musterfrau"), seat9, show1);
//		
//		System.out.println(show1.calculateTotalIncome());
		
		Server server;
		try {
			server = new Server(6666);
			server.start();
			System.out.println("Server started.");
		} catch (IOException e) {e.printStackTrace();}
	}
}
