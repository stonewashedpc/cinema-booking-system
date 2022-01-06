package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import database.ResetDB;
import generated.cinemaService.AuthenticationException;
import generated.cinemaService.CinemaService;

class TestServerMain {
	
	private static String authToken;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		ResetDB resetDB = new ResetDB();
		resetDB.resestDBForTest();
		authToken = "";
		
		CinemaService.getInstance().register("Erika Musterfrau", "1234512345");
	}
	
	@Test
	public void userLoginTest() {
		try {
			CinemaService.getInstance().login("Erika Musterfrau", "123"); 
		    fail("Exception not thrown when expected!");
		} catch (AuthenticationException expectedException) {
		}
		try {
			CinemaService.getInstance().login("Erika", "123"); 
		    fail("Exception not thrown when expected!");
		} catch (AuthenticationException expectedException) {
		}
		try {
			CinemaService.getInstance().login("Erika", "1234512345"); 
		    fail("Exception not thrown when expected!");
		} catch (AuthenticationException expectedException) {
		}
		try {
			authToken = CinemaService.getInstance().login("Erika Musterfrau", "1234512345"); 
		} catch (AuthenticationException unexpectedException) {
			fail("Exception thrown when not expected!");
		}
	}

	@Test
	public void userLogoutTest() {
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
}
