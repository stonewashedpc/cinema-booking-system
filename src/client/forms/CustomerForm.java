/*
 * Created by JFormDesigner on Tue Dec 21 20:50:36 CET 2021
 */

package client.forms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;
import org.jdesktop.swingbinding.SwingBindings;

import client.CShowCell;
import client.Client;
import client.CommandCallback;
import client.CommandExecutorService;
import generated.cinemaService.CShow;
import generated.cinemaService.Film;
import generated.cinemaService.commands.getReservableShows_Command;
import generated.cinemaService.commands.cShow.CShow_getFilm_Command;
import generated.cinemaService.commands.cShow.CShow_getHall_Command;

/**
 * @author Joel Benseler
 */
public class CustomerForm extends JFrame {
	
	public CustomerForm() {
		this.observableListShows = ObservableCollections.observableList(new ArrayList<CShowCell>());
		initComponents();
	}

	public ObservableList<CShowCell> getObservableListShows() {
		return observableListShows;
	}

	public JTable getListViewShows() {
		return listViewShows;
	}

	public JLabel getLogLabel() {
		return logLabel;
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		scrollPane1 = new JScrollPane();
		listViewShows = new JTable();
		logLabel = new JLabel();

		//======== this ========
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("CinemaBookingClient - Customer");
		var contentPane = getContentPane();

		//======== scrollPane1 ========
		{
			scrollPane1.setViewportView(listViewShows);
		}

		//---- logLabel ----
		logLabel.setText("Log");

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(contentPaneLayout.createParallelGroup()
						.addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 1033, Short.MAX_VALUE)
						.addComponent(logLabel, GroupLayout.DEFAULT_SIZE, 1033, Short.MAX_VALUE))
					.addContainerGap())
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
					.addComponent(logLabel)
					.addContainerGap())
		);
		pack();
		setLocationRelativeTo(getOwner());

		//---- bindings ----
		bindingGroup = new BindingGroup();
		{
			var binding = SwingBindings.createJTableBinding(UpdateStrategy.READ_WRITE,
				observableListShows, listViewShows);
			binding.addColumnBinding(BeanProperty.create("hallName"))
				.setColumnName("Saal")
				.setColumnClass(String.class)
				.setEditable(false);
			binding.addColumnBinding(BeanProperty.create("filmName"))
				.setColumnName("Film")
				.setColumnClass(String.class)
				.setEditable(false);
			bindingGroup.addBinding(binding);
		}
		bindingGroup.bind();
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JScrollPane scrollPane1;
	private JTable listViewShows;
	private JLabel logLabel;
	private ObservableList<CShowCell> observableListShows;
	private BindingGroup bindingGroup;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}