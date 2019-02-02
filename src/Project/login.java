package Project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JPasswordField pass;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void log(){
		String n = name.getText();
		String p= pass.getText();
        if(n.contains("Fahad")&&p.contains("1234")){
        	FristPage f =new FristPage();
        	dispose();
        	f.setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(null, "Log In UnSuccessful");
        }
	}
	

	/**
	 * Create the frame.
	 */
	public login() {

		setBackground(Color.BLACK);
		setTitle("Login");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 283);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Student Manager");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Yu Gothic UI", Font.BOLD, 24));
		label.setBounds(10, 61, 499, 48);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(login.class.getResource("/Icon/write-document-icon.png")));
		lblNewLabel.setBackground(Color.CYAN);
		lblNewLabel.setBounds(20, 0, 135, 136);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(login.class.getResource("/Icon/Status-dialog-password-icon.png")));
		lblNewLabel_2.setBounds(227, 155, 24, 24);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(login.class.getResource("/Icon/Person-Male-Light-icon.png")));
		lblNewLabel_3.setBounds(227, 120, 24, 24);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("User Name:");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(250, 120, 113, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblPassword = new JLabel("Password:\r\n");
		lblPassword.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(250, 155, 113, 24);
		contentPane.add(lblPassword);
		
		name = new JTextField();
		name.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==KeyEvent.VK_ENTER) {
					JOptionPane.showMessageDialog(null, "Scan Done!");
				}
			}
		});
		name.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		name.setBounds(340, 124, 121, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		pass = new JPasswordField();
		pass.setBounds(340, 160, 121, 20);
		contentPane.add(pass);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				log();
			}
		});
		btnNewButton.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		btnNewButton.setForeground(Color.GRAY);
		btnNewButton.setBounds(364, 191, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setForeground(Color.GRAY);
		btnExit.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		btnExit.setBounds(55, 194, 89, 23);
		contentPane.add(btnExit);
	}
}
