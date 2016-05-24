package com.oodp.ocf.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oodp.ocf.beans.CoursesAvailable;
import com.oodp.ocf.dao.CoursesDAO;


/**
 * Servlet implementation class ViewAvailableCourses
 */
public class ViewAvailableCourses extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAvailableCourses() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String semester, major;
		semester = request.getParameter("semester");
		major = request.getParameter("major");
		ArrayList<CoursesAvailable> courseList = new CoursesDAO().getAvailableCourses(semester, major);
		 out.print("<html> <head><link rel='stylesheet' type='text/css' href='mystyles.css'></head> <body bgcolor=\"#23262B\">	<center><h3 class=\"addTitle\">Student Management System</h3></center><center>");
		 if(courseList.isEmpty()){
			 out.print("<html><body style='background-color: #23262B; color: white; font-size: 28px, margin-left: 100px' > <center><h3>Sorry No Courses Available For "+semester+"</h3></body></html>");
			 out.print("</body></html>");
		 }else{
			 out.print("<html><body style='background-color: #23262B; color: white; font-size: 28px, margin-left: 100px' > <center><h3>Available Courses</h3></body></html>");
	         String coursesTableHtml = getHTMLTableString(courseList);
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
	
	private String getHTMLTableString(ArrayList<CoursesAvailable> courseList) {
		CoursesAvailable course;
		String table = "<table cellpadding=\"10\" cellspacing=\"10\"><tr><th>CourseID</th><th>CRN</th><th>Course Name</th><th>Section</th><th>Time</th>" +
				" <th>Instructor</th><th>SeatsAvailable</th><th>Days</th></tr>";
		try {
                for (int i = 0; i < courseList.size(); i++) {
                	course = courseList.get(i);
                	String row = "<tr><td>" + course.getCourseId() + "</td>" + "<td>" +course.getCRN()+"</td>"
                	+"<td>" + course.getCourseName() + "</td>" + "<td>" +course.getSection()+"</td>"+"<td>"+course.getTime()+"</td>"
                	+"<td>" + course.getInstructor() + "</td>" + "<td>" +course.getSeatsAvailable()+"/"+course.getTotalSeats()+"</td>"+"<td>"+course.getDays()+"</td>"
					+"</tr>";
                	System.out.println("Course "+course.toString());
                	table += row;
				}
                
                table += "</table></center>";

		} catch (Exception e) {
			table = "Unknown Error....";
		}
		return table;
	}

}
