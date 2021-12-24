package authentication;

import java.util.Arrays;
import java.util.HashSet;

import generated.cinemaService.commands.getCShowCache_Command;
import generated.cinemaService.commands.getReservableShows_Command;
import generated.cinemaService.commands.logout_Command;
import generated.cinemaService.commands.reserve_Command;
import generated.cinemaService.commands.cShow.CShow_getFilm_Command;
import generated.cinemaService.commands.cShow.CShow_getHall_Command;
import generated.cinemaService.commands.cShow.CShow_getReservableSeats_Command;
import generated.cinemaService.commands.seat.Seat_getRow_Command;
import generated.cinemaService.commands.seatingRow.SeatingRow_getCategoryName_Command;
import generated.cinemaService.commands.seatingRow.SeatingRow_getCategory_Command;
import generated.cinemaService.commands.seatingRow.SeatingRow_getPrice_Command;

public class CustomerWhiteList extends CommandWhitelist {

	private static CustomerWhiteList instance;

	private CustomerWhiteList() {
		super();
		this.setWhiteList(new HashSet<Class<?>>(Arrays.asList(logout_Command.class, reserve_Command.class,
				getReservableShows_Command.class, CShow_getFilm_Command.class, CShow_getHall_Command.class,
				CShow_getReservableSeats_Command.class, SeatingRow_getCategory_Command.class, Seat_getRow_Command.class,
				SeatingRow_getPrice_Command.class, SeatingRow_getCategoryName_Command.class))); // Define Customer
																								// Commands
		// Here
		this.includeWhiteList(DefaultWhitelist.getInstance());
	}

	public static CustomerWhiteList getInstance() {
		if (instance == null) {
			instance = new CustomerWhiteList();
		}
		return instance;
	}
}
