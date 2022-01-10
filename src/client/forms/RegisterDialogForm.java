/*
 * Created by JFormDesigner on Mon Jan 10 20:56:47 CET 2022
 */

package client.forms;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author Joel Benseler
 */
public class RegisterDialogForm extends JDialog {
	public RegisterDialogForm(Window owner) {
		super(owner);
		initComponents();
	}

	public JTextField getUsernameField() {
		return usernameField;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public JLabel getLogLabel() {
		return logLabel;
	}

	public JButton getButtonRegister() {
		return buttonRegister;
	}

	public JButton getButtonCancel() {
		return buttonCancel;
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		dialogPane = new JPanel();
		contentPanel = new JPanel();
		usernameField = new JTextField();
		passwordField = new JPasswordField();
		label1 = new JLabel();
		label2 = new JLabel();
		buttonBar = new JPanel();
		logLabel = new JLabel();
		buttonRegister = new JButton();
		buttonCancel = new JButton();

		//======== this ========
		setTitle("CinemaBookingClient - Register");
		var contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		//======== dialogPane ========
		{
			dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
			dialogPane.setLayout(new BorderLayout());

			//======== contentPanel ========
			{

				//---- label1 ----
				label1.setText("Username");

				//---- label2 ----
				label2.setText("Password");

				GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
				contentPanel.setLayout(contentPanelLayout);
				contentPanelLayout.setHorizontalGroup(
					contentPanelLayout.createParallelGroup()
						.addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
							.addGap(0, 0, Short.MAX_VALUE)
							.addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addGroup(contentPanelLayout.createSequentialGroup()
									.addComponent(label2, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
									.addGap(12, 12, 12)
									.addComponent(passwordField))
								.addGroup(contentPanelLayout.createSequentialGroup()
									.addComponent(label1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
									.addGap(10, 10, 10)
									.addComponent(usernameField, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE))))
				);
				contentPanelLayout.setVerticalGroup(
					contentPanelLayout.createParallelGroup()
						.addGroup(contentPanelLayout.createSequentialGroup()
							.addGroup(contentPanelLayout.createParallelGroup()
								.addGroup(contentPanelLayout.createSequentialGroup()
									.addGap(3, 3, 3)
									.addComponent(label1))
								.addComponent(usernameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(contentPanelLayout.createParallelGroup()
								.addGroup(contentPanelLayout.createSequentialGroup()
									.addGap(9, 9, 9)
									.addComponent(label2))
								.addGroup(contentPanelLayout.createSequentialGroup()
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(0, 0, Short.MAX_VALUE))
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

				//---- buttonRegister ----
				buttonRegister.setText("Register");
				buttonBar.add(buttonRegister, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 5), 0, 0));

				//---- buttonCancel ----
				buttonCancel.setText("Cancel");
				buttonBar.add(buttonCancel, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
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
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JLabel label1;
	private JLabel label2;
	private JPanel buttonBar;
	private JLabel logLabel;
	private JButton buttonRegister;
	private JButton buttonCancel;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
