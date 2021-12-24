package client.controllers;

import java.awt.event.MouseEvent;
import java.util.Collection;

import client.CellCollections;
import client.Client;
import client.CommandCallback;
import client.CommandExecutorService;
import client.RowClickListener;
import client.forms.CustomerForm;
import client.forms.ReserveDialogForm;
import generated.cinemaService.CShow;
import generated.cinemaService.commands.getReservableShows_Command;

public class CustomerController extends Controller<Client, CustomerForm> {

	private CommandExecutorService executorService;

	public CustomerController(Client model, CustomerForm view) {
		super(model, view);
		this.executorService = new CommandExecutorService(model);
		loadData();
	}

	@Override
	protected void init() {
		this.view.getListViewShows().addMouseListener(new RowClickListener() {
			@Override
			public void onDoubleClick(MouseEvent event) {
				ReserveDialogForm form = new ReserveDialogForm(view, view.getObservableListShows().get(view.getListViewShows().rowAtPoint(event.getPoint())));
				new ReserveDialogController(model, form);
				form.setVisible(true);
			}
		});
	}
	
	private void loadData() {
		this.executorService.queueCommand(new getReservableShows_Command(), new CommandCallback<Collection<CShow>>() {

			protected void onSuccess(Collection<CShow> result) {
				try {
					view.getObservableListShows().addAll(CellCollections.toCShowCellCollection(result, model));
				} catch (Exception e) {
					e.printStackTrace();
					view.getLogLabel().setText("An error occurred while loading shows");
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
