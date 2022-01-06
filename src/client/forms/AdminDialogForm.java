/*
 * Created by JFormDesigner on Thu Jan 06 19:35:03 CET 2022
 */

package client.forms;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author Joel Benseler
 */
public class AdminDialogForm extends JDialog {
	public AdminDialogForm(Window owner) {
		super(owner);
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

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		dialogPane = new JPanel();
		contentPanel = new JPanel();
		textFieldHallName = new JTextField();
		textFieldFilmName = new JTextField();
		buttonCreateHall = new JButton();
		buttonCreateFilm = new JButton();
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

				GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
				contentPanel.setLayout(contentPanelLayout);
				contentPanelLayout.setHorizontalGroup(
					contentPanelLayout.createParallelGroup()
						.addGroup(contentPanelLayout.createSequentialGroup()
							.addGroup(contentPanelLayout.createParallelGroup()
								.addGroup(contentPanelLayout.createSequentialGroup()
									.addComponent(textFieldHallName, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(buttonCreateHall))
								.addGroup(contentPanelLayout.createSequentialGroup()
									.addComponent(textFieldFilmName, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(buttonCreateFilm)))
							.addGap(0, 510, Short.MAX_VALUE))
				);
				contentPanelLayout.setVerticalGroup(
					contentPanelLayout.createParallelGroup()
						.addGroup(contentPanelLayout.createSequentialGroup()
							.addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(textFieldHallName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(buttonCreateHall))
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(textFieldFilmName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(buttonCreateFilm))
							.addGap(0, 352, Short.MAX_VALUE))
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
	private JTextField textFieldHallName;
	private JTextField textFieldFilmName;
	private JButton buttonCreateHall;
	private JButton buttonCreateFilm;
	private JPanel buttonBar;
	private JLabel logLabel;
	private JButton okButton;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
