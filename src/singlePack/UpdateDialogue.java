package singlePack;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

class UpdateDialogue extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();

	JPanel panel_1;
	JPanel panel_2;

	JLabel columnName1;
	JLabel columnName2;

	JCheckBox cb1;
	JCheckBox cb2;

	JButton btnUpdate1;
	JButton btnUpdate2;
	JButton btnCancel1;
	JButton btnCancel2;

	private JTextField textField;

	JComboBox comboYear;
	JComboBox comboMonth;
	JComboBox comboDay;

	boolean isUpdateSuccessful;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */

	UpdateDialogue(final int employeeIDOfTheRowToBeUpdated, int indexOfTheColumnToBeUpdated,
			final String nameOfTheColumnToBeUpdated, Object currentValue)
	{
		setIconImage(new ImageIcon(getClass().getResource("/images/ems_favicon.png")).getImage());
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
		setTitle("Updating record (EmployeeID = " + employeeIDOfTheRowToBeUpdated + ").");
		setResizable(false);

		setBounds(100, 100, 390, 201);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new CardLayout(0, 0));

		/////////// SUB PANEL 1

		panel_1 = new JPanel();
		contentPanel.add(panel_1, "name_18751539962294");
		panel_1.setLayout(null);

		columnName1 = new JLabel(nameOfTheColumnToBeUpdated);
		columnName1.setBounds(10, 21, 97, 14);
		panel_1.add(columnName1);

		textField = new JTextField();
		textField.setBounds(117, 18, 230, 20);
		panel_1.add(textField);
		textField.setColumns(10);

		textField.setText(String.valueOf(currentValue));

		cb1 = new JCheckBox();
		cb1.setBounds(6, 62, 357, 23);
		panel_1.add(cb1);
		cb1.setText("Update " + nameOfTheColumnToBeUpdated + " of all records (not only this record).");

		btnUpdate1 = new JButton("Update");
		btnUpdate1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				String newValue = textField.getText();
				String queryForUpdate;
				if (cb1.isSelected())
					queryForUpdate = "UPDATE employee SET " + nameOfTheColumnToBeUpdated + " = ?";
				else
					queryForUpdate = "UPDATE employee SET " + nameOfTheColumnToBeUpdated + " = ? WHERE EmployeeID = "
							+ employeeIDOfTheRowToBeUpdated;

				isUpdateSuccessful = DatabaseHandler.updateRow(queryForUpdate, newValue);

				if (isUpdateSuccessful)
				{
					setVisible(false);
					JOptionPane.showMessageDialog(null, "Record updated successfully.", "Update successful", JOptionPane.INFORMATION_MESSAGE);
					dispose();
				}
			}
		});
		btnUpdate1.setBounds(90, 112, 89, 23);
		panel_1.add(btnUpdate1);

		btnCancel1 = new JButton("Cancel");
		btnCancel1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				setVisible(false);
				dispose();
			}
		});
		btnCancel1.setBounds(200, 112, 89, 23);
		panel_1.add(btnCancel1);

		////////// SUB PANEL 2

		panel_2 = new JPanel();
		contentPanel.add(panel_2, "name_18831489391504");
		panel_2.setLayout(null);

		columnName2 = new JLabel(nameOfTheColumnToBeUpdated);
		columnName2.setBounds(10, 21, 77, 14);
		panel_2.add(columnName2);

		String[] monthItems = { "January", "February", "March", "April", "May", "June", "July", "August", "Sepetember",
				"October", "November", "December" };

		comboYear = new JComboBox();
		comboYear.setBounds(101, 21, 57, 20);
		panel_2.add(comboYear);
		comboYear.addItem("Year");
		for (int i = 1950; i < 2016; i++)
			comboYear.addItem(i);
		comboYear.setMaximumRowCount(3);

		comboMonth = new JComboBox();
		comboMonth.setBounds(173, 21, 97, 20);
		panel_2.add(comboMonth);
		comboMonth.addItem("Month");
		for (int i = 0; i < monthItems.length; i++)
			comboMonth.addItem(monthItems[i]);
		comboMonth.setMaximumRowCount(3);

		comboDay = new JComboBox();
		comboDay.setBounds(286, 21, 51, 20);
		panel_2.add(comboDay);
		comboDay.addItem("Day");
		for (int i = 1; i <= 31; i++)
			comboDay.addItem(i);
		comboDay.setMaximumRowCount(3);

		if (indexOfTheColumnToBeUpdated == 5 || indexOfTheColumnToBeUpdated == 7)
		{
			String currStrVal = String.valueOf(currentValue);
			if (!currStrVal.isEmpty())
			{
				int currentYear = Integer.parseInt(currStrVal.substring(currStrVal.length() - 4, currStrVal.length()));
				comboYear.setSelectedItem(currentYear);
			}
			if (currStrVal.contains(","))
			{
				if (currStrVal.contains("January"))
					comboMonth.setSelectedIndex(1);
				else if (currStrVal.contains("February"))
					comboMonth.setSelectedIndex(2);
				else if (currStrVal.contains("March"))
					comboMonth.setSelectedIndex(3);
				else if (currStrVal.contains("April"))
					comboMonth.setSelectedIndex(4);
				else if (currStrVal.contains("May"))
					comboMonth.setSelectedIndex(5);
				else if (currStrVal.contains("June"))
					comboMonth.setSelectedIndex(6);
				else if (currStrVal.contains("July"))
					comboMonth.setSelectedIndex(7);
				else if (currStrVal.contains("August"))
					comboMonth.setSelectedIndex(8);
				else if (currStrVal.contains("September"))
					comboMonth.setSelectedIndex(9);
				else if (currStrVal.contains("October"))
					comboMonth.setSelectedIndex(10);
				else if (currStrVal.contains("November"))
					comboMonth.setSelectedIndex(11);
				else if (currStrVal.contains("December"))
					comboMonth.setSelectedIndex(12);

				String dayString;
				int currentDay;

				if (Character.isDigit(currStrVal.charAt(0)) && Character.isDigit(currStrVal.charAt(1)))
				{
					dayString = currStrVal.substring(0, 2);
					currentDay = Integer.parseInt(dayString);
					comboDay.setSelectedItem(currentDay);
				}
				else if (Character.isDigit(currStrVal.charAt(0)))
				{
					dayString = String.valueOf((currStrVal.charAt(0)));
					currentDay = Integer.parseInt(dayString);
					comboDay.setSelectedItem(currentDay);
				}
			}
		}

		cb2 = new JCheckBox();
		cb2.setBounds(6, 63, 338, 23);
		panel_2.add(cb2);
		cb2.setText("Update " + nameOfTheColumnToBeUpdated + " of all records (not only this record).");

		btnUpdate2 = new JButton("Update");
		btnUpdate2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				String newDate;
				if (comboYear.getSelectedIndex() == 0)
					newDate = "";
				else
				{
					String newYear = String.valueOf(comboYear.getSelectedItem());

					if (comboMonth.getSelectedIndex() == 0)
						newDate = newYear;
					else
					{
						String newMonth = (String) comboMonth.getSelectedItem();
						if (comboDay.getSelectedIndex() == 0)
						{
							newDate = newMonth + ", " + newYear;
						}
						else
						{
							String newDay = String.valueOf(comboDay.getSelectedItem());
							newDate = newDay + " " + newMonth + ", " + newYear;
						}

					}
				}

				String queryForUpdate;
				if (cb2.isSelected())
					queryForUpdate = "UPDATE employee SET " + nameOfTheColumnToBeUpdated + " = ?";
				else
					queryForUpdate = "UPDATE employee SET " + nameOfTheColumnToBeUpdated + " = ? WHERE EmployeeID = "
							+ employeeIDOfTheRowToBeUpdated;

				isUpdateSuccessful = DatabaseHandler.updateRow(queryForUpdate, newDate);

				if (isUpdateSuccessful)
				{
					setVisible(false);
					JOptionPane.showMessageDialog(null, "Record updated successfully.", "Update successful", JOptionPane.INFORMATION_MESSAGE);
					dispose();
				}
			}
		});
		btnUpdate2.setBounds(90, 112, 89, 23);
		panel_2.add(btnUpdate2);

		btnCancel2 = new JButton("Cancel");
		btnCancel2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				setVisible(false);
				dispose();
			}
		});
		btnCancel2.setBounds(200, 112, 89, 23);
		panel_2.add(btnCancel2);

		CardLayout CL = (CardLayout) (contentPanel.getLayout());
		if (indexOfTheColumnToBeUpdated == 5 || indexOfTheColumnToBeUpdated == 7)
			CL.show(contentPanel, "name_18831489391504");
		else
			CL.show(contentPanel, "name_18751539962294");

		setVisible(true);

	}
}
