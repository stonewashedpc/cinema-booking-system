/*
 * Created by JFormDesigner on Thu Dec 23 22:44:10 CET 2021
 */

package client.forms;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import com.jgoodies.forms.factories.*;

import client.CShowCell;
import org.jdesktop.beansbinding.*;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;

import org.jdesktop.observablecollections.*;
import org.jdesktop.swingbinding.*;

/**
 * @author Joel Benseler
 */
public class ReserveDialogForm extends JDialog {
	
	private CShowCell cShowCell;
	
	public ReserveDialogForm(Window owner, CShowCell cShowCell) {
		super(owner);
		this.observableListSeats = ObservableCollections.observableList(new ArrayList<SeatCell>());
		this.cShowCell = cShowCell;
		initComponents();
	}
	
	public CShowCell getcShowCell() {
		return cShowCell;
	}

	public JTable getListViewSeats() {
		return listViewSeats;
	}

	public JLabel getLabelSeatCount() {
		return labelSeatCount;
	}

	public JLabel getLabelPrice() {
		return labelPrice;
	}

	public JButton getButtonReserve() {
		return buttonReserve;
	}

	public JButton getButtonCancel() {
		return buttonCancel;
	}

	public ObservableList<SeatCell> getObservableListSeats() {
		return observableListSeats;
	}

	public JLabel getLogLabel() {
		return logLabel;
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		DefaultComponentFactory compFactory = DefaultComponentFactory.getInstance();
		dialogPane = new JPanel();
		contentPanel = new JPanel();
		scrollPane1 = new JScrollPane();
		listViewSeats = new JTable();
		separator1 = compFactory.createSeparator("Ihre Reservierung");
		separator2 = compFactory.createSeparator("Sitzpl\u00e4tze");
		label1 = new JLabel();
		label2 = new JLabel();
		labelSeatCount = new JLabel();
		labelPrice = new JLabel();
		buttonBar = new JPanel();
		logLabel = new JLabel();
		buttonReserve = new JButton();
		buttonCancel = new JButton();

		//======== this ========
		setTitle("Reservieren");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setModal(true);
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
					scrollPane1.setViewportView(listViewSeats);
				}

				//---- label1 ----
				label1.setText("Anzahl Sitzpl\u00e4tze:");

				//---- label2 ----
				label2.setText("Preis:");

				//---- labelSeatCount ----
				labelSeatCount.setText("0");

				//---- labelPrice ----
				labelPrice.setText("0");

				GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
				contentPanel.setLayout(contentPanelLayout);
				contentPanelLayout.setHorizontalGroup(
					contentPanelLayout.createParallelGroup()
						.addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
						.addComponent(separator1, GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
						.addComponent(separator2, GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
						.addGroup(contentPanelLayout.createSequentialGroup()
							.addGroup(contentPanelLayout.createParallelGroup()
								.addComponent(label1)
								.addComponent(label2))
							.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
							.addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addComponent(labelPrice, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
								.addComponent(labelSeatCount, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
							.addGap(0, 497, Short.MAX_VALUE))
				);
				contentPanelLayout.setVerticalGroup(
					contentPanelLayout.createParallelGroup()
						.addGroup(contentPanelLayout.createSequentialGroup()
							.addComponent(separator2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
							.addComponent(separator1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(contentPanelLayout.createParallelGroup()
								.addComponent(label1)
								.addComponent(labelSeatCount))
							.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
							.addGroup(contentPanelLayout.createParallelGroup()
								.addComponent(label2)
								.addComponent(labelPrice))
							.addContainerGap(9, Short.MAX_VALUE))
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

				//---- buttonReserve ----
				buttonReserve.setText("Reservieren");
				buttonBar.add(buttonReserve, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 5), 0, 0));

				//---- buttonCancel ----
				buttonCancel.setText("Abbrechen");
				buttonBar.add(buttonCancel, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
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
				observableListSeats, listViewSeats);
			binding.addColumnBinding(BeanProperty.create("categoryName"))
				.setColumnName("Kategorie")
				.setColumnClass(String.class)
				.setEditable(false);
			binding.addColumnBinding(BeanProperty.create("row.nr"))
				.setColumnName("Reihennummer")
				.setColumnClass(Integer.class)
				.setEditable(false);
			binding.addColumnBinding(BeanProperty.create("object.nr"))
				.setColumnName("Sitznummer")
				.setColumnClass(Integer.class)
				.setEditable(false);
			binding.addColumnBinding(ELProperty.create("${((price - (price % 100)) / 100) + (price % 100) / 100} Eur"))
				.setColumnName("Preis")
				.setColumnClass(String.class)
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
	private JTable listViewSeats;
	private JComponent separator1;
	private JComponent separator2;
	private JLabel label1;
	private JLabel label2;
	private JLabel labelSeatCount;
	private JLabel labelPrice;
	private JPanel buttonBar;
	private JLabel logLabel;
	private JButton buttonReserve;
	private JButton buttonCancel;
	private ObservableList<SeatCell> observableListSeats;
	private BindingGroup bindingGroup;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
