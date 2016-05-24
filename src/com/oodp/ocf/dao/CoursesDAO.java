package com.oodp.ocf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.oodp.ocf.beans.CourseRegistered;
import com.oodp.ocf.beans.CoursesAvailable;
import com.oodp.ocf.factory.ConnectionFactory;

public class CoursesDAO {
	ArrayList<CoursesAvailable> courseList;
	ArrayList<CourseRegistered> registeredList;
	
	public ArrayList<CoursesAvailable> getAvailableCourses(String semester, String major){
		CoursesAvailable courses;
		courseList =new ArrayList<CoursesAvailable>();
		Connection conn = ConnectionFactory.getConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from courseavailable where semester='"+semester+"' AND major='"+major+"'");
			while(rs.next()){
				courses = new CoursesAvailable();
				courses.setCourseId(rs.getInt(1));
				courses.setCRN(rs.getInt(2));
				courses.setCourseName(rs.getString(3));
				courses.setSection(rs.getInt(4));
				courses.setTime(rs.getString(5));
				courses.setInstructor(rs.getString(6));
				courses.setSeatsAvailable(rs.getInt(8));
				courses.setTotalSeats(rs.getInt(9));
				courses.setDays(rs.getString(10));
				courseList.add(courses);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection();
		}
		return courseList;
	}
	
	public String registerCourse(int courseId, int CRN, String KID, int section, String semester, String major){
		String msg = null;
		Connection conn = ConnectionFactory.getConnection();
		try {
			Statement st = conn.createStatement();
			ResultSet rst = st.executeQuery("select * from studentregistered where kid='"+KID+"' AND courseid="+courseId);
			if(rst.next()){
				msg="You Are Already Registered For Course";
			}else{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from courseavailable where courseid="+courseId+" AND coursenumber="+CRN);
			if(rs.next()){
				String coursename=rs.getString(3); 
				String time=rs.getString(5); 
				String days=rs.getString(10); 
				int seatsavailable=rs.getInt(8);
				if(seatsavailable<=0){
					msg = "Sorry Seats Are Full";
				}else{
					PreparedStatement pst = conn.prepareStatement("insert into studentregistered values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
					pst.setInt(1, courseId);
					pst.setInt(2, CRN);
					pst.setString(3, coursename);
					pst.setString(4, KID);
					pst.setInt(5, section);
					pst.setString(6, semester);
					pst.setString(7, major);
					pst.setString(8, time);
					pst.setString(9, days);
					int i=pst.executeUpdate();
					if(i>0){
						seatsavailable=seatsavailable-1;
						PreparedStatement pst1 = conn.prepareStatement("update courseavailable set seatsavailable="+seatsavailable+" where courseid="+courseId+" AND coursenumber="+CRN);
						pst1.executeUpdate();
						msg="Course Registered Successfully";
					}else{
						msg="Error Registering Subject";
					}
				}
			}else{
				msg="Please Provide Valid Details";
			}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection();
		}
		return msg;
	}
	
	public ArrayList<CourseRegistered> getCourseRegistered(String KID){
		CourseRegistered course;
		registeredList = new ArrayList<CourseRegistered>();
		Connection conn = ConnectionFactory.getConnection();
		try {
			Statement stmt = conn.createStatement();
			System.out.println("KID is "+KID);
			ResultSet rs = stmt.executeQuery("select * from studentregistered where kid='"+KID+"'");
			while(rs.next()){
				course = new CourseRegistered();
				course.setCourseName(rs.getString(3));
				course.setTime(rs.getString(8));
				course.setDays(rs.getString(9));
				System.out.println("Course Registered "+course.toString());
				registeredList.add(course);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection();
		}
		return registeredList;
	}
	
	public String addCourse(String courseName, int courseId){
		
		String msg = null;
		
		Connection conn = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement("insert into course values(?, ?)");
			pst.setInt(1, courseId);
			pst.setString(2, courseName);
			int i = pst.executeUpdate();
			if(i>0){
				msg = "Course Added Successfully";
			}else {
				msg = "Error Adding Course";
			}
			
		} catch (SQLException e) {
			msg = "Please Check Your CourseId";
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection();
		}
		return msg;
	}
	
public String removeCourse(int courseId){
		
		String msg = null;
		
		Connection conn = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement("delete from course where courseid="+courseId);
			int i = pst.executeUpdate();
			if(i>0){
				msg = "Course Removed Successfully";
			}else {
				msg = "Please Check Your CourseId";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection();
		}
		return msg;
	}
	
	public static void main(String[] args) {
		new CoursesDAO().getAvailableCourses("Spring 2015", "Computer Science");
	}
}
