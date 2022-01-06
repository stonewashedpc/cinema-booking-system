package client;

import client.controllers.LoginController;
import client.forms.LoginForm;
import exceptions.ClientException;

public class ClientMain {

	public static void main(String[] args) {
		try {
			Client client = new Client("127.0.0.1", 6666);
			
			client.connect();
			
			LoginForm form = new LoginForm();
			new LoginController(client, form);
			
			form.setVisible(true);
			
		} catch (ClientException e) {
			e.printStackTrace();
		}
	}

}
