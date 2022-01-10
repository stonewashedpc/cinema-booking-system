/*
 * Created by JFormDesigner on Mon Jan 10 21:32:47 CET 2022
 */

package client.forms;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.EmptyBorder;

import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;
import org.jdesktop.swingbinding.SwingBindings;

import client.SeatingRowCell;
import generated.cinemaService.Category;

/**
 * @author Joel Benseler
 */
public class RowsDialogForm extends JDialog {
	public RowsDialogForm(Window owner) {
		super(owner);
		this.observableListSeatingRow = ObservableCollections.observableList(new ArrayList<SeatingRowCell>());
		this.observableListCategories = ObservableCollections.observableList(new ArrayList<Category>());
		initComponents();
	}

	public JComboBox getComboBoxCategory() {
		return comboBoxCategory;
	}

	public JSpinner getSpinnerSeatCount() {
		return spinnerSeatCount;
	}

	public JButton getButtonCreateRow() {
		return buttonCreateRow;
	}

	public JLabel getLabelCurrentRowNumber() {
		return labelCurrentRowNumber;
	}

	public JTable getListViewSeatingRows() {
		return listViewSeatingRows;
	}

	public JButton getButtonOk() {
		return buttonOk;
	}

	public ObservableList<SeatingRowCell> getObservableListSeatingRow() {
		return observableListSeatingRow;
	}

	public JLabel getLogLabel() {
		return logLabel;
	}

	public ObservableList<Category> getObservableListCategories() {
		return observableListCategories;
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		dialogPane = new JPanel();
		contentPanel = new JPanel();
		comboBoxCategory = new JComboBox();
		spinnerSeatCount = new JSpinner();
		buttonCreateRow = new JButton();
		labelCurrentRowNumber = new JLabel();
		scrollPane1 = new JScrollPane();
		listViewSeatingRows = new JTable();
		buttonBar = new JPanel();
		logLabel = new JLabel();
		buttonOk = new JButton();

		//======== this ========
		setTitle("Seating Rows");
		var contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		//======== dialogPane ========
		{
			dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
			dialogPane.setLayout(new BorderLayout());

			//======== contentPanel ========
			{

				//---- buttonCreateRow ----
				buttonCreateRow.setText("Create Row");

				//---- labelCurrentRowNumber ----
				labelCurrentRowNumber.setText("Current Row Nr.: 1");

				//======== scrollPane1 ========
				{
					scrollPane1.setViewportView(listViewSeatingRows);
				}

				GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
				contentPanel.setLayout(contentPanelLayout);
				contentPanelLayout.setHorizontalGroup(
					contentPanelLayout.createParallelGroup()
						.addGroup(contentPanelLayout.createSequentialGroup()
							.addComponent(comboBoxCategory, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(spinnerSeatCount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(buttonCreateRow, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(labelCurrentRowNumber, GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE))
						.addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
				);
				contentPanelLayout.setVerticalGroup(
					contentPanelLayout.createParallelGroup()
						.addGroup(contentPanelLayout.createSequentialGroup()
							.addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(comboBoxCategory, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(spinnerSeatCount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(buttonCreateRow)
								.addComponent(labelCurrentRowNumber))
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
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

				//---- buttonOk ----
				buttonOk.setText("OK");
				buttonBar.add(buttonOk, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
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
				observableListSeatingRow, listViewSeatingRows);
			binding.addColumnBinding(BeanProperty.create("nr"))
				.setColumnName("Nr")
				.setColumnClass(Integer.class)
				.setEditable(false);
			binding.addColumnBinding(BeanProperty.create("categoryName"))
				.setColumnName("Category Name")
				.setColumnClass(String.class)
				.setEditable(false);
			binding.addColumnBinding(BeanProperty.create("seatCount"))
				.setColumnName("Seat Count")
				.setColumnClass(Integer.class)
				.setEditable(false);
			bindingGroup.addBinding(binding);
		}
		bindingGroup.addBinding(SwingBindings.createJComboBoxBinding(UpdateStrategy.READ_WRITE,
			observableListCategories, comboBoxCategory));
		bindingGroup.bind();
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JPanel dialogPane;
	private JPanel contentPanel;
	private JComboBox comboBoxCategory;
	private JSpinner spinnerSeatCount;
	private JButton buttonCreateRow;
	private JLabel labelCurrentRowNumber;
	private JScrollPane scrollPane1;
	private JTable listViewSeatingRows;
	private JPanel buttonBar;
	private JLabel logLabel;
	private JButton buttonOk;
	private ObservableList<SeatingRowCell> observableListSeatingRow;
	private ObservableList<Category> observableListCategories;
	private BindingGroup bindingGroup;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
