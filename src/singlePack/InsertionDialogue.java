package singlePack;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class InsertionDialogue extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	JLabel lblEmployeeID;
	JLabel lblEmployeeName;
	JLabel lblRank;
	JLabel lblDept;
	JLabel lblBranch;
	JLabel lblSalary;
	JLabel lblJoiningDate;
	JLabel lblBirthDate;
	JLabel lblAddress;
	JLabel lblPhnNo;
	JLabel lblEmail;

	private JTextField txtfldEmployeeID;
	private JTextField txtfldEmployeeName;
	private JTextField txtfldRank;
	private JTextField txtfldDept;
	private JTextField txtfldBranch;
	private JTextField txtfldSalary;
	private JTextField txtfldAddress;
	private JTextField txtfldPhnNo;
	private JTextField txtfldEmail;

	JComboBox comboJoinYear;
	JComboBox comboJoinMonth;
	JComboBox comboJoinDay;
	JComboBox comboBirthYear;
	JComboBox comboBirthMonth;
	JComboBox comboBirthDay;

	JButton btnInsert;
	JButton btnClearFields;
	JButton btnCancel;

	boolean isInsertionSuccessful;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 * 
	 * @param pos1
	 */
	InsertionDialogue()
	{
		setIconImage(new ImageIcon(getClass().getResource("/images/ems_favicon.png")).getImage());
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
		setTitle("Insert Record");
		setResizable(false);

		setBounds(100, 100, 480, 564);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblEmployeeID = new JLabel("Employee ID:");
		lblEmployeeID.setBounds(21, 29, 76, 14);
		contentPanel.add(lblEmployeeID);

		txtfldEmployeeID = new JTextField();
		txtfldEmployeeID.setColumns(10);
		txtfldEmployeeID.setBounds(123, 26, 315, 20);
		contentPanel.add(txtfldEmployeeID);

		lblEmployeeName = new JLabel("Employee Name:");
		lblEmployeeName.setBounds(21, 66, 94, 14);
		contentPanel.add(lblEmployeeName);

		txtfldEmployeeName = new JTextField();
		txtfldEmployeeName.setColumns(10);
		txtfldEmployeeName.setBounds(123, 63, 315, 20);
		contentPanel.add(txtfldEmployeeName);

		lblRank = new JLabel("Rank:");
		lblRank.setBounds(21, 102, 46, 14);
		contentPanel.add(lblRank);

		txtfldRank = new JTextField();
		txtfldRank.setColumns(10);
		txtfldRank.setBounds(123, 99, 315, 20);
		contentPanel.add(txtfldRank);

		lblDept = new JLabel("Department:");
		lblDept.setBounds(21, 139, 76, 14);
		contentPanel.add(lblDept);

		txtfldDept = new JTextField();
		txtfldDept.setColumns(10);
		txtfldDept.setBounds(123, 136, 315, 20);
		contentPanel.add(txtfldDept);

		lblBranch = new JLabel("Branch:");
		lblBranch.setBounds(21, 177, 46, 14);
		contentPanel.add(lblBranch);

		txtfldBranch = new JTextField();
		txtfldBranch.setColumns(10);
		txtfldBranch.setBounds(123, 174, 315, 20);
		contentPanel.add(txtfldBranch);

		lblSalary = new JLabel("Salary:");
		lblSalary.setBounds(21, 216, 46, 14);
		contentPanel.add(lblSalary);

		txtfldSalary = new JTextField();
		txtfldSalary.setColumns(10);
		txtfldSalary.setBounds(123, 213, 315, 20);
		contentPanel.add(txtfldSalary);

		lblJoiningDate = new JLabel("Joining date");
		lblJoiningDate.setBounds(21, 256, 76, 14);
		contentPanel.add(lblJoiningDate);

		String[] monthItems = { "January", "February", "March", "April", "May", "June", "July", "August", "Sepetember",
				"October", "November", "December" };

		comboJoinYear = new JComboBox();
		comboJoinYear.setMaximumRowCount(5);
		comboJoinYear.setBounds(123, 253, 53, 20);
		contentPanel.add(comboJoinYear);
		comboJoinYear.addItem("Year");
		for (int i = 1950; i < 2016; i++)
		{
			comboJoinYear.addItem(i);
		}

		comboJoinMonth = new JComboBox();
		comboJoinMonth.setMaximumRowCount(5);
		comboJoinMonth.setBounds(235, 253, 88, 20);
		contentPanel.add(comboJoinMonth);
		comboJoinMonth.addItem("Month");
		for (int i = 0; i < monthItems.length; i++)
		{
			comboJoinMonth.addItem(monthItems[i]);
		}

		comboJoinDay = new JComboBox();
		comboJoinDay.setMaximumRowCount(5);
		comboJoinDay.setBounds(387, 253, 51, 20);
		contentPanel.add(comboJoinDay);
		comboJoinDay.addItem("Day");
		for (int i = 1; i <= 31; i++)
		{
			comboJoinDay.addItem(i);
		}

		lblBirthDate = new JLabel("Birth date");
		lblBirthDate.setBounds(21, 298, 64, 14);
		contentPanel.add(lblBirthDate);

		comboBirthYear = new JComboBox();
		comboBirthYear.setMaximumRowCount(5);
		comboBirthYear.setBounds(123, 295, 53, 20);
		contentPanel.add(comboBirthYear);
		comboBirthYear.addItem("Year");
		for (int i = 1950; i < 2016; i++)
		{
			comboBirthYear.addItem(i);
		}

		comboBirthMonth = new JComboBox();
		comboBirthMonth.setMaximumRowCount(5);
		comboBirthMonth.setBounds(235, 295, 88, 20);
		contentPanel.add(comboBirthMonth);
		comboBirthMonth.addItem("Month");
		for (int i = 0; i < monthItems.length; i++)
		{
			comboBirthMonth.addItem(monthItems[i]);
		}

		comboBirthDay = new JComboBox();
		comboBirthDay.setMaximumRowCount(5);
		comboBirthDay.setBounds(387, 295, 51, 20);
		contentPanel.add(comboBirthDay);
		comboBirthDay.addItem("Day");
		for (int i = 1; i <= 31; i++)
		{
			comboBirthDay.addItem(i);
		}

		lblAddress = new JLabel("Address:");
		lblAddress.setBounds(21, 336, 64, 14);
		contentPanel.add(lblAddress);

		txtfldAddress = new JTextField();
		txtfldAddress.setColumns(10);
		txtfldAddress.setBounds(123, 333, 315, 20);
		contentPanel.add(txtfldAddress);

		lblPhnNo = new JLabel("Phone No.");
		lblPhnNo.setBounds(21, 375, 64, 14);
		contentPanel.add(lblPhnNo);

		txtfldPhnNo = new JTextField();
		txtfldPhnNo.setColumns(10);
		txtfldPhnNo.setBounds(123, 372, 315, 20);
		contentPanel.add(txtfldPhnNo);

		lblEmail = new JLabel("Email:");
		lblEmail.setBounds(21, 415, 46, 14);
		contentPanel.add(lblEmail);

		txtfldEmail = new JTextField();
		txtfldEmail.setColumns(10);
		txtfldEmail.setBounds(123, 412, 315, 20);
		contentPanel.add(txtfldEmail);

		btnInsert = new JButton("Insert record");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				String joinDate, birthDate;
				if (comboJoinYear.getSelectedIndex() == 0)
					joinDate = "";
				else
				{
					String newYear = String.valueOf(comboJoinYear.getSelectedItem());

					if (comboJoinMonth.getSelectedIndex() == 0)
						joinDate = newYear;
					else
					{
						String joinMonth = (String) comboJoinMonth.getSelectedItem();
						if (comboJoinDay.getSelectedIndex() == 0)
						{
							joinDate = joinMonth + ", " + newYear;
						}
						else
						{
							String newDay = String.valueOf(comboJoinDay.getSelectedItem());
							joinDate = newDay + " " + joinMonth + ", " + newYear;
						}

					}
				}

				if (comboBirthYear.getSelectedIndex() == 0)
					birthDate = "";
				else
				{
					String birthYear = String.valueOf(comboBirthYear.getSelectedItem());

					if (comboBirthMonth.getSelectedIndex() == 0)
						birthDate = birthYear;
					else
					{
						String birthMonth = (String) comboBirthMonth.getSelectedItem();
						if (comboBirthDay.getSelectedIndex() == 0)
						{
							birthDate = birthMonth + ", " + birthYear;
						}
						else
						{
							String newDay = String.valueOf(comboBirthDay.getSelectedItem());
							birthDate = newDay + " " + birthMonth + ", " + birthYear;
						}

					}
				}

				int employeeID;
				try
				{
					employeeID = Integer.parseInt(txtfldEmployeeID.getText());
				}
				catch (NumberFormatException e1)
				{
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "EmployeeID is compulsory and it must be an integer.", "Invalid EmployeeID input", JOptionPane.ERROR_MESSAGE);
					return;
				}
				String employeeName = txtfldEmployeeName.getText();
				String rank = txtfldRank.getText();
				String dept = txtfldDept.getText();
				String branch = txtfldBranch.getText();

				int salary;
				if (txtfldSalary.getText().isEmpty())
				{
					salary = 00000;
				}

				else
				{
					try
					{
						salary = Integer.parseInt(txtfldSalary.getText());
					}
					catch (Exception e)
					{
						JOptionPane.showMessageDialog(null, "Salary must be an integer.", "Invalid Salary input", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}

				String address = txtfldAddress.getText();
				String phn = txtfldPhnNo.getText();
				String email = txtfldEmail.getText();

				String insertionQuery = "INSERT INTO employee (EmployeeID, EmployeeName, Rank, Department, Branch, JoiningDate, Salary, BirthDate, Address, Phone, Email)  VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

				isInsertionSuccessful = DatabaseHandler.insertRow(insertionQuery, employeeID, employeeName, rank, dept, branch, joinDate, salary, birthDate, address, phn, email);

				if (isInsertionSuccessful)
				{
					setVisible(false);
					JOptionPane.showMessageDialog(null, "Record inserted successfully.", "Insertion successful", JOptionPane.INFORMATION_MESSAGE);
					dispose();
				}
			}
		});
		btnInsert.setBounds(123, 463, 113, 28);
		contentPanel.add(btnInsert);

		btnClearFields = new JButton("Clear fields");
		btnClearFields.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				comboJoinYear.setSelectedIndex(0);
				comboJoinMonth.setSelectedIndex(0);
				comboJoinDay.setSelectedIndex(0);
				comboBirthYear.setSelectedIndex(0);
				comboBirthMonth.setSelectedIndex(0);
				comboBirthDay.setSelectedIndex(0);

				txtfldEmployeeID.setText("");
				txtfldEmployeeName.setText("");
				txtfldRank.setText("");
				txtfldDept.setText("");
				txtfldBranch.setText("");
				txtfldSalary.setText("");
				txtfldAddress.setText("");
				txtfldPhnNo.setText("");
				txtfldEmail.setText("");
			}
		});
		btnClearFields.setBounds(246, 463, 106, 28);
		contentPanel.add(btnClearFields);

		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				setVisible(false);
				dispose();
			}
		});
		btnCancel.setBounds(362, 463, 76, 28);
		contentPanel.add(btnCancel);

		setVisible(true);
	}
}
