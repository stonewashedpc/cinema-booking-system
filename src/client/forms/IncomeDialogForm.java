/*
 * Created by JFormDesigner on Mon Jan 10 20:11:39 CET 2022
 */

package client.forms;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author Joel Benseler
 */
public class IncomeDialogForm extends JDialog {
	public IncomeDialogForm(Window owner) {
		super(owner);
		initComponents();
	}

	public JLabel getLabelIncome() {
		return labelIncome;
	}

	public JLabel getLogLabel() {
		return logLabel;
	}

	public JButton getOkButton() {
		return okButton;
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		dialogPane = new JPanel();
		contentPanel = new JPanel();
		labelIncome = new JLabel();
		buttonBar = new JPanel();
		logLabel = new JLabel();
		okButton = new JButton();

		//======== this ========
		setTitle("Income");
		var contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		//======== dialogPane ========
		{
			dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
			dialogPane.setLayout(new BorderLayout());

			//======== contentPanel ========
			{

				//---- labelIncome ----
				labelIncome.setText("Income:");
				labelIncome.setFont(new Font("Tahoma", Font.PLAIN, 16));

				GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
				contentPanel.setLayout(contentPanelLayout);
				contentPanelLayout.setHorizontalGroup(
					contentPanelLayout.createParallelGroup()
						.addComponent(labelIncome, GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
				);
				contentPanelLayout.setVerticalGroup(
					contentPanelLayout.createParallelGroup()
						.addGroup(contentPanelLayout.createSequentialGroup()
							.addComponent(labelIncome)
							.addGap(0, 1, Short.MAX_VALUE))
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
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JPanel dialogPane;
	private JPanel contentPanel;
	private JLabel labelIncome;
	private JPanel buttonBar;
	private JLabel logLabel;
	private JButton okButton;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
