package tools;

import java.sql.*;
import com.mysql.jdbc.*;

public class DatabaseBroker {

	private static String dbName = "U06Joy";
	private static String url = "jdbc:mysql://3.227.166.251" + "/" + dbName;
	private static String user = "U06Joy";
	private static String pass = "53688781307";
	
	public static boolean connectToDatabase(String user, String pass) throws SQLException{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, pass);
			return !conn.isClosed();
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean connectToDatabase() throws SQLException{
		return connectToDatabase(user, pass);
	}
	
	public static boolean addCustomer() {
		return true;
	}
	
	public static boolean deleteCustomer() { 
		return true;
	}
	
	public static boolean updateCustomer() {
		return true;
	}
	
	public static boolean addAppointment() {
		return true;
	}
	
	public static boolean deleteAppointment() { 
		return true;
	}
	
	public static boolean updateAppointment() {
		return true;
	}

	public static String getUser() {
		return user;
	}

	public static void setUser(String user) {
		DatabaseBroker.user = user;
	}

	
	
}
