package authentication;

import java.util.Arrays;
import java.util.HashSet;

import generated.cinemaService.commands.CShow_constructor_Command;
import generated.cinemaService.commands.Film_constructor_Command;
import generated.cinemaService.commands.Hall_constructor_Command;
import generated.cinemaService.commands.getFilms_Command;
import generated.cinemaService.commands.getHalls_Command;
import generated.cinemaService.commands.getShows_Command;
import generated.cinemaService.commands.cShow.CShow_calculateTotalIncome_Command;
import generated.cinemaService.commands.cShow.CShow_setOpenForReservations_Command;
import generated.cinemaService.commands.cShow.CShow_setReservable_Command;

public class OwnerWhiteList extends CommandWhitelist {

	private static OwnerWhiteList instance;

	private OwnerWhiteList() {
		super();
		this.setWhiteList(new HashSet<Class<?>>(Arrays.asList(Hall_constructor_Command.class,
				Film_constructor_Command.class, getHalls_Command.class, getShows_Command.class, getFilms_Command.class,
				CShow_constructor_Command.class, CShow_setReservable_Command.class,
				CShow_setOpenForReservations_Command.class, CShow_calculateTotalIncome_Command.class))); // Define
		// Owner
		// Commands Here
		this.includeWhiteList(CustomerWhiteList.getInstance());
	}

	public static OwnerWhiteList getInstance() {
		if (instance == null) {
			instance = new OwnerWhiteList();
		}
		return instance;
	}
}
