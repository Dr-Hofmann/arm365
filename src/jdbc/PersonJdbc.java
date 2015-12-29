package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PersonJdbc {
	
	
	String url ="jdbc:mysql://172.16.1.11:3306/data";
	String login = "user";
	String pass = "1qazXSW2";
	Connection conn =null;
	Statement stmt= null;
	ResultSet rs = null;
	String log;
	String passwd;
	 
	public PersonJdbc(){
		
	
		 try {
			 
			// Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,login,pass);
			System.out.println("Connection established!!!");
			
			
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery("select * from Auth");
			
			if(rs.next()){
			 log = rs.getString("login");
			 passwd = rs.getString("password");
				
				System.out.println(log + pass);
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			 
	 }
	
	public boolean checkAuth(String str1, String str2){
		if(log.equals(str1) && passwd.equals(str2)){
			return true;
		}
		return false;
	}
}
