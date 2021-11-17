package observation;

import commands.Command;

public interface Observer {
	public void update(Command<?> command);
}
