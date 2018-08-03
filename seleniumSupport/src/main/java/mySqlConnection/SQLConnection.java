package mySqlConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class SQLConnection {
	
	public void getDataBaseConnection(String URL,String UserName,String Password,	String SQLQuery) {
		try {
	
			Class.forName("com.mysql.jdbc.Driver");
			Connection	 xConnection = DriverManager.getConnection(URL,UserName,Password);
			Statement xStatement = xConnection.createStatement();
			ResultSet xresult = xStatement.executeQuery(SQLQuery);
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
