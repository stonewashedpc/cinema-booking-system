package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import client.Client;
import database.ResetDB;
import generated.cinemaService.CinemaService;
import generated.cinemaService.commands.Film_constructor_Command;
import generated.cinemaService.commands.getReservableShows_Command;
import generated.cinemaService.commands.login_Command;
import generated.cinemaService.commands.cShow.CShow_calculateTotalIncome_Command;
import server.DatabaseInitializer;
import server.Server;

class TestForAuthentification {
	
	private static String authToken;
	private static Client client;
	private static Server server;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		ResetDB resetDB = new ResetDB();
		resetDB.resestDBForTest();
		authToken = "";
		DatabaseInitializer.databaseInitializer();
		
		server = new Server(6666);
		server.start();
		client = new Client("127.0.0.1", 6666);
		client.connect();
	}
	
	@Test 
	public void authentication() {
		//no user logged in to client
		try {
			client.executeCommand(new getReservableShows_Command()).getResult();
			fail("Exception not thrown when expected!");
		} catch (Exception e) {
			//Exception expected!
		}
		
		//login user 
		try {
			authToken = client.executeCommand(new login_Command("Customer", "1234512345")).getResult();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		client.setAuthToken(authToken);
		
		//successfull data request
		try {
			client.executeCommand(new getReservableShows_Command()).getResult();
		} catch (Exception e) {
			fail("Exception thrown when not expected!"); 
		}
		
		//no access rights
		try {
			client.executeCommand(new CShow_calculateTotalIncome_Command(CinemaService.getInstance().getCShow(1))).getResult();
			fail("Exception not thrown when expected!");
		} catch (Exception e) {
			//Exception expected!
		}
		try {
			client.executeCommand(new Film_constructor_Command("Neuer Film")).getResult();
			fail("Exception not thrown when expected!");
		} catch (Exception e) {
			//Exception expected!
		}
		
		//login admin 
		try {
			authToken = client.executeCommand(new login_Command("Admin", "1234512345")).getResult();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		client.setAuthToken(authToken);
		//execute admin commands
		try {
			client.executeCommand(new CShow_calculateTotalIncome_Command(DatabaseInitializer.getShow()));
		} catch (Exception e) {
			fail("Exception thrown when not expected!");
		}
		try {
			client.executeCommand(new Film_constructor_Command("Neuer Film")).getResult();
		} catch (Exception e) {
			fail("Exception thrown when not expected!"); 
		}
	}
}
