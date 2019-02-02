package Project;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.*;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class markWise extends JFrame {

	private JPanel contentPane;
	private JTable table;
	Connection cn = null;
	public static String section;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					markWise frame = new markWise();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	 showResult s= new  showResult ();
	 private JScrollPane scrollPane;
	 private JButton button_1;
	 
	 public void print() {
			try {
				Boolean complete = table.print();
				if (complete) {
					JOptionPane.showMessageDialog(null, "Priting Done!", null, JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Error!", null, JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	

	@SuppressWarnings("static-access")
	public void dataShow() {
		try {
			section = s.section;
			String sql = "SELECT Student_Id,Student_Name,total FROM result  where class=6 AND Section=? ORDER BY total DESC";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, section);
			ResultSet rs = ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	/**
	 * Create the frame.
	 */
	public markWise() {
		setBackground(Color.BLACK);
		setTitle("New Roll");
		cn = SQLConnection.ConnecrDb();
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 335);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 23, 396, 228);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton button = new JButton("Print");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				print();
			}
		});
		button.setForeground(Color.GRAY);
		button.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 13));
		button.setBounds(331, 261, 78, 25);
		contentPane.add(button);
		
		button_1 = new JButton("<<Back");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showResult s = new showResult();
				dispose();
				s.setVisible(true);
			}
		});
		button_1.setForeground(Color.GRAY);
		button_1.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 13));
		button_1.setBounds(44, 261, 89, 25);
		contentPane.add(button_1);
		dataShow();
	}
}
