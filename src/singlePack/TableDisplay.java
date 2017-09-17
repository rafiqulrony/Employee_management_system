package singlePack;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableRowSorter;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.RowFilter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;

class TableDisplay extends JFrame {

	/**
	 * 
	 */

	String DATABASE_URL = "jdbc:mysql://localhost/company";
	String USERNAME = "root";
	String PASSWORD = "";

	private static final long serialVersionUID = 1L;
	JPanel contentPane;
	JScrollPane scrollPane;
	TableDataModel dataModel;
	JLabel lblResultTitle;
	JTextField txtFldFilter;
	TableRowSorter<TableDataModel> sorter;
	JLabel lblResultStatus;
	JButton btnBackToHome;
	JButton btnShowFullList;
	JButton btnAddToEmployee;
	JButton btnUpdateRecord;
	JButton btnDeleteRecord;
	JButton btnSubmitQuery;
	JButton btnFilterResult;
	JTextArea txtAreaQuery;
	String lastValidQuery = "Write a query...";
	String lastAppliedFilter = "";
	String resultTitleText = "FULL LIST OF EMPLOYEES";

	/**
	 * Create the frame.
	 * 
	 * @param objectOfHomeInterface
	 * @param actionListener
	 */
	TableDisplay(final HomeInterface objectOfHomeInterface)
	{
		setBounds(100, 100, 587, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblResultTitle = new JLabel("FULL LIST OF EMPLOYEES");
		lblResultTitle.setBounds(10, 11, 551, 14);
		contentPane.add(lblResultTitle);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 47, 561, 145);
		contentPane.add(scrollPane);
		// main operation now...
		if (!DatabaseHandler.connectToDatabase(DATABASE_URL, USERNAME, PASSWORD))
		{
			objectOfHomeInterface.setVisible(true);
			dispose();
			return;
		}

		dataModel = new TableDataModel();
		if (!(dataModel.viewQueryResult("select * from employee")))
		{
			objectOfHomeInterface.setVisible(true);
			dispose();
			return;
		}
		final JTable theTable = new JTable(dataModel);
		scrollPane.setViewportView(theTable);
		theTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		theTable.getTableHeader().setReorderingAllowed(false);

		lblResultStatus = new JLabel("Number of records " + theTable.getRowCount());
		lblResultStatus.setBounds(10, 197, 252, 14);
		contentPane.add(lblResultStatus);

		btnBackToHome = new JButton("Home");
		btnBackToHome.setBounds(11, 335, 72, 23);
		contentPane.add(btnBackToHome);
		btnShowFullList = new JButton("Show full list");
		btnShowFullList.setEnabled(false);
		btnShowFullList.setBounds(93, 335, 109, 23);
		contentPane.add(btnShowFullList);
		btnAddToEmployee = new JButton("Add record");
		btnAddToEmployee.setBounds(212, 335, 98, 23);
		contentPane.add(btnAddToEmployee);
		btnUpdateRecord = new JButton("Update record");
		btnUpdateRecord.setBounds(320, 335, 118, 23);
		contentPane.add(btnUpdateRecord);
		btnDeleteRecord = new JButton("Delete record");
		btnDeleteRecord.setBounds(447, 335, 114, 23);
		contentPane.add(btnDeleteRecord);
		btnSubmitQuery = new JButton("Submit this query");
		btnSubmitQuery.setBounds(427, 276, 134, 23);
		contentPane.add(btnSubmitQuery);
		btnFilterResult = new JButton("Filter result");
		btnFilterResult.setBounds(427, 224, 134, 23);
		contentPane.add(btnFilterResult);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 258, 407, 62);
		contentPane.add(scrollPane_1);

		txtAreaQuery = new JTextArea();
		scrollPane_1.setViewportView(txtAreaQuery);
		txtAreaQuery.setText(lastValidQuery);

		txtFldFilter = new JTextField();
		txtFldFilter.setBounds(10, 224, 407, 23);
		contentPane.add(txtFldFilter);
		txtFldFilter.setColumns(10);

		btnBackToHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				setVisible(false);
				objectOfHomeInterface.setVisible(true);
				dispose();
			}
		});

		btnFilterResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				sorter = new TableRowSorter<TableDataModel>(dataModel);
				theTable.setRowSorter(sorter);
				if (txtFldFilter.getText().length() == 0)
				{
					sorter.setRowFilter(null);
					lblResultStatus.setText("Number of records " + theTable.getRowCount());
					lblResultTitle.setText(resultTitleText);
				}
				else
				{
					sorter.setRowFilter(RowFilter.regexFilter("(?i)" + txtFldFilter.getText()));
					lblResultStatus.setText(theTable.getRowCount() + " record(s) contain '" + txtFldFilter.getText()
							+ "'.");
					btnShowFullList.setEnabled(true);
					lblResultTitle.setText(resultTitleText + " [Filtered]");
				}
				lastAppliedFilter = txtFldFilter.getText();
				txtAreaQuery.setText(lastValidQuery);
			}
		});

		btnDeleteRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				if (theTable.getSelectedRowCount() == 0)
				{
					int deleteAll = JOptionPane.showConfirmDialog(null, "No record is selected. Please select at least one record. Do you want to delete all records from this list instead?", "Deletion of record", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
					if (deleteAll == JOptionPane.YES_OPTION)
					{
						boolean isDeletionSuccessful = DatabaseHandler.deleteAllRows("delete from employee");
						if (isDeletionSuccessful)
						{
							JOptionPane.showMessageDialog(null, "All records has been deleted successfully.", "Message", JOptionPane.INFORMATION_MESSAGE);
							if (dataModel.viewQueryResult("select * from employee"))
							{
								lastValidQuery = "Write a query";
								txtAreaQuery.setText(lastValidQuery);
								if (sorter != null)
								{
									sorter.setRowFilter(null);
								}
								lastAppliedFilter = "";
								txtFldFilter.setText(lastAppliedFilter);
								lblResultTitle.setText("FULL LIST OF EMPLOYEES");
								resultTitleText = "FULL LIST OF EMPLOYEES";
								btnShowFullList.setEnabled(false);
								btnUpdateRecord.setEnabled(false);
								btnDeleteRecord.setEnabled(false);
								btnFilterResult.setEnabled(false);
								lblResultStatus.setText("Number of records " + theTable.getRowCount());
							}
						}
					}
				}
				else
				{
					int[] selectedRows = theTable.getSelectedRows();
					Object[] primaryCellValues = new Object[selectedRows.length];
					for (int i = 0; i < selectedRows.length; i++)
						primaryCellValues[i] = theTable.getValueAt(selectedRows[i], 0);

					DeletionDialogue deletion = new DeletionDialogue(primaryCellValues);
					if (deletion.isDeletionSuccessful)
					{
						if (lastValidQuery.equals("Write a query..."))
							dataModel.viewQueryResult("select * from employee");
						else
							dataModel.viewQueryResult(lastValidQuery);

						if ((sorter != null) && (sorter.getRowFilter() != null))
							lblResultStatus.setText(theTable.getRowCount() + " record(s) contain '"
									+ txtFldFilter.getText() + "'.");
						else
							lblResultStatus.setText("Number of records " + theTable.getRowCount());
					}

				}

				txtAreaQuery.setText(lastValidQuery);
				txtFldFilter.setText(lastAppliedFilter);
			}
		});

		btnUpdateRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				if (theTable.getSelectedRowCount() == 0)
					JOptionPane.showMessageDialog(null, "No cell is selected. Please select a cell.", "Update Information", JOptionPane.INFORMATION_MESSAGE);
				else if (theTable.getSelectedRowCount() > 1)
					JOptionPane.showMessageDialog(null, "Please select only one row to update a cell.", "Update Information", JOptionPane.INFORMATION_MESSAGE);

				else
				{
					int indexOfTheRowToBeUpdated = theTable.getSelectedRow();
					int indexOfTheColumnToBeUpdated = theTable.getSelectedColumn();
					String nameOfTheColumnToBeUpdated = theTable.getColumnName(indexOfTheColumnToBeUpdated);

					Object currentValue = theTable.getValueAt(indexOfTheRowToBeUpdated, indexOfTheColumnToBeUpdated);
					int employeeIDOfTheRowToBeUpdated = (int) theTable.getValueAt(indexOfTheRowToBeUpdated, 0);

					UpdateDialogue objectOfUpdateDialogue = new UpdateDialogue(employeeIDOfTheRowToBeUpdated, indexOfTheColumnToBeUpdated, nameOfTheColumnToBeUpdated, currentValue);

					if (objectOfUpdateDialogue.isUpdateSuccessful)
					{
						if (lastValidQuery.equals("Write a query..."))
							dataModel.viewQueryResult("select * from employee");
						else
							dataModel.viewQueryResult(lastValidQuery);

						if ((sorter != null) && (sorter.getRowFilter() != null))
							lblResultStatus.setText(theTable.getRowCount() + " record(s) contain '"
									+ txtFldFilter.getText() + "'.");
						else
							lblResultStatus.setText("Number of records " + theTable.getRowCount());
					}
				}

				txtAreaQuery.setText(lastValidQuery);
				txtFldFilter.setText(lastAppliedFilter);

			}
		});

		btnShowFullList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if (dataModel.viewQueryResult("select * from employee"))
				{
					lastValidQuery = "Write a query...";
					txtAreaQuery.setText(lastValidQuery);
					if (sorter != null)
					{
						sorter.setRowFilter(null);
					}
					lastAppliedFilter = "";
					txtFldFilter.setText(lastAppliedFilter);
					lblResultTitle.setText("FULL LIST OF EMPLOYEES");
					resultTitleText = "FULL LIST OF EMPLOYEES";
					btnShowFullList.setEnabled(false);
					btnUpdateRecord.setEnabled(true);
					btnDeleteRecord.setEnabled(true);
					lblResultStatus.setText("Number of records " + theTable.getRowCount());
				}
			}
		});

		btnAddToEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				InsertionDialogue insertion = new InsertionDialogue();
				if (insertion.isInsertionSuccessful)
				{
					if (dataModel.viewQueryResult("select * from employee"))
					{
						lastValidQuery = "Write a query";
						txtAreaQuery.setText(lastValidQuery);
						if (sorter != null)
						{
							sorter.setRowFilter(null);
						}
						lastAppliedFilter = "";
						txtFldFilter.setText(lastAppliedFilter);
						lblResultTitle.setText("FULL LIST OF EMPLOYEES");
						resultTitleText = "FULL LIST OF EMPLOYEES";
						btnShowFullList.setEnabled(false);
						btnUpdateRecord.setEnabled(true);
						btnDeleteRecord.setEnabled(true);
						btnFilterResult.setEnabled(true);
						lblResultStatus.setText("Number of records " + theTable.getRowCount());
					}
				}
			}
		});

		btnSubmitQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if (dataModel.viewQueryResult(txtAreaQuery.getText()))
				{
					lastValidQuery = txtAreaQuery.getText();
					btnShowFullList.setEnabled(true);
					btnFilterResult.setEnabled(true);

					String[] queryColumnNames = new String[theTable.getColumnCount()];
					String[] tableColumnNames = { "EmployeeID", "EmployeeName", "Rank", "Department", "Branch",
							"JoiningDate", "Salary", "BirthDate", "Address", "Phone", "Email" };
					for (int y = 0; y < queryColumnNames.length; y++)
						queryColumnNames[y] = theTable.getColumnName(y);
					if (Arrays.equals(queryColumnNames, tableColumnNames))
					{
						btnUpdateRecord.setEnabled(true);
						btnDeleteRecord.setEnabled(true);
					}
					else
					{
						btnUpdateRecord.setEnabled(false);
						btnDeleteRecord.setEnabled(false);
					}

					if (sorter != null)
					{
						sorter.setRowFilter(null);
					}
					lastAppliedFilter = "";
					txtFldFilter.setText(lastAppliedFilter);
					lblResultTitle.setText("QUERY RESULT:");
					resultTitleText = "QUERY RESULT:";
					lblResultStatus.setText("Number of records " + theTable.getRowCount());
				}

			}
		});

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
				objectOfHomeInterface.setVisible(true);
				dispose();
			}
		});

		setIconImage(new ImageIcon(getClass().getResource("/images/ems_favicon.png")).getImage());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Managing the employee records");
		setResizable(false);
		setVisible(true);
	}
}
