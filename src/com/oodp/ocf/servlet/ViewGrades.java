package com.oodp.ocf.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oodp.ocf.beans.Grade;
import com.oodp.ocf.beans.Notice;
import com.oodp.ocf.dao.GradeDAO;
import com.oodp.ocf.dao.NoticeDAO;

/**
 * Servlet implementation class ViewGrades
 */
public class ViewGrades extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewGrades() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		String KID = (String)session.getAttribute("kid");
		ArrayList<Grade> gradeList = new GradeDAO().getGrades(KID);
		 if(gradeList.isEmpty()){
			 out.print("<html><body style='background-color: #23262B; color: white; font-size: 28px, margin-left: 100px' > <center><h3>You Grades Are Not Uploaded</h3></body></html>");
			 out.print("</body></html>");
		 }else{
			 out.print("<html> <head><link rel='stylesheet' type='text/css' href='mystyles.css'></head> <body bgcolor=\"#23262B\">	<center><h3 class=\"addTitle\">Student Management System</h3></center><center>");
			 out.print("<html><body style='background-color: #23262B; color: white; font-size: 28px, margin-left: 100px' > <center><h3>Grades</h3></body></html>");
	         String coursesTableHtml = getHTMLTableString(gradeList);
	 		 out.print(coursesTableHtml);
	 		 out.print("<html><body style='background-color: #23262B; color: white;' > <center></body></html>");
	 		 out.print("</body></html>");
		 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	private String getHTMLTableString(ArrayList<Grade> gradeList) {
		Grade grade;
		String table = "<table cellpadding=\"10\" cellspacing=\"10\"><tr><th>CourseID</th><th>Course Name</th><th>Grade</th>" +
				"</tr>";
		try {
                for (int i = 0; i < gradeList.size(); i++) {
                	grade = gradeList.get(i);
                	String row = "<tr><td>" + grade.getCourseId()+"</td>" + "<td>" +grade.getCourseName()+"</td>"
                	+"<td>" + grade.getGrade() + "</td>"
					+"</tr>";
                	table += row;
				}
                
                table += "</table></center>";

		} catch (Exception e) {
			table = "Unknown Error....";
		}
		return table;
	}
}
