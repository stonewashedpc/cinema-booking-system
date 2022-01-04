package client.controllers;

import java.util.Collection;

import client.CellCollections;
import client.Client;
import client.CommandCallback;
import client.CommandExecutorService;
import client.forms.ReservationsDialogForm;
import generated.cinemaService.Reservation;
import generated.cinemaService.commands.getReservations_Command;

public class ReservationsDialogController extends Controller<Client, ReservationsDialogForm> {
	
	private CommandExecutorService executorService;

	public ReservationsDialogController(Client model, ReservationsDialogForm view) {
		super(model, view);
		this.executorService = new CommandExecutorService(model);
		loadData();
	}

	@Override
	protected void init() {
		
	}
	
	private void loadData() {
		this.executorService.queueCommand(new getReservations_Command(), new CommandCallback<Collection<Reservation>>() {

			@Override
			protected void onSuccess(Collection<Reservation> result) {
				try {
					view.getObservableListReservations().addAll(CellCollections.toReservationCellCollection(result, model));
				} catch (Exception e) {
					e.printStackTrace();
					// TODO Output to UI
				}
			}

			@Override
			protected void onException(Exception exception) {
				exception.printStackTrace();
				// TODO Output to UI
			}
		});
	}
}
