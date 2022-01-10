package client.controllers;

import java.util.Collection;

import client.CellCollections;
import client.Client;
import client.CommandCallback;
import client.CommandExecutorService;
import client.HallCell;
import client.SeatingRowCell;
import client.forms.RowsDialogForm;
import generated.cinemaService.Category;
import generated.cinemaService.SeatingRow;
import generated.cinemaService.commands.Seat_constructor_Command;
import generated.cinemaService.commands.SeatingRow_constructor_Command;
import generated.cinemaService.commands.getCategories_Command;
import generated.cinemaService.commands.hall.Hall_getRows_Command;

public class RowsDialogController extends Controller<Client, RowsDialogForm> {

	private CommandExecutorService executorService;
	private HallCell hallCell;
	private Integer rowCounter = 1;

	public RowsDialogController(Client model, RowsDialogForm view, HallCell hallCell) {
		super(model, view);
		this.executorService = new CommandExecutorService(model);
		this.hallCell = hallCell;
		this.view.setTitle("Seating Rows for " + hallCell.getHallName());
		loadData();
	}

	@Override
	protected void init() {
		this.view.getButtonOk().addActionListener((e) -> {
			this.view.dispose();
		});
		this.view.getButtonCreateRow().addActionListener((e) -> {
			Integer selectedIndex = this.view.getComboBoxCategory().getSelectedIndex();
			Category category = this.view.getObservableListCategories().get(selectedIndex);
			this.executorService.queueCommand(new SeatingRow_constructor_Command(category, this.rowCounter, this.hallCell.getObject()), new CommandCallback<SeatingRow>() {

				@Override
				protected void onSuccess(SeatingRow result) {
					for (int i = 1; i < (Integer) view.getSpinnerSeatCount().getValue() + 1; i++) {
						executorService.queueCommand(new Seat_constructor_Command(i, result));
					}
					// Add dummy seating row cell
					SeatingRowCell cell = new SeatingRowCell(result);
					cell.setNr(rowCounter);
					cell.setCategoryName(category.toString());
					cell.setSeatCount((Integer) view.getSpinnerSeatCount().getValue());
					view.getObservableListSeatingRow().add(cell);
					rowCounter++;
					view.getLabelCurrentRowNumber().setText(String.format("Current Row Nr.: %s", rowCounter));
				}

				@Override
				protected void onException(Exception exception) {
					view.getLogLabel().setText(exception.getMessage());
					exception.printStackTrace();
				}
			});
		});
	}

	private void loadData() {
		this.executorService.queueCommand(new Hall_getRows_Command(hallCell.getObject()),
				new CommandCallback<Collection<SeatingRow>>() {

					@Override
					protected void onSuccess(Collection<SeatingRow> result) {
						try {
							rowCounter = result.size() + 1;
							view.getLabelCurrentRowNumber().setText(String.format("Current Row Nr.: %s", rowCounter));
							view.getObservableListSeatingRow()
									.addAll(CellCollections.toSeatingRowCellCollection(result, model));
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
		this.executorService.queueCommand(new getCategories_Command(), new CommandCallback<Collection<Category>>() {

			@Override
			protected void onSuccess(Collection<Category> result) {
				try {
					view.getObservableListCategories().addAll(result);
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
