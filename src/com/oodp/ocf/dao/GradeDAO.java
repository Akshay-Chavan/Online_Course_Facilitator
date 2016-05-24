package com.oodp.ocf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

import com.oodp.ocf.beans.CourseRegistered;
import com.oodp.ocf.beans.Grade;
import com.oodp.ocf.beans.Notice;
import com.oodp.ocf.factory.ConnectionFactory;

public class GradeDAO {
	
public String addGrade(String grade, int courseId, int CRN, int section, String kid){
		
		String courseName = null,msg = null;
		
		Connection conn = ConnectionFactory.getConnection();
		try {
			Statement st = conn.createStatement();
			ResultSet rst =st.executeQuery("select * from grades where kid='"+kid+"' AND courseid="+courseId);
			if(rst.next()){
				msg = "Student Already Graded For This Subject";
			}else{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from courseavailable where courseid="+courseId+" AND coursenumber="+CRN+" AND section="+section);
			while(rs.next()){
				courseName = rs.getString(3);
			}
			
			PreparedStatement pst = conn.prepareStatement("insert into grades values(?, ?, ?, ?, ?, ?)");
			pst.setInt(1, courseId);
			pst.setInt(2, CRN);
			pst.setString(3, courseName);
			pst.setInt(4, section);
			pst.setString(5, kid);
			pst.setString(6, grade);
			int i = pst.executeUpdate();
			
			if(i>0){
				msg = "Grade Added Successfully";
			}else{
				msg = "Error Adding Grade";
			}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection();
		}
		return msg;
	}

public ArrayList<Grade> getGrades(String kid){
	
	ArrayList<Grade> gradeList = null;
	Grade grade;
	
	Connection conn = ConnectionFactory.getConnection();
	try {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from grades where kid='"+kid+"'");
		gradeList = new ArrayList<Grade>();
		while(rs.next()){
			grade = new Grade();
			grade.setCourseId(rs.getInt(1));
			grade.setCRN(rs.getInt(2));
			grade.setCourseName(rs.getString(3));
			grade.setSection(rs.getInt(4));
			grade.setKID(rs.getString(5));
			grade.setGrade(rs.getString(6));
			gradeList.add(grade);
		}
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		ConnectionFactory.closeConnection();
	}
	return gradeList;
}

}
