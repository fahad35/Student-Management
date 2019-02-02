package Project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class showResult extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					showResult frame = new showResult();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection cn = null;
	private JTextField Roll;
	private JTable table;
	JButton btnMarkSheet;
	JComboBox secCB;
	public static String sTable, sTable1, section;

	public void dataShow() {
		try {
			section = secCB.getSelectedItem().toString();
			String sql = "SELECT Student_Id,Student_Name,total FROM result  where class=6 AND Section=?";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, section);
			ResultSet rs = ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void searchDataShow() {
		try {
			section = secCB.getSelectedItem().toString();
			String rool = Roll.getText();
			String sql = "SELECT Student_Id,Student_Name,total FROM result  where class=6 AND Section=? AND Student_Id LIKE ? ORDER BY total ASC";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, section);
			ps.setString(2, rool);
			ResultSet rs = ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void tableDatashow() {
		try {
			int row = table.getSelectedRow();
			sTable = (table.getModel().getValueAt(row, 0).toString());
			sTable1 = (table.getModel().getValueAt(row, 1).toString());
			System.out.println(sTable);
			System.out.println(sTable1);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

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

	/**
	 * Create the frame.
	 */

	public showResult() {
		setBackground(Color.WHITE);
		setTitle("Result");
		cn = SQLConnection.ConnecrDb();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 648, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color(47, 79, 79));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_2.setBounds(10, 45, 602, 334);
		panel.add(tabbedPane_2);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(60, 179, 113));
		tabbedPane_2.addTab("Class_6", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Section");
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 11, 56, 20);
		panel_1.add(lblNewLabel);

		secCB = new JComboBox();
		secCB.setModel(new DefaultComboBoxModel(new String[] { "-", "A", "B", "C", "D" }));
		secCB.setForeground(Color.GRAY);
		secCB.setBounds(66, 12, 105, 20);
		panel_1.add(secCB);

		JLabel label = new JLabel("Roll:");
		label.setForeground(Color.GRAY);
		label.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		label.setBounds(297, 11, 46, 21);
		panel_1.add(label);

		Roll = new JTextField();
		Roll.setColumns(10);
		Roll.setBounds(332, 10, 121, 25);
		panel_1.add(Roll);

		JButton button = new JButton("Search");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchDataShow();
			}
		});
		button.setForeground(Color.GRAY);
		button.setFont(new Font("Tahoma", Font.BOLD, 11));
		button.setBounds(462, 11, 89, 23);
		panel_1.add(button);

		JButton button_1 = new JButton("Ok");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dataShow();
			}
		});
		button_1.setForeground(Color.GRAY);
		button_1.setBounds(178, 11, 54, 23);
		panel_1.add(button_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 58, 433, 234);
		panel_1.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnMarkSheet.setVisible(true);

				try {
					int row = table.getSelectedRow();
					String ID_ = (table.getModel().getValueAt(row, 0)).toString();
					String query = "select * from result where ID ='" + ID_ + "'";
					PreparedStatement pst = cn.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					while (rs.next()) {
						markSheet. ban1 = rs.getString("Bangla1G");
						markSheet.ban2=rs.getString("Banagla2G");
						markSheet.eng1=rs.getString("English1G");
						markSheet.eng2=rs.getString("english2G");
						markSheet.math1=rs.getString("MathematicsG");
						markSheet.gs1=rs.getString("GscienceG");
						markSheet.ss1=rs.getString("SscienceG");
						markSheet.re1=rs.getString("ReG");
						markSheet.bangla1=rs.getDouble("Bangla1");
						markSheet.bangla2=rs.getDouble("Bangla2");
						markSheet.english1=rs.getDouble("English1");
						markSheet.english2=rs.getDouble("english2");
						markSheet.math=rs.getDouble("Mathematics");
						markSheet.gs=rs.getDouble("Gscience");
						markSheet.ss=rs.getDouble("Sscience");
						markSheet.re=rs.getDouble("re");
						markSheet.studentName=rs.getString("Student_Name");
						markSheet.StudentID=rs.getString("Student_Id");

					}
					pst.close();
					rs.close();
					// clickSound();
				}

				catch (Exception e) {
					e.printStackTrace();
				}

			}
		});

		btnMarkSheet = new JButton("Mark Sheet");
		btnMarkSheet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tableDatashow();
				markSheet m = new markSheet();
				dispose();
				m.setVisible(true);
			}
		});
		btnMarkSheet.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		btnMarkSheet.setForeground(Color.GRAY);
		btnMarkSheet.setBounds(482, 159, 105, 25);
		panel_1.add(btnMarkSheet);
		btnMarkSheet.setVisible(false);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		tabbedPane_2.addTab("Class_7", null, panel_2, null);
		panel_2.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(77, 70, 46, 14);
		panel_2.add(lblNewLabel_1);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		tabbedPane_2.addTab("Class_8", null, panel_3, null);
		panel_3.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(170, 102, 46, 14);
		panel_3.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(153, 49, 46, 14);
		panel_3.add(lblNewLabel_3);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		tabbedPane_2.addTab("Class_9", null, panel_4, null);
		panel_4.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(194, 117, 46, 14);
		panel_4.add(lblNewLabel_4);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		tabbedPane_2.addTab("Class_10", null, panel_5, null);
		panel_5.setLayout(null);

		JButton btnNewButton = new JButton("Print");
		btnNewButton.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				print();
			}
		});
		btnNewButton.setForeground(Color.GRAY);
		btnNewButton.setBounds(484, 390, 78, 25);
		panel.add(btnNewButton);

		JButton button_2 = new JButton("<<Back");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FristPage f = new FristPage();
				dispose();
				f.setVisible(true);
			}
		});
		button_2.setForeground(Color.GRAY);
		button_2.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 14));
		button_2.setBounds(69, 390, 89, 25);
		panel.add(button_2);
		
		JButton btnMarkWise = new JButton("Mark Wise");
		btnMarkWise.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				markWise m= new markWise();
				dispose();
				m.setVisible(true);
			}
		});
		btnMarkWise.setForeground(Color.GRAY);
		btnMarkWise.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 13));
		btnMarkWise.setBounds(266, 392, 106, 25);
		panel.add(btnMarkWise);
	}
}
