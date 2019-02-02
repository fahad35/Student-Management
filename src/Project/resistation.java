package Project;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.sql.*;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class resistation extends JFrame {

	private JPanel contentPane;
	private JTextField sName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					resistation frame = new resistation();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection cn = null;
	private JTextField fName;
	private JTextField mName;
	private JTextField mNo;
	private JTextField lcName;
	private JTextField lcMno;
	private JTextField sId;
	private JComboBox sceCB, sexCB, ClassCB, grpCB;

	public void inputData() {
		String s = sName.getText();
		String f = fName.getText();
		String m = mName.getText();
		String mb = mNo.getText();
		String lc = lcName.getText();
		String lcMb = lcMno.getText();
		String id = sId.getText();
		String sex = sexCB.getSelectedItem().toString();
		String cl = ClassCB.getSelectedItem().toString();
		String sec = sceCB.getSelectedItem().toString();
		String grp = grpCB.getSelectedItem().toString();
		String sql = "INSERT INTO resistation (Student_Name,Father_Name,Mother_Name,Mobile_No,Local_Gurdian,LoMobile_No,Student_Id,Sex,Class,Section,Groups) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, s);
			ps.setString(2, f);
			ps.setString(3, m);
			ps.setString(4, mb);
			ps.setString(5, lc);
			ps.setString(6, lcMb);
			ps.setString(7, id);
			ps.setString(8, sex);
			ps.setString(9, cl);
			ps.setString(10, sec);
			ps.setString(11, grp);
			ps.execute();
			JOptionPane.showMessageDialog(null, "Thanks for Regestation");
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	/* public static int binarySearch(int key, int a[]) { */
	/**
	 * Create the frame.
	 */
	public resistation() {

		cn = SQLConnection.ConnecrDb();
		setBackground(Color.BLACK);
		setTitle("Resistation");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 669, 402);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Student Resistation Form\r\n");
		lblNewLabel.setBounds(10, 11, 594, 33);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Student Name:\r\n");
		lblNewLabel_1.setBounds(20, 55, 117, 40);
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 14));
		lblNewLabel_1.setForeground(Color.WHITE);
		contentPane.add(lblNewLabel_1);

		JLabel lblFatherName = new JLabel("Father Name:");
		lblFatherName.setBounds(20, 94, 117, 40);
		lblFatherName.setForeground(Color.WHITE);
		lblFatherName.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 14));
		contentPane.add(lblFatherName);

		JLabel lblMobileNo = new JLabel("Mother Name");
		lblMobileNo.setBounds(20, 135, 117, 40);
		lblMobileNo.setForeground(Color.WHITE);
		lblMobileNo.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 14));
		contentPane.add(lblMobileNo);

		JLabel lblMotherName = new JLabel("Moblie No:\r\n");
		lblMotherName.setBounds(20, 176, 117, 40);
		lblMotherName.setForeground(Color.WHITE);
		lblMotherName.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 14));
		contentPane.add(lblMotherName);

		JLabel lblLocalGuardian = new JLabel("Local Guardian:");
		lblLocalGuardian.setBounds(20, 211, 117, 40);
		lblLocalGuardian.setForeground(Color.WHITE);
		lblLocalGuardian.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 14));
		contentPane.add(lblLocalGuardian);

		JLabel label = new JLabel("Moblie No:\r\n");
		label.setBounds(20, 251, 117, 40);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 14));
		contentPane.add(label);

		JLabel lblStudentId = new JLabel("Student Id:\r\n");
		lblStudentId.setBounds(358, 55, 117, 40);
		lblStudentId.setForeground(Color.WHITE);
		lblStudentId.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 14));
		contentPane.add(lblStudentId);

		JLabel lblStudentSection = new JLabel("\r\nSection:");
		lblStudentSection.setBounds(358, 176, 117, 40);
		lblStudentSection.setForeground(Color.WHITE);
		lblStudentSection.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 14));
		contentPane.add(lblStudentSection);

		sceCB = new JComboBox();
		sceCB.setBounds(485, 186, 149, 20);
		sceCB.setFont(new Font("Tahoma", Font.PLAIN, 11));
		sceCB.setForeground(Color.GRAY);
		sceCB.setModel(new DefaultComboBoxModel(new String[] { "A", "B", "C", "D" }));
		contentPane.add(sceCB);

		JLabel lblClass = new JLabel("Class:");
		lblClass.setBounds(358, 135, 117, 40);
		lblClass.setForeground(Color.WHITE);
		lblClass.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 14));
		contentPane.add(lblClass);

		JLabel lblSex = new JLabel("Sex:\r\n\r\n");
		lblSex.setBounds(358, 94, 117, 40);
		lblSex.setForeground(Color.WHITE);
		lblSex.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 14));
		contentPane.add(lblSex);

		sexCB = new JComboBox();
		sexCB.setBounds(485, 106, 149, 20);
		sexCB.setModel(new DefaultComboBoxModel(new String[] { "Male", "Female" }));
		sexCB.setForeground(Color.GRAY);
		sexCB.setFont(new Font("Tahoma", Font.PLAIN, 11));
		contentPane.add(sexCB);

		ClassCB = new JComboBox();
		ClassCB.setBounds(485, 147, 149, 20);
		ClassCB.setModel(new DefaultComboBoxModel(new String[] { "6", "7", "8", "9", "10" }));
		ClassCB.setForeground(Color.GRAY);
		ClassCB.setFont(new Font("Tahoma", Font.PLAIN, 11));
		contentPane.add(ClassCB);

		JLabel lblGroup = new JLabel("Group:.");
		lblGroup.setBounds(358, 211, 117, 40);
		lblGroup.setForeground(Color.WHITE);
		lblGroup.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 14));
		contentPane.add(lblGroup);

		grpCB = new JComboBox();
		grpCB.setBounds(485, 224, 149, 20);
		grpCB.setModel(new DefaultComboBoxModel(new String[] { "-", "Science", "Commerce", "Arts" }));
		grpCB.setForeground(Color.GRAY);
		grpCB.setFont(new Font("Tahoma", Font.PLAIN, 11));
		contentPane.add(grpCB);

		JButton btnNewButton = new JButton("Save");
		btnNewButton.setBounds(275, 322, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				inputData();
			}
		});

		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setForeground(Color.GRAY);
		contentPane.add(btnNewButton);

		sName = new JTextField();
		sName.setBackground(Color.WHITE);
		sName.setBounds(130, 66, 149, 20);
		sName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		sName.setForeground(Color.BLACK);
		contentPane.add(sName);
		sName.setColumns(10);

		fName = new JTextField();
		fName.setBackground(Color.WHITE);
		fName.setBounds(130, 106, 149, 20);
		fName.setForeground(Color.BLACK);
		fName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		fName.setColumns(10);
		contentPane.add(fName);

		mName = new JTextField();
		mName.setBackground(Color.WHITE);
		mName.setBounds(130, 147, 149, 20);
		mName.setForeground(Color.BLACK);
		mName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		mName.setColumns(10);
		contentPane.add(mName);

		mNo = new JTextField();
		mNo.setBounds(130, 186, 149, 20);
		mNo.setForeground(Color.BLACK);
		mNo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		mNo.setColumns(10);
		contentPane.add(mNo);

		lcName = new JTextField();
		lcName.setBounds(130, 223, 149, 20);
		lcName.setForeground(Color.BLACK);
		lcName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lcName.setColumns(10);
		contentPane.add(lcName);

		lcMno = new JTextField();
		lcMno.setBounds(130, 263, 149, 20);
		lcMno.setForeground(Color.BLACK);
		lcMno.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lcMno.setColumns(10);
		contentPane.add(lcMno);

		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBounds(10, 55, 295, 249);
		horizontalBox.setBorder(new LineBorder(Color.WHITE));
		contentPane.add(horizontalBox);

		sId = new JTextField();
		sId.setForeground(Color.BLACK);
		sId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		sId.setColumns(10);
		sId.setBounds(485, 67, 149, 20);
		contentPane.add(sId);

		Box horizontalBox_1 = Box.createHorizontalBox();
		horizontalBox_1.setBorder(new LineBorder(Color.WHITE));
		horizontalBox_1.setBounds(337, 55, 316, 249);
		contentPane.add(horizontalBox_1);

		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sName.setText(null);
				fName.setText(null);
				mName.setText(null);
				mNo.setText(null);
				lcName.setText(null);
				lcMno.setText(null);
				sId.setText(null);
			}
		});
		btnRefresh.setForeground(Color.GRAY);
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRefresh.setBounds(499, 322, 89, 23);
		contentPane.add(btnRefresh);

		JButton button_1 = new JButton("<<Back");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FristPage f = new FristPage();
				dispose();
				f.setVisible(true);
			}
		});
		button_1.setForeground(Color.GRAY);
		button_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_1.setBounds(62, 322, 89, 23);
		contentPane.add(button_1);
	}
}
