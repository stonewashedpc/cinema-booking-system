package client.controllers;

import client.Client;
import client.CommandCallback;
import client.CommandExecutorService;
import client.forms.AdminDialogForm;
import generated.cinemaService.Film;
import generated.cinemaService.Hall;
import generated.cinemaService.commands.Film_constructor_Command;
import generated.cinemaService.commands.Hall_constructor_Command;

public class AdminDialogController extends Controller<Client, AdminDialogForm> {
	
	private CommandExecutorService executorService;

	public AdminDialogController(Client model, AdminDialogForm view) {
		super(model, view);
		this.executorService = new CommandExecutorService(model);
	}

	@Override
	protected void init() {
		this.view.getButtonCreateHall().addActionListener((e) -> {
			String hallName = this.view.getTextFieldHallName().getText();
			if (hallName.equals("")) {
				view.getLogLabel().setText("Please enter a name for the new hall first");
				return;
			}
			this.executorService.queueCommand(new Hall_constructor_Command(hallName), new CommandCallback<Hall>() {

				@Override
				protected void onSuccess(Hall result) {
					view.getLogLabel().setText(String.format("Created new hall \"%s\" successfully", result.getName()));
				}

				@Override
				protected void onException(Exception exception) {
					view.getLogLabel().setText(exception.getMessage());
					exception.printStackTrace();
				}
			});
		});
		this.view.getButtonCreateFilm().addActionListener((e) -> {
			String filmName = this.view.getTextFieldFilmName().getText();
			if (filmName.equals("")) {
				view.getLogLabel().setText("Please enter a name for the new film first");
				return;
			}
			this.executorService.queueCommand(new Film_constructor_Command(filmName), new CommandCallback<Film>() {

				@Override
				protected void onSuccess(Film result) {
					view.getLogLabel().setText(String.format("Created new film \"%s\" successfully", result.getName()));
				}

				@Override
				protected void onException(Exception exception) {
					view.getLogLabel().setText(exception.getMessage());
					exception.printStackTrace();
				}
			});
		});
	}

}
