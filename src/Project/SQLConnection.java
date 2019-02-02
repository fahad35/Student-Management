package Project;

import java.sql.*;

import javax.swing.JOptionPane;

public class SQLConnection {

	static Connection conn;

	public static Connection ConnecrDb() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanager", "root", "");
			System.out.println("Connected");
			// JOptionPane.showMessageDialog(null, "Connected");
			return conn;
		} catch (Exception e) {
			// JOptionPane.showMessageDialog(null, "Database Connection Failed");
			return null;
		}
	}
}