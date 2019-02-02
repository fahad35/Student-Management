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
import javax.swing.Box;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.sql.*;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class subject extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					subject frame = new subject();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
    
	Connection cn = null;

	marksEntry me = new marksEntry();

	public void inputData() {
		String one =me.sTable;      
		String  two = me.sTable1;   
		String  three = me.section;
		String ban=b1m.getText(); 
		double four=Double.valueOf(ban);
		String ban1 =b1.getText(); 
		double five=Double.valueOf(ban1);
		String eng1 = e1.getText();
		double  six =Double.valueOf(eng1);
		String eng2=e2.getText();
		double  seven =Double.valueOf(eng2);
		String math1=mathM.getText();
		double  eight=Double.valueOf(math1);
		String math2 = math.getText();
		double nine=Double.valueOf(math2);
		String gs1 =gsM.getText();
		double ten=Double.valueOf(gs1);
		String gs2 =gs.getText(); 
		double eleven=Double.valueOf(gs2);
		String  ss1=ssM.getText();
		double twelve=Double.valueOf(ss1);
		String ss2 =ss.getText();
		double thirteen=Double.valueOf(ss2);
		String  re1= reM.getText();
		double fourteen=Double.valueOf(re1);
		String re2 = re.getText();
		double fifteen=Double.valueOf(re2);
		String ban3 = b2m.getText();
		double sixteen=Double.valueOf(ban3);
		String ban4=b2.getText();
		double seventeen=Double.valueOf(ban4);
		String cl=me.class6;
		double bangla1=four+five;
		String bangla1G=grade(bangla1);
		double bangla2=sixteen+seventeen;
		String bangla2G=grade(bangla2);
		double english1=six;
		String english1G=grade(english1);
		double english2=seven;
		String english2G=grade(english2);
		double math=eight+nine;
		String mathG=grade(math);
		double generalS=ten+eleven;
		String generalSG=grade(generalS);
		double socialS=twelve+thirteen;
		String socialSG=grade(socialS);
		double res=fourteen+fifteen;
		String resG=grade(res);
		double total=bangla1+bangla2+english1+english2+math+generalS+socialS+res;
		String sql = "INSERT INTO marks (Student_Id,Student_Name,Section,Bangla1Mcq,Bangla1Cq,English1,Banagla2Cq,Bangla2Mcq,English2,MathematicsMcq,MathematicsCq,GscienceMcq,GscienceCq,SscienceMcq,SscienceCq,reMcq,Recq,class) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, one);
			ps.setString(2, two);
			ps.setString(3, three);
			ps.setDouble(4, four);
			ps.setDouble(5, five);
			ps.setDouble(6, six);
			ps.setDouble(9, seven);
			ps.setDouble(10, eight);
			ps.setDouble(11, nine);
			ps.setDouble(12, ten);
			ps.setDouble(13, eleven);
			ps.setDouble(14, twelve);
			ps.setDouble(15, thirteen);
			ps.setDouble(16, fourteen);
			ps.setDouble(17, fifteen);
			ps.setDouble(8, sixteen);
			ps.setDouble(7, seventeen);
			ps.setString(18, cl);
			ps.execute();
			insertData(one,two,three,bangla1,bangla1G,bangla2,bangla2G,english1,english1G,english2,english2G,math,mathG,generalS,generalSG,socialS,socialSG,res,resG,total,cl);
			JOptionPane.showMessageDialog(null, "Done!");
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
	




	private void insertData(String one, String two, String three, double banglaI, String banglaIg, double banglaII,
			String banglaIIg, double englishI, String englishIg, double englishII, String englishIIg, double math2,
			String mathG, double generalS, String generalSG, double socialS, String socialSG, double res, String resG,double sum,String cl) {
		String sql = "INSERT INTO result (Student_Id,Student_Name,Section,Bangla1,Bangla1G,Bangla2,Banagla2G,English1,English1G,english2,english2G,Mathematics,MathematicsG,Gscience,GscienceG,Sscience,SscienceG,re,ReG,total,class) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, one);
			ps.setString(2, two);
			ps.setString(3, three);
			ps.setDouble(4, banglaI);
			ps.setString(5, banglaIg);
			ps.setDouble(8, englishI);
			ps.setString(9, englishIg);
			ps.setDouble(10, englishII);
			ps.setString(11, englishIIg);
			ps.setDouble(12, math2);
			ps.setString(13, mathG);
			ps.setDouble(14, generalS);
			ps.setString(15, generalSG);
			ps.setDouble(16, socialS);
			ps.setString(17, socialSG);
			ps.setDouble(18, res);
			ps.setString(19, resG);
			ps.setDouble(6, banglaII);
			ps.setString(7, banglaIIg);
			ps.setDouble(20, sum);
			ps.setString(21, cl);
			ps.execute();
			JOptionPane.showMessageDialog(null, "Done!1");
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
	}





	public String grade(Double m) {
		String f="F";
		String b="B",b1="B+",a1="A",a2="A-",a="A+",c="C";
		if(m<40) {
			return f;
		}
		else if(m<50){
	      return c;
		}
		else if(m<60) {
			return b;
		}
		else if(m<70) {
			return a2;
		}
		else if(m<80) {
			return a1;
		}
		else
			return a;
	}

	/**
	 * Create the frame.
	 */
	public subject() {

		cn = SQLConnection.ConnecrDb();
		setBackground(Color.BLACK);
		setTitle("Subject");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 464);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Subject\r\n");
		lblNewLabel.setBounds(87, 11, 118, 31);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lblNewLabel.setForeground(Color.WHITE);
		contentPane.add(lblNewLabel);

		JLabel lblBanglai = new JLabel("Bangla-I");
		lblBanglai.setBounds(87, 53, 118, 31);
		lblBanglai.setForeground(Color.WHITE);
		lblBanglai.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		contentPane.add(lblBanglai);

		JLabel lblBanglaii = new JLabel("Bangla-II");
		lblBanglaii.setBounds(87, 95, 118, 31);
		lblBanglaii.setForeground(Color.WHITE);
		lblBanglaii.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		contentPane.add(lblBanglaii);

		JLabel lblEnglishi = new JLabel("English-I");
		lblEnglishi.setBounds(87, 137, 118, 31);
		lblEnglishi.setForeground(Color.WHITE);
		lblEnglishi.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		contentPane.add(lblEnglishi);

		JLabel lblMathematics = new JLabel("English-II");
		lblMathematics.setBounds(87, 179, 118, 31);
		lblMathematics.setForeground(Color.WHITE);
		lblMathematics.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		contentPane.add(lblMathematics);

		JLabel lblGeneralScience = new JLabel("Mathematics");
		lblGeneralScience.setBounds(87, 221, 118, 31);
		lblGeneralScience.setForeground(Color.WHITE);
		lblGeneralScience.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		contentPane.add(lblGeneralScience);

		JLabel lblSocialScience = new JLabel("General Science");
		lblSocialScience.setBounds(87, 263, 118, 31);
		lblSocialScience.setForeground(Color.WHITE);
		lblSocialScience.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		contentPane.add(lblSocialScience);

		JLabel lblReligion = new JLabel("Social Science");
		lblReligion.setBounds(87, 298, 118, 45);
		lblReligion.setForeground(Color.WHITE);
		lblReligion.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		contentPane.add(lblReligion);

		JLabel lblMcq = new JLabel("MCQ");
		lblMcq.setHorizontalAlignment(SwingConstants.CENTER);
		lblMcq.setForeground(Color.WHITE);
		lblMcq.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lblMcq.setBounds(257, 11, 118, 31);
		contentPane.add(lblMcq);

		JLabel lblCq = new JLabel("CQ");
		lblCq.setHorizontalAlignment(SwingConstants.CENTER);
		lblCq.setForeground(Color.WHITE);
		lblCq.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lblCq.setBounds(430, 11, 118, 31);
		contentPane.add(lblCq);

		b1m = new JTextField();
		b1m.setBounds(282, 60, 93, 20);
		contentPane.add(b1m);
		b1m.setColumns(10);

		b1 = new JTextField();
		b1.setColumns(10);
		b1.setBounds(440, 60, 93, 20);
		contentPane.add(b1);

		b2m = new JTextField();
		b2m.setFont(new Font("Tahoma", Font.PLAIN, 13));
		b2m.setForeground(Color.GRAY);
		b2m.setColumns(10);
		b2m.setBounds(282, 102, 93, 20);
		contentPane.add(b2m);

		b2 = new JTextField();
		b2.setColumns(10);
		b2.setBounds(440, 102, 93, 20);
		contentPane.add(b2);

		e1m = new JTextField();
		e1m.setHorizontalAlignment(SwingConstants.CENTER);
		e1m.setText("NULL");
		e1m.setForeground(Color.GRAY);
		e1m.setColumns(10);
		e1m.setBounds(282, 144, 93, 20);
		contentPane.add(e1m);

		e1 = new JTextField();
		e1.setColumns(10);
		e1.setBounds(440, 144, 93, 20);
		contentPane.add(e1);

		txtNull = new JTextField();
		txtNull.setForeground(Color.GRAY);
		txtNull.setHorizontalAlignment(SwingConstants.CENTER);
		txtNull.setText("NULL");
		txtNull.setColumns(10);
		txtNull.setBounds(282, 186, 93, 20);
		contentPane.add(txtNull);

		e2 = new JTextField();
		e2.setColumns(10);
		e2.setBounds(440, 186, 93, 20);
		contentPane.add(e2);

		mathM = new JTextField();
		mathM.setColumns(10);
		mathM.setBounds(282, 228, 93, 20);
		contentPane.add(mathM);

		math = new JTextField();
		math.setColumns(10);
		math.setBounds(440, 228, 93, 20);
		contentPane.add(math);

		gsM = new JTextField();
		gsM.setColumns(10);
		gsM.setBounds(282, 270, 93, 20);
		contentPane.add(gsM);

		gs = new JTextField();
		gs.setColumns(10);
		gs.setBounds(440, 270, 93, 20);
		contentPane.add(gs);

		ssM = new JTextField();
		ssM.setColumns(10);
		ssM.setBounds(282, 309, 93, 20);
		contentPane.add(ssM);

		ss = new JTextField();
		ss.setColumns(10);
		ss.setBounds(440, 309, 93, 20);
		contentPane.add(ss);

		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBorder(new LineBorder(Color.WHITE));
		horizontalBox.setBounds(76, 11, 171, 372);
		contentPane.add(horizontalBox);

		Box verticalBox_7 = Box.createVerticalBox();
		horizontalBox.add(verticalBox_7);

		Box verticalBox_14 = Box.createVerticalBox();
		horizontalBox.add(verticalBox_14);

		Box verticalBox_13 = Box.createVerticalBox();
		horizontalBox.add(verticalBox_13);

		Box verticalBox_12 = Box.createVerticalBox();
		horizontalBox.add(verticalBox_12);

		Box verticalBox_11 = Box.createVerticalBox();
		horizontalBox.add(verticalBox_11);

		Box verticalBox_9 = Box.createVerticalBox();
		horizontalBox.add(verticalBox_9);

		Box verticalBox_8 = Box.createVerticalBox();
		horizontalBox.add(verticalBox_8);

		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBorder(new LineBorder(Color.WHITE));
		verticalBox.setBounds(76, 11, 472, 44);
		contentPane.add(verticalBox);

		Box horizontalBox_5 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_5);

		Box horizontalBox_2 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2);

		Box horizontalBox_4 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_4);

		Box horizontalBox_3 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_3);

		Box verticalBox_1 = Box.createVerticalBox();
		verticalBox_1.setBorder(new LineBorder(Color.WHITE));
		verticalBox_1.setBounds(76, 53, 472, 44);
		contentPane.add(verticalBox_1);

		Box verticalBox_2 = Box.createVerticalBox();
		verticalBox_2.setBorder(new LineBorder(Color.WHITE));
		verticalBox_2.setBounds(76, 95, 472, 44);
		contentPane.add(verticalBox_2);

		Box verticalBox_3 = Box.createVerticalBox();
		verticalBox_3.setBounds(59, 163, 1, 1);
		contentPane.add(verticalBox_3);

		Box verticalBox_4 = Box.createVerticalBox();
		verticalBox_4.setBorder(new LineBorder(Color.WHITE));
		verticalBox_4.setBounds(76, 137, 472, 44);
		contentPane.add(verticalBox_4);

		Box verticalBox_5 = Box.createVerticalBox();
		verticalBox_5.setBorder(new LineBorder(Color.WHITE));
		verticalBox_5.setBounds(76, 179, 472, 44);
		contentPane.add(verticalBox_5);

		Box verticalBox_6 = Box.createVerticalBox();
		verticalBox_6.setBorder(new LineBorder(Color.WHITE));
		verticalBox_6.setBounds(76, 222, 472, 44);
		contentPane.add(verticalBox_6);

		Box verticalBox_10 = Box.createVerticalBox();
		verticalBox_10.setBorder(new LineBorder(Color.WHITE));
		verticalBox_10.setBounds(76, 263, 472, 44);
		contentPane.add(verticalBox_10);

		Box verticalBox_15 = Box.createVerticalBox();
		verticalBox_15.setBorder(new LineBorder(Color.WHITE));
		verticalBox_15.setBounds(76, 306, 472, 37);
		contentPane.add(verticalBox_15);

		Box horizontalBox_1 = Box.createHorizontalBox();
		horizontalBox_1.setBorder(new LineBorder(Color.WHITE));
		horizontalBox_1.setBounds(246, 11, 180, 372);
		contentPane.add(horizontalBox_1);

		JLabel lblReligion_1 = new JLabel("Religion");
		lblReligion_1.setForeground(Color.WHITE);
		lblReligion_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblReligion_1.setBounds(87, 346, 118, 37);
		contentPane.add(lblReligion_1);

		reM = new JTextField();
		reM.setColumns(10);
		reM.setBounds(282, 354, 93, 20);
		contentPane.add(reM);

		re = new JTextField();
		re.setColumns(10);
		re.setBounds(440, 356, 93, 20);
		contentPane.add(re);

		Box verticalBox_16 = Box.createVerticalBox();
		verticalBox_16.setBorder(new LineBorder(Color.WHITE));
		verticalBox_16.setBounds(76, 342, 472, 41);
		contentPane.add(verticalBox_16);

		JButton save = new JButton("Save");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				inputData();
			}
		});
		save.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		save.setForeground(Color.GRAY);
		save.setBounds(444, 394, 89, 23);
		contentPane.add(save);
		
		JButton button = new JButton("<<Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				marksEntry m= new marksEntry();
				dispose();
				m.setVisible(true);
			}
		});
		button.setForeground(Color.GRAY);
		button.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		button.setBounds(87, 394, 89, 23);
		contentPane.add(button);
	}

	JLabel label = new JLabel("New label");
	private JTextField b1m;
	private JTextField b1;
	private JTextField b2m;
	private JTextField b2;
	private JTextField e1m;
	private JTextField e1;
	private JTextField txtNull;
	private JTextField e2;
	private JTextField mathM;
	private JTextField math;
	private JTextField gsM;
	private JTextField gs;
	private JTextField ssM;
	private JTextField ss;
	private JTextField reM;
	private JTextField re;
}
