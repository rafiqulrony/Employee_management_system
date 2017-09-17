package singlePack;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

class HomeInterface extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e)
		{
		}

		EventQueue.invokeLater(new Runnable() {
			public void run()
			{
				try
				{
					HomeInterface frame = new HomeInterface();
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	HomeInterface()
	{
		setIconImage(new ImageIcon(getClass().getResource("/images/ems_favicon.png")).getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Employee management system");
		setResizable(false);

		setBounds(100, 100, 507, 223);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnViewEmployeeList = new JButton("View and manage the employee records...");
		btnViewEmployeeList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				setVisible(false);
				new TableDisplay(HomeInterface.this);
			}
		});
		btnViewEmployeeList.setBounds(128, 53, 248, 30);
		contentPane.add(btnViewEmployeeList);

		JLabel lblHelp = new JLabel("<html><u>Help</u></html>");
		lblHelp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				try
				{
					Desktop.getDesktop().browse(new URI("https://google.com"));
				}
				catch (IOException | URISyntaxException e)
				{
					JOptionPane.showMessageDialog(null, e.getMessage(), "Cannot open help link", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		lblHelp.setBounds(23, 153, 46, 14);
		contentPane.add(lblHelp);
		lblHelp.setFont(new Font("Georgia", Font.ITALIC, 12));
		lblHelp.setForeground(Color.BLUE);
		lblHelp.setCursor(new Cursor((Cursor.HAND_CURSOR)));

		JLabel lblAboutThisSoftware = new JLabel("<html><u>About this software</u></html>");
		lblAboutThisSoftware.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				new Info();
			}
		});
		lblAboutThisSoftware.setBounds(372, 153, 123, 14);
		contentPane.add(lblAboutThisSoftware);
		lblAboutThisSoftware.setFont(new Font("Georgia", Font.ITALIC, 12));
		lblAboutThisSoftware.setForeground(Color.BLUE);
		lblAboutThisSoftware.setCursor(new Cursor((Cursor.HAND_CURSOR)));

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
				DatabaseHandler.disconnectDB();
				System.exit(0);
			}
		});
	}
}