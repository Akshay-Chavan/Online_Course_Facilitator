package com.oodp.ocf.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

import com.oodp.ocf.beans.CourseRegistered;
import com.oodp.ocf.beans.Notice;
import com.oodp.ocf.beans.Student;
import com.oodp.ocf.factory.ConnectionFactory;

public class NoticeDAO {
	
	ArrayList<Notice> noticeList;
	ArrayList<Integer> courseIDList, courseNumberList;
	
	public String addNotice(String notice, int courseId, int CRN, int section, String kid){
		
		String professor = null,msg = null;
		Calendar calendar;
		Connection conn = ConnectionFactory.getConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from professor where kid='"+kid+"'");
			while(rs.next()){
				professor = rs.getString(2);
			}
			calendar = Calendar.getInstance();
			PreparedStatement pst = conn.prepareStatement("insert into notice values(?, ?, ?, ?, ?, ?)");
			pst.setInt(1, courseId);
			pst.setInt(2, CRN);
			pst.setInt(3, section);
			pst.setString(4, notice);
			pst.setString(5, professor);
			pst.setString(6, String.valueOf(calendar.getTime()));
			int i = pst.executeUpdate();
			
			if(i>0){
				msg = "Notice Added Successfully";
			}else{
				msg = "Error Adding Notice";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection();
		}
		return msg;
	}
	
public ArrayList<Notice> getNotice(String kid){
		
		ArrayList<CourseRegistered> courseList;
		CourseRegistered course;
		Notice notice;
		Connection conn = ConnectionFactory.getConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from studentregistered where kid='"+kid+"'");
			courseList = new ArrayList<CourseRegistered>();
			while(rs.next()){
				course = new CourseRegistered();
				course.setCourseId(rs.getInt(1));
				course.setCRN(rs.getInt(2));
				course.setSection(rs.getInt(5));
				courseList.add(course);
			}
			
			noticeList = new ArrayList<Notice>();
			for (int i = 0; i < courseList.size(); i++) {
				course = new CourseRegistered();
				course = courseList.get(i);
				Statement st = conn.createStatement();
				ResultSet rst = st.executeQuery("select * from notice where courseid = "+course.getCourseId()+" AND coursenumber = "+course.getCRN()+" AND section = "+course.getSection());
				while(rst.next()){
					notice = new Notice();
					notice.setFrom(rst.getString(5));
					notice.setCourseId(rst.getInt(1));
					notice.setSection(rst.getInt(3));
					notice.setNotice(rst.getString(4));
					notice.setTime(rst.getString(6));
					noticeList.add(notice);
				}
				
				st.close();
				rst.close();
				
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection();
		}
		return noticeList;
	}

}
