package server;

import java.util.ArrayList;
import java.util.Collection;

import exceptions.ServerException;
import generated.cinemaService.Back;
import generated.cinemaService.CShow;
import generated.cinemaService.Category;
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
		
		try {
			CinemaService.getInstance().register("Customer", "bobross1942");
			CinemaService.getInstance().register("Admin", "hakunamatata", Owner.getInstance());
		} catch(ServerException exc) {
			exc.printStackTrace();
		}
		
		Film film1 = CinemaService.getInstance().addFilm("Harry Potter");
		Film film2 = CinemaService.getInstance().addFilm("Spider Man");
		Film film3 = CinemaService.getInstance().addFilm("Star Wars");
		Film film4 = CinemaService.getInstance().addFilm("American Pie");
		Film film5 = CinemaService.getInstance().addFilm("The Wolf of Wallstreet");
		Hall hall1 = CinemaService.getInstance().addHall("Kinosaal 1");
		Hall hall2 = CinemaService.getInstance().addHall("Kinosaal 2");
		
		createRow(1, 5, Parterre.getInstance(), hall1);
		createRow(2, 7, Middle.getInstance(), hall1);
		createRow(3, 10, Back.getInstance(), hall1);
		
		createRow(1, 3, Parterre.getInstance(), hall2);
		createRow(2, 5, Middle.getInstance(), hall2);
		createRow(3, 10, Middle.getInstance(), hall2);
		createRow(4, 10, Back.getInstance(), hall2);
		createRow(5, 8, Back.getInstance(), hall2);
		
		show1 = hall1.addShow(film1);
		CShow show2 = hall1.addShow(film2);
		CShow show3 = hall2.addShow(film3);
		CShow show4 = hall2.addShow(film4);
		CShow show5 = hall1.addShow(film5);
		hall2.addShow(film1);
		show1.setOpenForReservations();
		show2.setOpenForReservations();
		show3.setOpenForReservations();
		show4.setOpenForReservations();
		show5.setOpenForReservations();
	}
	
	private static void createRow(int rowNr, int seatCount, Category c, Hall hall) {
		SeatingRow row = SeatingRow.createFresh(c, rowNr, hall);
		for (int i = 1; i < seatCount + 1; i++) {
			Seat.createFresh(i, row);
		}
	}
	
	public static CShow getShow() {
		return show1;
	}
}
