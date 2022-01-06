package client.controllers;

import java.awt.event.ActionEvent;

import client.Client;
import client.CommandCallback;
import client.CommandExecutorService;
import client.forms.MainForm;
import client.forms.LoginForm;
import generated.cinemaService.commands.login_Command;

public class LoginController extends Controller<Client, LoginForm> {
	
	private CommandExecutorService executorService;

	public LoginController(Client model, LoginForm view) {
		super(model, view);
		this.executorService = new CommandExecutorService(model);
	}

	@Override
	protected void init() {
		this.view.getLoginButton().addActionListener((event) -> {
			loginButtonClicked(event);
		});
	}
	
	private void loginButtonClicked(ActionEvent e) {
		this.executorService.queueCommand(new login_Command(this.view.getUsernameField().getText(), String.valueOf(this.view.getPasswordField().getPassword())), new CommandCallback<String>() {

			@Override
			protected void onSuccess(String result) {
				model.setAuthToken(result);
				MainForm form = new MainForm();
				new MainController(model, form);
				form.setVisible(true);
				view.dispose();
			}

			@Override
			protected void onException(Exception exception) {
				view.getLogLabel().setText(exception.getMessage());
			}
		});
	}
	
	
}
