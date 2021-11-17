package client;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import mdeGen.commands.Command;

public class CommandExecutorService {
	private ExecutorService executorService;
	public Client client;

	public CommandExecutorService(Client client) {
		this.client = client;
		this.executorService = Executors.newSingleThreadExecutor();
	}

	public <R> void queueCommand(Command<R> command) {
		executorService.execute(new CommandTask<R>(command, client));
	}

	public <R> void queueCommand(Command<R> command, CommandCallback<R> callback) {
		executorService.execute(new CommandTask<R>(command, client, callback));
	}
}