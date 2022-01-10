package client.controllers;

import client.CShowCell;
import client.Client;
import client.CommandCallback;
import client.CommandExecutorService;
import client.forms.IncomeDialogForm;
import generated.cinemaService.commands.cShow.CShow_calculateTotalIncome_Command;

public class IncomeDialogController extends Controller<Client, IncomeDialogForm> {

	private CommandExecutorService executorService;

	public IncomeDialogController(Client model, IncomeDialogForm view, CShowCell show) {
		super(model, view);
		this.executorService = new CommandExecutorService(model);
		this.view.setTitle(String.format("Income for %s, %s", show.getHallName(), show.getFilmName()));
		this.executorService.queueCommand(new CShow_calculateTotalIncome_Command(show.getObject()), new CommandCallback<Integer>() {

			@Override
			protected void onSuccess(Integer result) {
				view.getLabelIncome().setText(String.format("Income: %s.%s Eur", Math.round((result - (result % 100)) / 100), Math.round((result % 100))));
			}

			@Override
			protected void onException(Exception exception) {
				view.getLogLabel().setText(exception.getMessage());
				exception.printStackTrace();
			}
		});
	}

	@Override
	protected void init() {
		this.view.getOkButton().addActionListener((e) -> {
			this.view.dispose();
		});
	}

}
