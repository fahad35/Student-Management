package Project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class marksEntry extends JFrame {

	private JPanel contentPane;
	private JTextField Roll;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton btnEntry;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					marksEntry frame = new marksEntry();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection cn = null;
	private JTable table;
	private JTable table_1;
	JScrollPane sixTable;
	JComboBox secCB;
	public static String sTable, sTable1,section;
	public static String class6="6";
	private JTextField textField;

	/**
	 * Create the frame.
	 */

	public void dataShow() {
		try {
			section=secCB.getSelectedItem().toString();
			String sql = "SELECT Student_Id,Student_Name FROM resistation where Class=? AND Section=?";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, class6);
			ps.setString(2, section);
			ResultSet rs = ps.executeQuery();
			table_1.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
	
	public void searchDataShow() {
		try {
			section=secCB.getSelectedItem().toString();
			String rool=Roll.getText();
			String sql = "SELECT Student_Id,Student_Name FROM resistation where Class=6 AND Section=? AND Student_Id LIKE ?";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, section);
			ps.setString(2, rool);
			ResultSet rs = ps.executeQuery();
			table_1.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void tableDatashow() {
		try {
			int row = table_1.getSelectedRow();
			sTable = (table_1.getModel().getValueAt(row, 0).toString());
			sTable1 = (table_1.getModel().getValueAt(row, 1).toString());
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public marksEntry() {

		cn = SQLConnection.ConnecrDb();
		setBackground(Color.BLACK);
		setTitle("Marks Entry");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 668, 434);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Marks Entry\r\n");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 11, 642, 34);
		contentPane.add(lblNewLabel);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(20, 43, 607, 301);
		contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		tabbedPane.addTab("Class_6", null, panel, null);
		panel.setLayout(null);

		Roll = new JTextField();
		Roll.setBounds(378, 13, 121, 25);
		panel.add(Roll);
		Roll.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Section:\r\n");
		lblNewLabel_1.setBounds(10, 15, 77, 21);
		panel.add(lblNewLabel_1);

		secCB = new JComboBox();
		secCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		secCB.setBounds(82, 15, 105, 20);
		secCB.setForeground(Color.GRAY);
		secCB.setModel(new DefaultComboBoxModel(new String[] { "A", "B", "C", "D" }));
		panel.add(secCB);

		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchDataShow();
			}
		});
		btnNewButton.setBounds(503, 14, 89, 23);
		btnNewButton.setForeground(Color.GRAY);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel.add(btnNewButton);

		JLabel lblNewLabel_2 = new JLabel("Roll:");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		lblNewLabel_2.setForeground(Color.GRAY);
		lblNewLabel_2.setBounds(331, 14, 46, 21);
		panel.add(lblNewLabel_2);

		table = new JTable();
		table.setBounds(131, 180, 127, -47);
		panel.add(table);

		sixTable = new JScrollPane();
		sixTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnEntry.setVisible(true);
			}
		});
		sixTable.setBounds(31, 49, 432, 213);
		panel.add(sixTable);

		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnEntry.setVisible(true);
			}
		});
		sixTable.setViewportView(table_1);

		btnEntry = new JButton("Entry");
		btnEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tableDatashow();
				subject s = new subject();
				dispose();
				s.setVisible(true);
			}
		});
		btnEntry.setForeground(Color.GRAY);
		btnEntry.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEntry.setBounds(485, 122, 89, 23);
		panel.add(btnEntry);

		JButton btnNewButton_1 = new JButton("Ok");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dataShow();
			}
		});
		btnNewButton_1.setForeground(Color.GRAY);
		btnNewButton_1.setBounds(194, 14, 54, 23);
		panel.add(btnNewButton_1);
		btnEntry.setVisible(false);

		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.GRAY);
		tabbedPane.addTab("Class_7", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel label = new JLabel("Section:\r\n");
		label.setBounds(10, 11, 77, 21);
		panel_1.add(label);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "A", "B", "C", "D" }));
		comboBox_1.setForeground(Color.GRAY);
		comboBox_1.setBounds(72, 11, 105, 20);
		panel_1.add(comboBox_1);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(372, 11, 121, 25);
		panel_1.add(textField_1);

		JButton button = new JButton("Search");
		button.setForeground(Color.GRAY);
		button.setFont(new Font("Tahoma", Font.BOLD, 11));
		button.setBounds(503, 12, 89, 23);
		panel_1.add(button);

		JLabel label_4 = new JLabel("Roll:");
		label_4.setForeground(Color.GRAY);
		label_4.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		label_4.setBounds(331, 14, 46, 21);
		panel_1.add(label_4);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(60, 112, 86, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		textField.setText("Mark");

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Class_8", null, panel_2, null);
		panel_2.setLayout(null);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "A", "B", "C", "D" }));
		comboBox_2.setForeground(Color.GRAY);
		comboBox_2.setBounds(63, 14, 105, 20);
		panel_2.add(comboBox_2);

		JLabel label_1 = new JLabel("Section:\r\n");
		label_1.setBounds(10, 14, 77, 21);
		panel_2.add(label_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(378, 14, 121, 25);
		panel_2.add(textField_2);

		JButton button_1 = new JButton("Search");
		button_1.setForeground(Color.GRAY);
		button_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_1.setBounds(503, 15, 89, 23);
		panel_2.add(button_1);

		JLabel label_5 = new JLabel("Roll:");
		label_5.setForeground(Color.GRAY);
		label_5.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		label_5.setBounds(336, 17, 46, 21);
		panel_2.add(label_5);

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Class_9", null, panel_3, null);
		panel_3.setLayout(null);

		JLabel label_2 = new JLabel("Section:\r\n");
		label_2.setBounds(10, 11, 77, 21);
		panel_3.add(label_2);

		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] { "A", "B", "C" }));
		comboBox_3.setForeground(Color.GRAY);
		comboBox_3.setBounds(60, 11, 105, 20);
		panel_3.add(comboBox_3);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(374, 11, 121, 25);
		panel_3.add(textField_3);

		JButton button_2 = new JButton("Search");
		button_2.setForeground(Color.GRAY);
		button_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_2.setBounds(503, 12, 89, 23);
		panel_3.add(button_2);

		JLabel label_6 = new JLabel("Roll:");
		label_6.setForeground(Color.GRAY);
		label_6.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		label_6.setBounds(335, 14, 46, 21);
		panel_3.add(label_6);

		JPanel panel_4 = new JPanel();
		panel_4.setForeground(Color.GRAY);
		tabbedPane.addTab("Class_10", null, panel_4, null);
		panel_4.setLayout(null);

		JLabel label_3 = new JLabel("Section:\r\n");
		label_3.setBounds(10, 11, 77, 21);
		panel_4.add(label_3);

		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] { "A", "B", "C", "D" }));
		comboBox_4.setForeground(Color.GRAY);
		comboBox_4.setBounds(60, 11, 105, 20);
		panel_4.add(comboBox_4);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(378, 11, 121, 25);
		panel_4.add(textField_4);

		JButton button_3 = new JButton("Search");
		button_3.setForeground(Color.GRAY);
		button_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_3.setBounds(503, 12, 89, 23);
		panel_4.add(button_3);

		JLabel label_7 = new JLabel("Roll:");
		label_7.setForeground(Color.GRAY);
		label_7.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		label_7.setBounds(338, 14, 46, 21);
		panel_4.add(label_7);
		
		JButton button_4 = new JButton("<<Back");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 FristPage f= new  FristPage();
				 dispose();
				 f.setVisible(true);
			}
		});
		button_4.setForeground(Color.GRAY);
		button_4.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		button_4.setBounds(59, 355, 89, 25);
		contentPane.add(button_4);
	}
}
