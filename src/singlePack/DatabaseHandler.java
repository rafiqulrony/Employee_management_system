package singlePack;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;

class DatabaseHandler {

	/**
	 * 
	 */

	private static Connection connection;
	private ResultSet resultSet;
	private ResultSetMetaData metaData;
	private int numberOfRows;

	static boolean connectToDatabase(String dATABASE_URL, String uSERNAME, String pASSWORD)
	{
		try
		{
			connection = (Connection) DriverManager.getConnection(dATABASE_URL, uSERNAME, pASSWORD);
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			String msg = "\nPlease ensure that the server is online and the database is at the right location. Then try again.";
			JOptionPane.showMessageDialog(null, e.getMessage()
					+ msg, "DATABASE ACCESS ERROR", JOptionPane.ERROR_MESSAGE);
			// System.exit(0);
			return false;
		}

		return true;
	}

	static void disconnectDB()
	{

		try
		{
			if (connection != null)
				connection.close();
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage(), "Message", JOptionPane.ERROR_MESSAGE);
		}

	}

	boolean performQuery(String q)
	{

		try
		{
			resultSet = connection.createStatement().executeQuery(q);
			metaData = resultSet.getMetaData();
			resultSet.last();
			numberOfRows = resultSet.getRow();
			return true;
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

	ResultSet getResultSet()
	{
		return resultSet;
	}

	ResultSetMetaData getResultSetMetaData()
	{
		return metaData;
	}

	int getNumberOfRows()
	{
		return numberOfRows;
	}

	static boolean insertRow(String insertionSQL, int employeeID, String employeeName, String rank, String dept,
			String branch, String joinDate, int salary, String birthDate, String address, String phn, String email)
	{
		boolean isInsertionSuccessful = false;
		PreparedStatement psInsert = null;
		try
		{
			psInsert = connection.prepareStatement(insertionSQL);

			psInsert.setInt(1, employeeID);
			psInsert.setString(2, employeeName);
			psInsert.setString(3, rank);
			psInsert.setString(4, dept);
			psInsert.setString(5, branch);
			psInsert.setString(6, joinDate);
			psInsert.setInt(7, salary);
			psInsert.setString(8, birthDate);
			psInsert.setString(9, address);
			psInsert.setString(10, phn);
			psInsert.setString(11, email);

			psInsert.execute();
		}
		catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage(), "Insertion failed: Error occurred", JOptionPane.ERROR_MESSAGE);
			return isInsertionSuccessful;
		}

		isInsertionSuccessful = true;
		return isInsertionSuccessful;

	}

	static boolean deleteSelectedRow(Object[] primaryCellValues, String deletionSQL)
	{
		boolean isDeletionSuccessful = false;

		for (int j = 0; j < primaryCellValues.length; j++)
		{
			try
			{
				connection.createStatement().executeUpdate(deletionSQL + primaryCellValues[j]);
			}
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e.getMessage(), "Deletion of the row with EmployeeID = "
						+ primaryCellValues[j] + " has failed.", JOptionPane.ERROR_MESSAGE);
				return isDeletionSuccessful;
			}
		}

		isDeletionSuccessful = true;
		return isDeletionSuccessful;
	}

	static boolean deleteAllRows(String deletionSQL)
	{
		boolean isDeletionSuccessful = false;

		try
		{
			connection.createStatement().executeUpdate(deletionSQL);
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage(), "Deletion failed", JOptionPane.ERROR_MESSAGE);
			return isDeletionSuccessful;
		}

		isDeletionSuccessful = true;
		return isDeletionSuccessful;
	}

	static boolean updateRow(String updatingSQL, String newValue)
	{
		boolean isUpdateSuccessful = false;
		PreparedStatement psUpdate = null;

		try
		{
			psUpdate = connection.prepareStatement(updatingSQL);
			psUpdate.setString(1, newValue);
			psUpdate.execute();
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage(), "Update failed: Error occurred", JOptionPane.ERROR_MESSAGE);
			return isUpdateSuccessful;
		}

		isUpdateSuccessful = true;
		return isUpdateSuccessful;

	}

}