package com.oodp.ocf.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.oodp.ocf.beans.CoursesAvailable;
import com.oodp.ocf.beans.Student;
import com.oodp.ocf.factory.ConnectionFactory;

public class StudentsDAO {
	
	ArrayList<Student> studentList;
	ArrayList<String> kidList;
	
	public ArrayList<Student> getStudents(String semester, int courseId, int CRN){
		Student student;
		studentList =new ArrayList<Student>();
		kidList = new ArrayList<String>();
		Connection conn = ConnectionFactory.getConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from studentregistered where semester='"+semester+"' AND courseid = "+courseId+" AND coursenumber = "+CRN);
			while(rs.next()){
				kidList.add(rs.getString(4));
			}
			
			for (int i = 0; i < kidList.size(); i++) {
				
				Statement st = conn.createStatement();
				ResultSet rst = st.executeQuery("select * from student where kid = '"+kidList.get(i)+"'");
				while(rst.next()){
					student = new Student(rst.getString(1), rst.getString(2));
					studentList.add(student);
				}
				
				st.close();
				rst.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection();
		}
		return studentList;
	}

}
