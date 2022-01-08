package server;

import java.util.ArrayList;
import java.util.Collection;

import generated.cinemaService.Back;
import generated.cinemaService.CShow;
import generated.cinemaService.CinemaService;
import generated.cinemaService.Film;
import generated.cinemaService.Hall;
import generated.cinemaService.Middle;
import generated.cinemaService.Owner;
import generated.cinemaService.Parterre;
import generated.cinemaService.Seat;
import generated.cinemaService.SeatingRow;

public class DatabaseInitializer {
	
	private static CShow show1;
	
	public static void main(String args[]) {
		databaseInitializer();
	}

	public static void databaseInitializer() {
		CinemaService.getInstance();
		
		Parterre.getInstance().setPrice(599);
		Middle.getInstance().setPrice(899);
		Back.getInstance().setPrice(1299);
		
		Parterre.getInstance().setName("Parkett");
		Middle.getInstance().setName("Mitte");
		Back.getInstance().setName("Hinten");
		
		CinemaService.getInstance().register("Customer", "1234512345");
		CinemaService.getInstance().register("Admin", "1234512345", Owner.getInstance());
		
		Film film1 = CinemaService.getInstance().addFilm("Bob der Baumeister");
		Film film2 = CinemaService.getInstance().addFilm("Der rosarote Panther");
		Hall hall1 = CinemaService.getInstance().addHall("Kinosaal");
		
		SeatingRow row1 = SeatingRow.createFresh(Parterre.getInstance(), 1, hall1);
		SeatingRow row2 = SeatingRow.createFresh(Middle.getInstance(), 2, hall1);
		SeatingRow row3 = SeatingRow.createFresh(Back.getInstance(), 3, hall1);
		
		Seat seat1 = Seat.createFresh(1, row1); 
		Seat seat2 = Seat.createFresh(2, row1);
		Seat seat3 = Seat.createFresh(3, row1);
		
		Seat seat4 = Seat.createFresh(1, row2);
		Seat seat5 = Seat.createFresh(2, row2);
		Seat seat6 = Seat.createFresh(3, row2);
		
		Seat seat7 = Seat.createFresh(1, row3);
		Seat seat8 = Seat.createFresh(2, row3);
		Seat seat9 = Seat.createFresh(3, row3);
		
		show1 = hall1.addShow(film1);
		CShow show2 = hall1.addShow(film2);
		show1.setOpenForReservations();
		show2.setOpenForReservations();
		
		Collection<Seat> seats = new ArrayList<Seat>();
		seats.add(seat1);
		seats.add(seat2);
		seats.add(seat3);
		seats.add(seat5);
		seats.add(seat8);
		seats.add(seat9);
		CinemaService.getInstance().reserve(CinemaService.getInstance().getUserByUsername("Customer"), seats, show1);
	}
	
	public static CShow getShow() {
		return show1;
	}
}
