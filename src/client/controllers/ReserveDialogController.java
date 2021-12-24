package client.controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collection;

import client.CellCollections;
import client.Client;
import client.CommandCallback;
import client.CommandExecutorService;
import client.forms.ReserveDialogForm;
import generated.cinemaService.Seat;
import generated.cinemaService.commands.cShow.CShow_getReservableSeats_Command;

public class ReserveDialogController extends Controller<Client, ReserveDialogForm> {

	private CommandExecutorService executorService;

	public ReserveDialogController(Client model, ReserveDialogForm view) {
		super(model, view);
		this.executorService = new CommandExecutorService(model);
		loadData();
	}

	@Override
	protected void init() {
		this.view.setTitle(String.format("%s, %s reservieren", this.view.getcShowCell().getFilmName(), this.view.getcShowCell().getHallName()));
		this.view.getListViewSeats().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent event) {
				int[] selectedRows = view.getListViewSeats().getSelectedRows();
				Integer totalPrice = 0;
				if (selectedRows.length != 0) {
					for(int row : selectedRows) {
						totalPrice += view.getObservableListSeats().get(row).getPrice();
					}
				}
				view.getLabelPrice().setText(String.format("%s.%s Eur", Math.round((totalPrice - (totalPrice % 100)) / 100), Math.round((totalPrice % 100))));
				view.getLabelSeatCount().setText(String.valueOf(selectedRows.length));
			}
		});
	}
	
	private void loadData() {
		this.executorService.queueCommand(new CShow_getReservableSeats_Command(this.view.getcShowCell().getObject()), new CommandCallback<Collection<Seat>>() {

			@Override
			protected void onSuccess(Collection<Seat> result) {
				try {
					view.getObservableListSeats().addAll(CellCollections.toSeatCellCollection(result, model));
				} catch (Exception e) {
					e.printStackTrace();
					view.getLogLabel().setText("An error occurred while loading seats");
				}
			}

			@Override
			protected void onException(Exception exception) {
				view.getLogLabel().setText(exception.getMessage());
				exception.printStackTrace();
			}

		});
	}

}
