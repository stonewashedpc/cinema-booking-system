package mdeGen.observation;

import mdeGen.commands.Command;

public interface Observer {
	public void update(Command<?> command);
}
