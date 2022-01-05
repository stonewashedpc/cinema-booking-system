package client.controllers;

import java.util.Collection;
import java.util.List;

import client.CellCollections;
import client.Client;
import client.CommandCallback;
import client.CommandExecutorService;
import client.ReservationCell;
import client.forms.ReservationsDialogForm;
import generated.cinemaService.Booking;
import generated.cinemaService.Reservation;
import generated.cinemaService.commands.getReservations_Command;
import generated.cinemaService.commands.reservation.Reservation_book_Command;
import generated.cinemaService.commands.reservation.Reservation_cancel_Command;

public class ReservationsDialogController extends Controller<Client, ReservationsDialogForm> {

	private CommandExecutorService executorService;

	public ReservationsDialogController(Client model, ReservationsDialogForm view) {
		super(model, view);
		this.executorService = new CommandExecutorService(model);
		loadData();
	}

	@Override
	protected void init() {
		this.view.getButtonOk().addActionListener((e) -> {
			this.view.dispose();
		});
		this.view.getButtonBookReservation().addActionListener((e) -> {
			int selectionIndex = this.view.getListViewReservations().getSelectedRow();
			ReservationCell selectedCell = this.view.getObservableListReservations().get(selectionIndex);
			this.executorService.queueCommand(new Reservation_book_Command(selectedCell.getObject()), new CommandCallback<Booking>() {

				@Override
				protected void onSuccess(Booking result) {
					view.getLogLabel().setText(String.format("Successfully booked reservation for %s in %s", selectedCell.getFilmName(), selectedCell.getHallName()));
					selectedCell.setIsBooked(true);
					replaceListElement(view.getObservableListReservations(), selectionIndex, selectedCell);
				}

				@Override
				protected void onException(Exception exception) {
					view.getLogLabel().setText(exception.getMessage());
				}
			});
		});
		this.view.getButtonCancelReservation().addActionListener((e) -> {
			int selectionIndex = this.view.getListViewReservations().getSelectedRow();
			ReservationCell selectedCell = this.view.getObservableListReservations().get(selectionIndex);
			this.executorService.queueCommand(new Reservation_cancel_Command(selectedCell.getObject()), new CommandCallback<Void>() {

				@Override
				protected void onSuccess(Void result) {
					view.getLogLabel().setText(String.format("Successfully canceled reservation for %s in %s", selectedCell.getFilmName(), selectedCell.getHallName()));
					view.getObservableListReservations().remove(selectionIndex);
				}

				@Override
				protected void onException(Exception exception) {
					view.getLogLabel().setText(exception.getMessage());
				}
			});
		});
		this.view.getListViewReservations().getSelectionModel().addListSelectionListener((e) -> {
			int selectionIndex = this.view.getListViewReservations().getSelectedRow();
			if(selectionIndex == -1) {
				this.view.getButtonBookReservation().setEnabled(false);
				this.view.getButtonCancelReservation().setEnabled(false);
				return;
			}
			ReservationCell selectedCell = this.view.getObservableListReservations().get(selectionIndex);
			this.view.getButtonBookReservation().setEnabled(!selectedCell.getIsBooked());
			this.view.getButtonCancelReservation().setEnabled(!selectedCell.getIsBooked());
		});
	}
	
	private <T> void replaceListElement(List<T> list, int index, T newElement) {
		list.remove(index);
		list.add(index, newElement);
	}

	private void loadData() {
		this.executorService.queueCommand(new getReservations_Command(),
				new CommandCallback<Collection<Reservation>>() {

					@Override
					protected void onSuccess(Collection<Reservation> result) {
						try {
							view.getObservableListReservations()
									.addAll(CellCollections.toReservationCellCollection(result, model));
						} catch (Exception e) {
							e.printStackTrace();
							view.getLogLabel().setText(e.getMessage());
						}
					}

					@Override
					protected void onException(Exception exception) {
						exception.printStackTrace();
						view.getLogLabel().setText(exception.getMessage());
					}
				});
	}
}
