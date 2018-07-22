package mySqlConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBaseConnection {
	
	public void getConnection(String URL,String User, String Password,String Quries,String columnIndex) {
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection xConnection = DriverManager.getConnection(URL, User, Password);
			Statement xStatement = xConnection.createStatement();
			ResultSet result = xStatement.executeQuery(Quries);
					
					result.getString(columnIndex);
			
			
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
