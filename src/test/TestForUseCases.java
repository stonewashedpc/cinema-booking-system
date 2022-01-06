package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import database.ResetDB;
import exceptions.ConstraintViolation;
import generated.cinemaService.AuthenticationException;
import generated.cinemaService.Back;
import generated.cinemaService.CShow;
import generated.cinemaService.CinemaService;
import generated.cinemaService.Film;
import generated.cinemaService.Hall;
import generated.cinemaService.Middle;
import generated.cinemaService.Owner;
import generated.cinemaService.Parterre;
import generated.cinemaService.Reservation;
import generated.cinemaService.Seat;
import generated.cinemaService.SeatingRow;

class TestForUseCases {
	
	private static String authToken;
	private static SeatingRow row1;
	private static SeatingRow row2;
	private static SeatingRow row3;
	private static Hall hall1;
	private static Film film1;
	private static Film film2;
	private static CShow show1;
	private static CShow show2;
	private static Collection<Seat> seats;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		ResetDB resetDB = new ResetDB();
		resetDB.resestDBForTest();
		authToken = "";
		CinemaService.getInstance();
		
		Parterre.getInstance().setPrice(599);
		Middle.getInstance().setPrice(899); 
		Back.getInstance().setPrice(1299);
		
		Parterre.getInstance().setName("Parkett");
		Middle.getInstance().setName("Mitte");
		Back.getInstance().setName("Hinten");
		
		CinemaService.getInstance().register("Customer", "1234512345");
		CinemaService.getInstance().register("Admin", "1234512345", Owner.getInstance());
		
		film1 = CinemaService.getInstance().addFilm("Bob der Baumeister");
		film2 = CinemaService.getInstance().addFilm("Der rosarote Panther");
		hall1 = CinemaService.getInstance().addHall("Kinosaal 1");
		
		row1 = SeatingRow.createFresh(Parterre.getInstance(), 1, hall1);
		row2 = SeatingRow.createFresh(Middle.getInstance(), 2, hall1);
		row3 = SeatingRow.createFresh(Back.getInstance(), 3, hall1);
		
		Seat seat1 = Seat.createFresh(1, row1); 
		Seat seat2 = Seat.createFresh(2, row1);
		Seat seat3 = Seat.createFresh(3, row1);
		
		seats = new ArrayList<Seat>();
		seats.add(seat1);
		seats.add(seat2);
		seats.add(seat3);
		
		show1 = hall1.addShow(film1);
		show2 = hall1.addShow(film2);
	}
	
	@Test 
	public void userLogin() {
		try {
			CinemaService.getInstance().login("Erika Musterfrau", "123"); 
		    fail("Exception not thrown when expected!");
		} catch (AuthenticationException expectedException) {
		}
		try {
			CinemaService.getInstance().login("Cust", "123"); 
		    fail("Exception not thrown when expected!");
		} catch (AuthenticationException expectedException) {
		}
		try {
			CinemaService.getInstance().login("Cust", "1234512345");  
		    fail("Exception not thrown when expected!");
		} catch (AuthenticationException expectedException) {
		}
		try {
			authToken = CinemaService.getInstance().login("Customer", "1234512345"); 
		} catch (AuthenticationException unexpectedException) {
			fail("Exception thrown when not expected!");
		}
	}

	@Test
	public void userLogout() {
		try {
			CinemaService.getInstance().logout("WrongAuthToken");
		    fail("Exception not thrown when expected!");
		} catch (AuthenticationException expectedException) {
		}
		try {
			CinemaService.getInstance().logout(authToken);
		} catch (AuthenticationException unexpectedException) {
			fail("Exception thrown when not expected!");
		}
	}

	@Test
	public void setCategoryForRow() {
		row1.setCategory(Parterre.getInstance());
		row2.setCategory(Middle.getInstance());
		row3.setCategory(Back.getInstance());
		
		assertEquals(row1.getCategory(), Parterre.getInstance());
		assertEquals(row2.getCategory(), Middle.getInstance());
		assertEquals(row3.getCategory(), Back.getInstance());
	}

	@Test
	public void addFilmToHall() {
		assertTrue(hall1.getShow().contains(show1));
		assertTrue(hall1.getShow().contains(show2));
	}

	@Test
	public void openShowForReservations() { 
		show1.setOpenForReservations();
		show2.setOpenForReservations();
		
		assertTrue(show1.getReservable());
		assertTrue(show2.getReservable());
	}

	@Test
	public void reserveShow() {
		try {
			CinemaService.getInstance().login("Customer", "1234512345"); 
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}
		CinemaService.getInstance().reserve(CinemaService.getInstance().getUserByUsername("Customer"), seats, show1);
		for (Seat seat : seats) {
			assertTrue(!show1.getReservableSeats().contains(seat));
		}
	}

	@Test
	public void bookShow() {
		Collection<Reservation> ListOfReservation =CinemaService.getInstance().getReservations(CinemaService.getInstance().getUserByUsername("Customer"));
		for (Reservation reservation: ListOfReservation) {
			try {
				reservation.book();
			} catch (ConstraintViolation e) {
				e.printStackTrace();
			}
		}
		
		for (Reservation reservation: ListOfReservation) {
			assertTrue(reservation.isBooked());
		}
	}

	@Test
	public void checkTotalIncome() {
		assertEquals(show1.calculateTotalIncome(), 1797);
		assertEquals(show2.calculateTotalIncome(), 0);
	}
}
