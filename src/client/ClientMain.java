package client;

import java.io.IOException;

import generated.cinemaService.Film;
import generated.cinemaService.commands.Film_constructor_Command;

public class ClientMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Client client = new Client("127.0.0.1", 6666);
			
			client.connect();
			
			CommandExecutorService service = new CommandExecutorService(client);
			
			for (int i = 1; i < 11; i++) {
				service.queueCommand(new Film_constructor_Command("Der Film " + String.valueOf(i)), new CommandCallback<Film>() {

					@Override
					protected void onException(Exception exception) {
						// TODO Auto-generated method stub
						System.out.println("Client: An Exception ocurred");
						exception.printStackTrace();
					}

					@Override
					protected void onSuccess(Film result) {
						// TODO Auto-generated method stub
						System.out.println("Client: Received result from Server: " + result.getName());
					}
				});
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
