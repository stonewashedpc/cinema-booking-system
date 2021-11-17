package client;

import commands.Command;

public class CommandTask<R> implements Runnable {
	private Command<R> command;
	public CommandCallback<R> callback;
	public Client client;

	public CommandTask(Command<R> command, Client client) {
		this.command = command;
		this.client = client;
	}

	public CommandTask(Command<R> command, Client client, CommandCallback<R> callback) {
		this.command = command;
		this.client = client;
		this.callback = callback;
	}

	public void run() {
		try {
		if(this.callback != null) {
		        this.callback.complete(this.client.executeCommand(this.command));
		} else this.client.executeCommand(this.command);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}