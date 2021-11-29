package authentication;

import java.util.Arrays;
import java.util.HashSet;

import generated.cinemaService.commands.logout_Command;
import generated.cinemaService.commands.reserve_Command;

public class CustomerWhiteList extends CommandWhitelist {

	private static CustomerWhiteList instance;

	private CustomerWhiteList() {
		super();
		this.setWhiteList(new HashSet<Class<?>>(Arrays.asList(logout_Command.class, reserve_Command.class))); // Define Customer Commands Here
		this.includeWhiteList(DefaultWhitelist.getInstance());
	}

	public static CustomerWhiteList getInstance() {
		if (instance == null) {
			instance = new CustomerWhiteList();
		}
		return instance;
	}
}
