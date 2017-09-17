package singlePack;

import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

class TableDataModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DatabaseHandler myHandler = new DatabaseHandler();

	@Override
	public int getColumnCount()
	{
		// TODO Auto-generated method stub
		try
		{
			return myHandler.getResultSetMetaData().getColumnCount();
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			return 0;
		}
	}

	@Override
	public int getRowCount()
	{
		// TODO Auto-generated method stub
		return myHandler.getNumberOfRows();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex)
	{
		// TODO Auto-generated method stub
		try
		{
			myHandler.getResultSet().absolute(rowIndex + 1);
			return myHandler.getResultSet().getObject(columnIndex + 1);
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			return "";
		}
	}

	public String getColumnName(int column)
	{
		try
		{
			return myHandler.getResultSetMetaData().getColumnName(column + 1);
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			return "";
		}

	}

	boolean viewQueryResult(String q)
	{
		if (myHandler.performQuery(q))
		{
			fireTableStructureChanged();
			return true;
		}
		else
			return false;
	}

}
