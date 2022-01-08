package client.controllers;

import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Collection;

import client.CellCollections;
import client.Client;
import client.CommandCallback;
import client.CommandExecutorService;
import client.RowClickListener;
import client.forms.AdminDialogForm;
import client.forms.MainForm;
import client.forms.ReservationsDialogForm;
import client.forms.ReserveDialogForm;
import generated.cinemaService.CShow;
import generated.cinemaService.commands.getAdminStatus_Command;
import generated.cinemaService.commands.getReservableShows_Command;

public class MainController extends Controller<Client, MainForm> {

	private CommandExecutorService executorService;

	public MainController(Client model, MainForm view) {
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
		this.view.getMenuItemReservations().addActionListener((e) -> {
			ReservationsDialogForm form = new ReservationsDialogForm(view);
			new ReservationsDialogController(model, form);
			form.setVisible(true);
		});
		this.view.getMenuItemAdminSettings().addActionListener((e) -> {
			AdminDialogForm form = new AdminDialogForm(view);
			new AdminDialogController(model, form);
			form.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosed(WindowEvent e) {
					loadData();
				}
			});
			form.setVisible(true);
		});
	}
	
	private void loadData() {
		view.getObservableListShows().clear();
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
		this.executorService.queueCommand(new getAdminStatus_Command(this.model.getAuthToken()), new CommandCallback<Boolean>() {

			@Override
			protected void onSuccess(Boolean result) {
				if (result) {
					view.getMenuItemAdminSettings().setVisible(true);
					view.getLogLabel().setText("Logged in as owner");
				} else {
					view.getMenuItemAdminSettings().setVisible(false);
					view.getLogLabel().setText("Logged in as user");
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
