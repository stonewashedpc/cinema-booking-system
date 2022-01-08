/*
 * Created by JFormDesigner on Thu Jan 06 19:35:03 CET 2022
 */

package client.forms;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;
import java.util.ArrayList;
import javax.swing.*;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import org.jdesktop.beansbinding.*;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;

import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import client.FilmCell;
import client.HallCell;
import client.CShowCell;
import org.jdesktop.swingbinding.*;

/**
 * @author Joel Benseler
 */
public class AdminDialogForm extends JDialog {
	public AdminDialogForm(Window owner) {
		super(owner);
		this.observableListHalls = ObservableCollections.observableList(new ArrayList<HallCell>());
		this.observableListFilms = ObservableCollections.observableList(new ArrayList<FilmCell>());
		this.observableListShows = ObservableCollections.observableList(new ArrayList<CShowCell>());
		initComponents();
	}

	public JTextField getTextFieldHallName() {
		return textFieldHallName;
	}

	public JTextField getTextFieldFilmName() {
		return textFieldFilmName;
	}

	public JButton getButtonCreateHall() {
		return buttonCreateHall;
	}

	public JButton getButtonCreateFilm() {
		return buttonCreateFilm;
	}

	public JLabel getLogLabel() {
		return logLabel;
	}

	public JTable getListViewHalls() {
		return listViewHalls;
	}

	public JTable getListViewFilms() {
		return listViewFilms;
	}

	public JButton getOkButton() {
		return okButton;
	}

	public JTable getListViewShows() {
		return listViewShows;
	}

	public JButton getButtonCreateShow() {
		return buttonCreateShow;
	}

	public ObservableList<HallCell> getObservableListHalls() {
		return observableListHalls;
	}

	public ObservableList<FilmCell> getObservableListFilms() {
		return observableListFilms;
	}

	public ObservableList<CShowCell> getObservableListShows() {
		return observableListShows;
	}

	public JComboBox<FilmCell> getComboBoxFilm() {
		return comboBoxFilm;
	}

	public JComboBox<HallCell> getComboBoxHall() {
		return comboBoxHall;
	}

	public JButton getButtonSetOpenForReservations() {
		return buttonSetOpenForReservations;
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		DefaultComponentFactory compFactory = DefaultComponentFactory.getInstance();
		dialogPane = new JPanel();
		contentPanel = new JPanel();
		textFieldHallName = new JTextField();
		textFieldFilmName = new JTextField();
		buttonCreateHall = new JButton();
		buttonCreateFilm = new JButton();
		separator1 = compFactory.createSeparator("Halls");
		scrollPane1 = new JScrollPane();
		listViewHalls = new JTable();
		separator2 = compFactory.createSeparator("Films");
		scrollPane3 = new JScrollPane();
		listViewFilms = new JTable();
		scrollPane4 = new JScrollPane();
		listViewShows = new JTable();
		separator3 = compFactory.createSeparator("Shows");
		buttonCreateShow = new JButton();
		comboBoxHall = new JComboBox<>();
		comboBoxFilm = new JComboBox<>();
		buttonSetOpenForReservations = new JButton();
		buttonBar = new JPanel();
		logLabel = new JLabel();
		okButton = new JButton();

		//======== this ========
		setTitle("CinemaBookingClient - Admin Settings");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
		var contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		//======== dialogPane ========
		{
			dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
			dialogPane.setLayout(new BorderLayout());

			//======== contentPanel ========
			{

				//---- buttonCreateHall ----
				buttonCreateHall.setText("Create Hall");

				//---- buttonCreateFilm ----
				buttonCreateFilm.setText("Create Film");

				//======== scrollPane1 ========
				{

					//---- listViewHalls ----
					listViewHalls.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					scrollPane1.setViewportView(listViewHalls);
				}

				//======== scrollPane3 ========
				{

					//---- listViewFilms ----
					listViewFilms.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					scrollPane3.setViewportView(listViewFilms);
				}

				//======== scrollPane4 ========
				{

					//---- listViewShows ----
					listViewShows.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					scrollPane4.setViewportView(listViewShows);
				}

				//---- buttonCreateShow ----
				buttonCreateShow.setText("Create Show");

				//---- buttonSetOpenForReservations ----
				buttonSetOpenForReservations.setText("Set open for reservations");
				buttonSetOpenForReservations.setEnabled(false);

				GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
				contentPanel.setLayout(contentPanelLayout);
				contentPanelLayout.setHorizontalGroup(
					contentPanelLayout.createParallelGroup()
						.addComponent(separator1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 814, Short.MAX_VALUE)
						.addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 814, Short.MAX_VALUE)
						.addComponent(separator2, GroupLayout.DEFAULT_SIZE, 814, Short.MAX_VALUE)
						.addComponent(scrollPane3, GroupLayout.DEFAULT_SIZE, 814, Short.MAX_VALUE)
						.addComponent(separator3, GroupLayout.DEFAULT_SIZE, 814, Short.MAX_VALUE)
						.addGroup(contentPanelLayout.createSequentialGroup()
							.addGroup(contentPanelLayout.createParallelGroup()
								.addGroup(contentPanelLayout.createSequentialGroup()
									.addComponent(textFieldHallName, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(buttonCreateHall))
								.addGroup(contentPanelLayout.createSequentialGroup()
									.addComponent(textFieldFilmName, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(buttonCreateFilm))
								.addGroup(contentPanelLayout.createSequentialGroup()
									.addComponent(comboBoxHall, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(comboBoxFilm, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(buttonCreateShow, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(buttonSetOpenForReservations, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)))
							.addGap(0, 247, Short.MAX_VALUE))
						.addComponent(scrollPane4, GroupLayout.DEFAULT_SIZE, 814, Short.MAX_VALUE)
				);
				contentPanelLayout.setVerticalGroup(
					contentPanelLayout.createParallelGroup()
						.addGroup(contentPanelLayout.createSequentialGroup()
							.addComponent(separator1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(textFieldHallName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(buttonCreateHall))
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
							.addComponent(separator2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(textFieldFilmName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(buttonCreateFilm))
							.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
							.addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
							.addComponent(separator3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(comboBoxHall, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBoxFilm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(buttonCreateShow)
								.addComponent(buttonSetOpenForReservations))
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(scrollPane4, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
			}
			dialogPane.add(contentPanel, BorderLayout.CENTER);

			//======== buttonBar ========
			{
				buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
				buttonBar.setLayout(new GridBagLayout());
				((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 80};
				((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0};

				//---- logLabel ----
				logLabel.setText("Log");
				buttonBar.add(logLabel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 5), 0, 0));

				//---- okButton ----
				okButton.setText("OK");
				buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
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
				observableListHalls, listViewHalls);
			binding.addColumnBinding(BeanProperty.create("hallName"))
				.setColumnName("Hall Name")
				.setColumnClass(String.class)
				.setEditable(false);
			bindingGroup.addBinding(binding);
		}
		{
			var binding = SwingBindings.createJTableBinding(UpdateStrategy.READ_WRITE,
				observableListFilms, listViewFilms);
			binding.addColumnBinding(BeanProperty.create("filmName"))
				.setColumnName("Film Name")
				.setEditable(false);
			bindingGroup.addBinding(binding);
		}
		{
			var binding = SwingBindings.createJTableBinding(UpdateStrategy.READ_WRITE,
				observableListShows, listViewShows);
			binding.addColumnBinding(BeanProperty.create("hallName"))
				.setColumnName("Hall Name")
				.setColumnClass(String.class)
				.setEditable(false);
			binding.addColumnBinding(BeanProperty.create("filmName"))
				.setColumnName("Film Name")
				.setColumnClass(String.class)
				.setEditable(false);
			binding.addColumnBinding(BeanProperty.create("reservable"))
				.setColumnName("Reservable")
				.setColumnClass(Boolean.class)
				.setEditable(false);
			bindingGroup.addBinding(binding);
		}
		bindingGroup.addBinding(SwingBindings.createJComboBoxBinding(UpdateStrategy.READ_WRITE,
			observableListHalls, comboBoxHall));
		bindingGroup.addBinding(SwingBindings.createJComboBoxBinding(UpdateStrategy.READ_WRITE,
			observableListFilms, comboBoxFilm));
		bindingGroup.bind();
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JPanel dialogPane;
	private JPanel contentPanel;
	private JTextField textFieldHallName;
	private JTextField textFieldFilmName;
	private JButton buttonCreateHall;
	private JButton buttonCreateFilm;
	private JComponent separator1;
	private JScrollPane scrollPane1;
	private JTable listViewHalls;
	private JComponent separator2;
	private JScrollPane scrollPane3;
	private JTable listViewFilms;
	private JScrollPane scrollPane4;
	private JTable listViewShows;
	private JComponent separator3;
	private JButton buttonCreateShow;
	private JComboBox<HallCell> comboBoxHall;
	private JComboBox<FilmCell> comboBoxFilm;
	private JButton buttonSetOpenForReservations;
	private JPanel buttonBar;
	private JLabel logLabel;
	private JButton okButton;
	private ObservableList<HallCell> observableListHalls;
	private ObservableList<FilmCell> observableListFilms;
	private ObservableList<CShowCell> observableListShows;
	private BindingGroup bindingGroup;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
