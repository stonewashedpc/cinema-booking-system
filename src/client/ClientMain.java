package client;

import exceptions.ClientException;
import generated.cinemaService.Film;
import generated.cinemaService.User;
import generated.cinemaService.commands.Film_constructor_Command;
import generated.cinemaService.commands.Hall_constructor_Command;
import generated.cinemaService.commands.login_Command;
import generated.cinemaService.commands.logout_Command;
import generated.cinemaService.commands.register_Command;
import generated.cinemaService.commands.cShow.CShow_calculateTotalIncome_Command;

public class ClientMain {

	public static void main(String[] args) {
		try {
			Client client = new Client("127.0.0.1", 6666);
			
			client.connect();
			
			CommandExecutorService service = new CommandExecutorService(client);
			
//			service.queueCommand(new register_Command("Erika Musterfrau", "1234512345"), new CommandCallback<User>() {
//
//				@Override
//				protected void onSuccess(User result) {
//					System.out.println("Registered user: " + result.getUsername());
//				}
//
//				@Override
//				protected void onException(Exception exception) {
//					exception.printStackTrace();
//				}
//			});
			
			service.queueCommand(new login_Command("Erika Musterfrau", "1234512345"), new CommandCallback<String>() {

				@Override
				protected void onSuccess(String result) {
					
					System.out.println("Login successful. AuthToken is: " + result);
					
					String authToken = result;
					
				}

				@Override
				protected void onException(Exception exception) {
					exception.printStackTrace();
				}
			});
			
//			service.queueCommand(new login_Command("Erika Musterfrau", "1234512345"), new CommandCallback<String>() {
//
//				@Override
//				protected void onSuccess(String result) {
//					
//					System.out.println("Login successful. AuthToken is: " + result);
//					
//					String authToken = result;
//
//					Film_constructor_Command command = new Film_constructor_Command("TestFilm");
//					
//					command.setAuthToken(authToken);
//					
//					service.queueCommand(command, new CommandCallback<Film>() {
//
//						@Override
//						protected void onSuccess(Film result) {
//							System.out.println("Film created successfully: " + result.getName());
//							
//							logout_Command logoutCommand = new logout_Command(authToken);
//							
//							logoutCommand.setAuthToken(authToken);
//							
//							service.queueCommand(logoutCommand, new CommandCallback<Void>() {
//
//								@Override
//								protected void onSuccess(Void result) {
//									System.out.println("Logout successful");
//									
//									Film_constructor_Command command = new Film_constructor_Command("TestFilm");
//									
//									command.setAuthToken(authToken);
//									
//									service.queueCommand(command, new CommandCallback<Film>() {
//
//										@Override
//										protected void onSuccess(Film result) {
//											System.out.println("Film created successfully: " + result.getName());
//										}
//
//										@Override
//										protected void onException(Exception exception) {
//											exception.printStackTrace();
//										}
//									});
//								}
//
//								@Override
//								protected void onException(Exception exception) {
//									exception.printStackTrace();
//								}
//							});
//						}
//
//						@Override
//						protected void onException(Exception exception) {
//							exception.printStackTrace();
//						}
//					});
//					
//					
//				}
//
//				@Override
//				protected void onException(Exception exception) {
//					exception.printStackTrace();
//				}
//			});
			
			
			
		} catch (ClientException e) {
			e.printStackTrace();
		}
	}

}
