/*
 * Created by JFormDesigner on Tue Dec 21 20:41:30 CET 2021
 */

package client.forms;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

import client.Client;
import client.CommandExecutorService;

/**
 * @author Joel Benseler
 */
public class LoginForm extends JFrame {
	private CommandExecutorService service;
	private Client client;
	public LoginForm() {
		initComponents();
	}

	public JButton getLoginButton() {
		return loginButton;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public JTextField getUsernameField() {
		return usernameField;
	}

	public JLabel getLogLabel() {
		return logLabel;
	}

	public JButton getButtonRegister() {
		return buttonRegister;
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		usernameField = new JTextField();
		label1 = new JLabel();
		passwordField = new JPasswordField();
		label2 = new JLabel();
		loginButton = new JButton();
		logLabel = new JLabel();
		buttonRegister = new JButton();

		//======== this ========
		setTitle("CinemaBookingClient - Login");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		var contentPane = getContentPane();

		//---- label1 ----
		label1.setText("Username");

		//---- label2 ----
		label2.setText("Password");

		//---- loginButton ----
		loginButton.setText("Login");

		//---- logLabel ----
		logLabel.setText("Log");

		//---- buttonRegister ----
		buttonRegister.setText("Register...");

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(contentPaneLayout.createParallelGroup()
						.addComponent(logLabel, GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGroup(contentPaneLayout.createParallelGroup()
								.addComponent(label1)
								.addComponent(label2))
							.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
							.addGroup(contentPaneLayout.createParallelGroup()
								.addGroup(contentPaneLayout.createSequentialGroup()
									.addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(buttonRegister, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
									.addGap(0, 81, Short.MAX_VALUE))
								.addComponent(passwordField)
								.addComponent(usernameField))
							.addContainerGap())))
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(label1)
						.addComponent(usernameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(label2)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(loginButton)
						.addComponent(buttonRegister))
					.addGap(18, 18, 18)
					.addComponent(logLabel)
					.addContainerGap())
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JTextField usernameField;
	private JLabel label1;
	private JPasswordField passwordField;
	private JLabel label2;
	private JButton loginButton;
	private JLabel logLabel;
	private JButton buttonRegister;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
