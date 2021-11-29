package authentication;

import java.util.Arrays;
import java.util.HashSet;

import generated.cinemaService.commands.Film_constructor_Command;

public class OwnerWhiteList extends CommandWhitelist {
	
	private static OwnerWhiteList instance;

	private OwnerWhiteList() {
		super();
		this.setWhiteList(new HashSet<Class<?>>(Arrays.asList(Film_constructor_Command.class))); // Define Owner Commands Here
		this.includeWhiteList(CustomerWhiteList.getInstance());
	}

	public static OwnerWhiteList getInstance() {
		if (instance == null) {
			instance = new OwnerWhiteList();
		}
		return instance;
	}
}
