/*
 * Created by JFormDesigner on Tue Dec 21 20:50:36 CET 2021
 */

package client.forms;

import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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

/**
 * @author Joel Benseler
 */
public class MainForm extends JFrame {
	
	public MainForm() {
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

	public JMenuItem getMenuItemReservations() {
		return menuItemReservations;
	}

	public JMenuItem getMenuItemAdminSettings() {
		return menuItemAdminSettings;
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		menuBar1 = new JMenuBar();
		menu1 = new JMenu();
		menuItemReservations = new JMenuItem();
		menuItemAdminSettings = new JMenuItem();
		scrollPane1 = new JScrollPane();
		listViewShows = new JTable();
		logLabel = new JLabel();

		//======== this ========
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("CinemaBookingClient - Customer");
		var contentPane = getContentPane();

		//======== menuBar1 ========
		{

			//======== menu1 ========
			{
				menu1.setText("View");

				//---- menuItemReservations ----
				menuItemReservations.setText("Reservations");
				menu1.add(menuItemReservations);

				//---- menuItemAdminSettings ----
				menuItemAdminSettings.setText("Admin Settings");
				menuItemAdminSettings.setVisible(false);
				menu1.add(menuItemAdminSettings);
			}
			menuBar1.add(menu1);
		}
		setJMenuBar(menuBar1);

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
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
	private JMenuBar menuBar1;
	private JMenu menu1;
	private JMenuItem menuItemReservations;
	private JMenuItem menuItemAdminSettings;
	private JScrollPane scrollPane1;
	private JTable listViewShows;
	private JLabel logLabel;
	private ObservableList<CShowCell> observableListShows;
	private BindingGroup bindingGroup;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
