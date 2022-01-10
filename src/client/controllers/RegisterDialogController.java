package client.controllers;

import client.Client;
import client.CommandCallback;
import client.CommandExecutorService;
import client.forms.RegisterDialogForm;
import generated.cinemaService.commands.register_Command;
import generated.cinemaService.User;

public class RegisterDialogController extends Controller<Client, RegisterDialogForm> {

	private CommandExecutorService executorService;

	public RegisterDialogController(Client model, RegisterDialogForm view) {
		super(model, view);
		this.executorService = new CommandExecutorService(model);
	}

	@Override
	protected void init() {
		this.view.getButtonCancel().addActionListener((e) -> {
			this.view.dispose();
		});
		this.view.getButtonRegister().addActionListener((e) -> {
			String name = this.view.getUsernameField().getText();
			String password = String.valueOf(this.view.getPasswordField().getPassword());
			if(name == "" || password == "") {
				this.view.getLogLabel().setText("Please specify username and password.");
				return;
			}
			this.executorService.queueCommand(new register_Command(name, password), new CommandCallback<User>() {

				@Override
				protected void onSuccess(User result) {
					view.dispose();
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
