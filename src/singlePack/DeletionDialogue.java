package singlePack;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class DeletionDialogue extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel lblAreYouSureToDelete;
	JButton btnDelete;
	JButton btnCancel;
	JCheckBox cbDeleteAll;

	boolean isDeletionSuccessful;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	DeletionDialogue(final Object[] primaryCellValues)
	{
		setIconImage(new ImageIcon(getClass().getResource("/images/ems_favicon.png")).getImage());
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
		setTitle("Delete record");
		setResizable(false);

		setBounds(100, 100, 360, 155);
		getContentPane().setLayout(null);

		lblAreYouSureToDelete = new JLabel("Are you sure you want to delete the selected record(s) ?");
		lblAreYouSureToDelete.setBounds(10, 11, 321, 14);
		getContentPane().add(lblAreYouSureToDelete);

		cbDeleteAll = new JCheckBox("Delete all records from this list.");
		cbDeleteAll.setBounds(6, 37, 223, 23);
		getContentPane().add(cbDeleteAll);

		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				setVisible(false);
				if (cbDeleteAll.isSelected())
				{
					isDeletionSuccessful = DatabaseHandler.deleteAllRows("delete from employee");
					if (isDeletionSuccessful)
						JOptionPane.showMessageDialog(null, "All records has been deleted successfully.", "Message", JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					isDeletionSuccessful = DatabaseHandler.deleteSelectedRow(primaryCellValues, "delete from employee where EmployeeID = ");
					if (isDeletionSuccessful)
						JOptionPane.showMessageDialog(null, "Selected records has been deleted successfully.", "Message", JOptionPane.INFORMATION_MESSAGE);
				}

				dispose();
			}
		});
		btnDelete.setBounds(81, 78, 89, 23);
		getContentPane().add(btnDelete);

		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				// setVisible(false);
				dispose();
			}
		});
		btnCancel.setBounds(187, 78, 89, 23);
		getContentPane().add(btnCancel);

		setVisible(true);

	}
}
