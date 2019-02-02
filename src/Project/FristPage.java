package Project;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.Box;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class FristPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//connection();
					FristPage frame = new FristPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/*static Connection cn = null;
	
	public static void connection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanager", "root", "");
			System.out.println("Connected");
		} catch (Exception ex) {
			// JOptionPane.showMessageDialog(null,"Database not connected");
			System.out.println(ex);
		}
	}*/

	/**
	 * Create the frame.
	 */
	public FristPage() {
		setResizable(false);
		setBackground(Color.BLACK);
		setTitle("Student Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 449);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Manager");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 24));
		lblNewLabel.setBounds(10, 95, 641, 48);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Registration");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resistation r = new resistation();
				r.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setForeground(Color.GRAY);
		btnNewButton.setFont(new Font("Yu Gothic Light", Font.BOLD, 15));
		btnNewButton.setBounds(71, 244, 123, 48);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("\r\n");
		lblNewLabel_1.setIcon(new ImageIcon(FristPage.class.getResource("/Icon/user-add-icon.png")));
		lblNewLabel_1.setBounds(21, 245, 52, 48);
		contentPane.add(lblNewLabel_1);
		
		JButton btnMarkesEntry = new JButton("Marks Entry");
		btnMarkesEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				marksEntry m= new marksEntry();
				dispose();
				m.setVisible(true);
			}
		});
		btnMarkesEntry.setForeground(Color.GRAY);
		btnMarkesEntry.setFont(new Font("Yu Gothic Light", Font.BOLD, 15));
		btnMarkesEntry.setBounds(283, 244, 134, 48);
		contentPane.add(btnMarkesEntry);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(232, 244, 48, 48);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon(FristPage.class.getResource("/Icon/database-process-icon.png")));
		
		JButton btnResult = new JButton("Result\r\n");
		btnResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showResult s= new showResult ();
				dispose();
				s.setVisible(true);
			}
		});
		btnResult.setForeground(Color.GRAY);
		btnResult.setFont(new Font("Yu Gothic Light", Font.BOLD, 15));
		btnResult.setBounds(500, 244, 134, 48);
		contentPane.add(btnResult);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(FristPage.class.getResource("/Icon/process-icon.png")));
		label.setBounds(450, 244, 48, 48);
		contentPane.add(label);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBorder(new LineBorder(Color.WHITE));
		horizontalBox.setBounds(438, 216, 213, 98);
		contentPane.add(horizontalBox);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		horizontalBox_1.setBorder(new LineBorder(Color.WHITE));
		horizontalBox_1.setBounds(10, 216, 201, 98);
		contentPane.add(horizontalBox_1);
		
		Box horizontalBox_2 = Box.createHorizontalBox();
		horizontalBox_2.setBorder(new LineBorder(Color.WHITE));
		horizontalBox_2.setBounds(215, 216, 219, 98);
		contentPane.add(horizontalBox_2);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(143, 102, 46, 14);
		contentPane.add(label_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(FristPage.class.getResource("/Icon/write-document-icon.png")));
		lblNewLabel_3.setBounds(128, 0, 178, 128);
		contentPane.add(lblNewLabel_3);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setForeground(Color.GRAY);
		btnExit.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		btnExit.setBounds(525, 339, 89, 23);
		contentPane.add(btnExit);
	}
}
