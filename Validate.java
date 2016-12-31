package com.servlet;

import java.sql.*;

public class Validate {

	public static boolean checkUser(String name, String password) {
		
		boolean status = false;
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Test","root", "mahendra@2016");
			
			PreparedStatement ps =con.prepareStatement
                    ("select * from register where email=? and pass=?");
			
			ps.setString(1, name);
	         ps.setString(2, password);
	         ResultSet rs =ps.executeQuery();
	         status = rs.next();
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
		return status;
		
		
		
	}
	
	
	
}
