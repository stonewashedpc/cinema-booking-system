/*
 * Created by JFormDesigner on Tue Jan 04 19:24:25 CET 2022
 */

package client.forms;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import org.jdesktop.beansbinding.*;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.observablecollections.*;
import org.jdesktop.swingbinding.*;

import client.ReservationCell;

/**
 * @author Joel Benseler
 */
public class ReservationsDialogForm extends JDialog {
	public ReservationsDialogForm(Window owner) {
		super(owner);
		this.observableListReservations = ObservableCollections.observableList(new ArrayList<ReservationCell>());
		initComponents();
	}

	public JTable getListViewReservations() {
		return listViewReservations;
	}

	public JButton getButtonBookReservation() {
		return buttonBookReservation;
	}

	public JButton getButtonCancelReservation() {
		return buttonCancelReservation;
	}

	public JButton getButtonOk() {
		return buttonOk;
	}

	public ObservableList<ReservationCell> getObservableListReservations() {
		return observableListReservations;
	}

	public JLabel getLogLabel() {
		return logLabel;
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		dialogPane = new JPanel();
		contentPanel = new JPanel();
		scrollPane1 = new JScrollPane();
		listViewReservations = new JTable();
		buttonBookReservation = new JButton();
		buttonCancelReservation = new JButton();
		buttonBar = new JPanel();
		logLabel = new JLabel();
		buttonOk = new JButton();

		//======== this ========
		setTitle("CinemaBookingClient - Reservations");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		var contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		//======== dialogPane ========
		{
			dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
			dialogPane.setLayout(new BorderLayout());

			//======== contentPanel ========
			{

				//======== scrollPane1 ========
				{

					//---- listViewReservations ----
					listViewReservations.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					scrollPane1.setViewportView(listViewReservations);
				}

				//---- buttonBookReservation ----
				buttonBookReservation.setText("Buchen");
				buttonBookReservation.setEnabled(false);

				//---- buttonCancelReservation ----
				buttonCancelReservation.setText("Stornieren");
				buttonCancelReservation.setEnabled(false);

				GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
				contentPanel.setLayout(contentPanelLayout);
				contentPanelLayout.setHorizontalGroup(
					contentPanelLayout.createParallelGroup()
						.addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
						.addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
							.addGap(0, 0, Short.MAX_VALUE)
							.addComponent(buttonCancelReservation, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(buttonBookReservation, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
				);
				contentPanelLayout.setVerticalGroup(
					contentPanelLayout.createParallelGroup()
						.addGroup(contentPanelLayout.createSequentialGroup()
							.addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(buttonBookReservation)
								.addComponent(buttonCancelReservation))
							.addGap(0, 2, Short.MAX_VALUE))
				);
			}
			dialogPane.add(contentPanel, BorderLayout.CENTER);

			//======== buttonBar ========
			{
				buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
				buttonBar.setLayout(new GridBagLayout());
				((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
				((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

				//---- logLabel ----
				logLabel.setText("Log");
				buttonBar.add(logLabel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 5), 0, 0));

				//---- buttonOk ----
				buttonOk.setText("OK");
				buttonBar.add(buttonOk, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 0), 0, 0));
			}
			dialogPane.add(buttonBar, BorderLayout.SOUTH);
		}
		contentPane.add(dialogPane, BorderLayout.CENTER);
		pack();
		setLocationRelativeTo(getOwner());

		//---- bindings ----
		bindingGroup = new BindingGroup();
		{
			var binding = SwingBindings.createJTableBinding(UpdateStrategy.READ_WRITE,
				observableListReservations, listViewReservations);
			binding.addColumnBinding(BeanProperty.create("hallName"))
				.setColumnName("Hall Name")
				.setColumnClass(String.class)
				.setEditable(false);
			binding.addColumnBinding(BeanProperty.create("filmName"))
				.setColumnName("Film Name")
				.setColumnClass(String.class)
				.setEditable(false);
			binding.addColumnBinding(BeanProperty.create("seatCount"))
				.setColumnName("Seat Count")
				.setColumnClass(Integer.class)
				.setEditable(false);
			binding.addColumnBinding(ELProperty.create("${((totalPrice - (totalPrice % 100)) / 100) + (totalPrice % 100) / 100} Eur"))
				.setColumnName("Total Price")
				.setColumnClass(String.class)
				.setEditable(false);
			binding.addColumnBinding(BeanProperty.create("isBooked"))
				.setColumnName("Is Booked")
				.setColumnClass(Boolean.class)
				.setEditable(false);
			bindingGroup.addBinding(binding);
		}
		bindingGroup.bind();
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JPanel dialogPane;
	private JPanel contentPanel;
	private JScrollPane scrollPane1;
	private JTable listViewReservations;
	private JButton buttonBookReservation;
	private JButton buttonCancelReservation;
	private JPanel buttonBar;
	private JLabel logLabel;
	private JButton buttonOk;
	private ObservableList<ReservationCell> observableListReservations;
	private BindingGroup bindingGroup;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
