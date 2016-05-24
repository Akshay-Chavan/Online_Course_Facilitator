package com.oodp.ocf.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oodp.ocf.beans.CoursesAvailable;
import com.oodp.ocf.beans.Student;
import com.oodp.ocf.dao.CoursesDAO;
import com.oodp.ocf.dao.StudentsDAO;
import com.oodp.ocf.dao.Validation;

/**
 * Servlet implementation class ViewStudents
 */
public class ViewStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewStudents() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String semester;
		Validation validate = new Validation();
		int courseID, CRN;
		semester = request.getParameter("semester");
		//System.out.println(request.getParameter("courseid")+" "+request.getParameter("crn"));
		//if(validate.isInteger(request.getParameter("courseid"))&&validate.isInteger("crn")){
		courseID = Integer.parseInt(request.getParameter("courseid"));
		CRN = Integer.parseInt(request.getParameter("crn"));
		ArrayList<Student> studentList = new StudentsDAO().getStudents(semester, courseID, CRN);
		 out.print("<html> <head><link rel='stylesheet' type='text/css' href='mystyles.css'></head> <body bgcolor=\"#23262B\">	<center><h3 class=\"addTitle\">Student Management System</h3></center><center>");
		 if(studentList.isEmpty()){
			 out.print("<html><body style='background-color: #23262B; color: white; font-size: 28px, margin-left: 100px' > <center><h3>Sorry No Students Registered</h3></body></html>");
			 out.print("</body></html>");
		 }else{
			 out.print("<html><body style='background-color: #23262B; color: white; font-size: 28px, margin-left: 100px' > <center><h3>Students Registered</h3></body></html>");
	         String coursesTableHtml = getHTMLTableString(studentList);
	 		 out.print(coursesTableHtml);
	 		 out.print("<html><body style='background-color: #23262B; color: white;' > <center></body></html>");
	 		 out.print("</body></html>");
		 }
		/*}else{
			out.print("<html> <head><link rel='stylesheet' type='text/css' href='mystyles.css'></head> <body bgcolor=\"#23262B\">	<center><h3 class=\"addTitle\">Student Management System</h3></center><center>");
			out.print("<html><body style='background-color: #23262B; color: white; font-size: 28px, margin-left: 100px' > <center><h3>Please Enter Valid Values</h3></body></html>");
			out.print("</body></html>");
		}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	private String getHTMLTableString(ArrayList<Student> studentList) {
		Student student;
		String table = "<table cellpadding=\"10\" cellspacing=\"10\"><tr><th>KID</th><th>Student Name</th></tr>";
		try {
                for (int i = 0; i < studentList.size(); i++) {
                	student = studentList.get(i);
                	String row = "<tr><td>" + student.getKID() + "</td>" + "<td>" +student.getName()+"</td>"
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
