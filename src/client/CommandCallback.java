package client;

import mdeGen.commands.Command;

public abstract class CommandCallback<R> {

	public void complete(Command<R> command) {
		try {
			this.onSuccess(command.getResult());
		} catch (Exception e) {
			this.onException(e);
		}
	}

	protected abstract void onSuccess(R result);

	protected abstract void onException(Exception exception);
}