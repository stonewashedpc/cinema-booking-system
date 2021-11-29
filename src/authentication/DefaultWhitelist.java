package authentication;

import java.util.Arrays;
import java.util.HashSet;

import generated.cinemaService.commands.login_Command;
import generated.cinemaService.commands.logout_Command;
import generated.cinemaService.commands.register_Command;

public class DefaultWhitelist extends CommandWhitelist {
	
	private static DefaultWhitelist instance;
	
	private DefaultWhitelist() {
		super();
		this.setWhiteList(new HashSet<Class<?>>(Arrays.asList(register_Command.class, login_Command.class))); // Define Default Commands Here
	}
	
	public static DefaultWhitelist getInstance() {
		if (instance == null) {
			instance = new DefaultWhitelist();
		}
		return instance;
	}
}
