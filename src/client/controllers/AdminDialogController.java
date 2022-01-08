package client.controllers;

import java.util.Collection;
import java.util.List;

import client.CShowCell;
import client.CellCollections;
import client.Client;
import client.CommandCallback;
import client.CommandExecutorService;
import client.FilmCell;
import client.HallCell;
import client.forms.AdminDialogForm;
import generated.cinemaService.CShow;
import generated.cinemaService.Film;
import generated.cinemaService.Hall;
import generated.cinemaService.commands.CShow_constructor_Command;
import generated.cinemaService.commands.Film_constructor_Command;
import generated.cinemaService.commands.Hall_constructor_Command;
import generated.cinemaService.commands.getFilms_Command;
import generated.cinemaService.commands.getHalls_Command;
import generated.cinemaService.commands.getShows_Command;
import generated.cinemaService.commands.cShow.CShow_setOpenForReservations_Command;
import generated.cinemaService.commands.cShow.CShow_setReservable_Command;

public class AdminDialogController extends Controller<Client, AdminDialogForm> {
	
	private CommandExecutorService executorService;

	public AdminDialogController(Client model, AdminDialogForm view) {
		super(model, view);
		this.executorService = new CommandExecutorService(model);
		loadData();
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
					try {
						view.getObservableListHalls().add(new HallCell(result).initialize(model));
					} catch (Exception e) {
						view.getLogLabel().setText(e.getMessage());
						e.printStackTrace();
					}
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
					try {
						view.getObservableListFilms().add(new FilmCell(result).initialize(model));
					} catch (Exception e) {
						view.getLogLabel().setText(e.getMessage());
						e.printStackTrace();
					}
					view.getLogLabel().setText(String.format("Created new film \"%s\" successfully", result.getName()));
				}

				@Override
				protected void onException(Exception exception) {
					view.getLogLabel().setText(exception.getMessage());
					exception.printStackTrace();
				}
			});
		});
		this.view.getButtonCreateShow().addActionListener((e) -> {
			int filmIndex = view.getComboBoxFilm().getSelectedIndex();
			int hallIndex = view.getComboBoxHall().getSelectedIndex();
			if(filmIndex == -1 || hallIndex == -1) {
				view.getLogLabel().setText("Select a hall and film first");
				return;
			}
			Film film = view.getObservableListFilms().get(filmIndex).getObject();
			Hall hall = view.getObservableListHalls().get(hallIndex).getObject();
			this.executorService.queueCommand(new CShow_constructor_Command(film, false, hall), new CommandCallback<CShow>() {

				@Override
				protected void onSuccess(CShow result) {
					try {
						view.getObservableListShows().add(new CShowCell(result).initialize(model));
					} catch (Exception e) {
						view.getLogLabel().setText(e.getMessage());
						e.printStackTrace();
					}
					view.getLogLabel().setText("Created new Show successfully");
				}

				@Override
				protected void onException(Exception exception) {
					view.getLogLabel().setText(exception.getMessage());
					exception.printStackTrace();
				}
			});
		});
		// TODO Boolean attribute change does not update until server restart
		this.view.getButtonSetOpenForReservations().addActionListener((e) -> {
			int selectionIndex = this.view.getListViewShows().getSelectedRow();
			if(selectionIndex == -1) return;
			CShowCell selectedCell = this.view.getObservableListShows().get(selectionIndex);
			if(selectedCell.getReservable()) {
				view.getLogLabel().setText("Alreay open for reservations");
				return;
			}
			executorService.queueCommand(new CShow_setOpenForReservations_Command(selectedCell.getObject()), new CommandCallback<Void>() {

				@Override
				protected void onSuccess(Void result) {
					selectedCell.setReservable(true);
					replaceListElement(view.getObservableListShows(), selectionIndex, selectedCell);
					view.getLogLabel().setText("Successfully opened for reservations");
				}

				@Override
				protected void onException(Exception exception) {
					view.getLogLabel().setText(exception.getMessage());
					exception.printStackTrace();
				}
			});
		});
		this.view.getListViewShows().getSelectionModel().addListSelectionListener((e) -> {
			int selectionIndex = this.view.getListViewShows().getSelectedRow();
			if(selectionIndex == -1) {
				this.view.getButtonSetOpenForReservations().setEnabled(false);
				return;
			}
			CShowCell selectedCell = this.view.getObservableListShows().get(selectionIndex);
			this.view.getButtonSetOpenForReservations().setEnabled(!selectedCell.getReservable());
		});
		this.view.getOkButton().addActionListener((e) -> {
			this.view.dispose();
		});
	}
	
	private <T> void replaceListElement(List<T> list, int index, T newElement) {
		list.remove(index);
		list.add(index, newElement);
	}
	
	private void loadData() {
		this.executorService.queueCommand(new getHalls_Command(), new CommandCallback<Collection<Hall>>() {

			@Override
			protected void onSuccess(Collection<Hall> result) {
				try {
					view.getObservableListHalls().addAll(CellCollections.toHallCellCollection(result, model));
				} catch (Exception e) {
					view.getLogLabel().setText(e.getMessage());
					e.printStackTrace();
				}
			}

			@Override
			protected void onException(Exception exception) {
				view.getLogLabel().setText(exception.getMessage());
				exception.printStackTrace();
			}
		});
		this.executorService.queueCommand(new getFilms_Command(), new CommandCallback<Collection<Film>>() {

			@Override
			protected void onSuccess(Collection<Film> result) {
				try {
					view.getObservableListFilms().addAll(CellCollections.toFilmCellCollection(result, model));
				} catch (Exception e) {
					view.getLogLabel().setText(e.getMessage());
					e.printStackTrace();
				}
			}

			@Override
			protected void onException(Exception exception) {
				view.getLogLabel().setText(exception.getMessage());
				exception.printStackTrace();
			}
		});
		this.executorService.queueCommand(new getShows_Command(), new CommandCallback<Collection<CShow>>() {

			@Override
			protected void onSuccess(Collection<CShow> result) {
				try {
					view.getObservableListShows().addAll(CellCollections.toCShowCellCollection(result, model));
				} catch (Exception e) {
					view.getLogLabel().setText(e.getMessage());
					e.printStackTrace();
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
