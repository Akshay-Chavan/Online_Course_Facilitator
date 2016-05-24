package com.oodp.ocf.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.oodp.ocf.factory.ConnectionFactory;

public class AuthenticateDAO {

	public boolean authenticateUser(String KID, String password, String category){
		boolean valid=false;
		Connection conn = ConnectionFactory.getConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from authenticate where userid='"+KID+"' AND password='"+password+"' AND category='"+category+"'");
			if(rs.next()){
				valid=true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection();
		}
		System.out.println(valid);
		return valid;
	}
	
	
}
