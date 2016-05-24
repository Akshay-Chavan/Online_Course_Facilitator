package com.oodp.ocf.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.oodp.ocf.factory.ConnectionFactory;

public class Validation {
	
	public boolean validateEntry(int courseId, int CRN, int Section){
		boolean valid = false;
		
		Connection conn = ConnectionFactory.getConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from courseavailable where courseid="+courseId+" AND coursenumber = "+CRN+" AND section = "+Section);
			if(rs.next()){
				valid = true;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection();
		}
		return valid;
	}

	public boolean validateEnt(int courseId, int CRN){
		boolean valid = false;
		
		Connection conn = ConnectionFactory.getConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from courseavailable where courseid="+courseId+" AND coursenumber = "+CRN);
			if(rs.next()){
				valid = true;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection();
		}
		return valid;
	}
	

	public boolean validateKID(String KID){
		boolean valid = false;
		
		Connection conn = ConnectionFactory.getConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from studentregistered where kid='"+KID+"'");
			if(rs.next()){
				valid = true;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection();
		}
		return valid;
	}
	


	
	public boolean isInteger(String val){
		
		boolean isValid = false;
		try {
			Integer.parseInt(val);
			isValid = true;
		} catch (Exception e) {
			isValid = false;
		}
		return isValid;
	}

}
