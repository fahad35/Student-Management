package Project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.sql.*;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class markSheet extends JFrame {

	private JPanel contentPane;
	Connection cn = null;
	JTextArea textArea ;
	
	public static double bangla1,bangla2,english1,english2,math,gs,ss,re;
	public static String ban1,ban2,eng1,eng2,math1,gs1,ss1,re1,studentName,StudentID;
	

	
	 showResult sr=new  showResult();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					markSheet frame = new markSheet();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

    public int c;
    private JButton button;
    
    public void print() {
		try {
			Boolean complete = textArea.print();
			if (complete) {
				JOptionPane.showMessageDialog(null, "Priting Done!", null, JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Error!", null, JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
   

	public void dataShow() {
		textArea.append("\t .....SCHOLL NAME.... \t\n\n"+"Name:"+" "+" "+studentName+"\t\t"+"Id:"+" "+" "+StudentID+"\n\nSubject\t\t"+"Makrs\t\t"
	+"Grade\n\n"+"Bangla-I:\t\t"+bangla1+"\t\t"+ban1+"\n\nBnagla-II:\t\t"+bangla2+"\t\t"+ban2+
	"\n\nEnglish-I\t\t"+english1+"\t\t"+eng1+"\n\nEnglish-II\t\t"+english2+"\t\t"+eng2+"\n\nMathematics:\t\t"+math+"\t\t"+math1+"\n\nSocial Science:\t"+ss+
	"\t\t"+ss1+"\n\nGeneral Science:\t"+gs+"\t\t"+gs1+"\n\nReligion:\t\t"+re+"\t\t"+re1);
	}
	
	/**
	 * Create the frame.
	 */
	public markSheet() {
		setResizable(false);
		cn = SQLConnection.ConnecrDb();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 526, 455);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Print");
		btnNewButton.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		btnNewButton.setForeground(Color.GRAY);
		btnNewButton.setBounds(382, 384, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				print();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		textArea = new JTextArea();
		textArea.setBounds(35, 11, 441, 362);
		contentPane.add(textArea);
		
		button = new JButton("<<Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showResult s=new showResult();
				dispose();
				s.setVisible(true);
			}
		});
		button.setForeground(Color.GRAY);
		button.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		button.setBounds(45, 385, 89, 23);
		contentPane.add(button);
		dataShow();
	}
}
