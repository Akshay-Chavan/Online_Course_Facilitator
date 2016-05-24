package com.oodp.ocf.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oodp.ocf.dao.CoursesDAO;
import com.oodp.ocf.dao.NoticeDAO;
import com.oodp.ocf.dao.Validation;

/**
 * Servlet implementation class AddNotice
 */
public class AddNotice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNotice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		HttpSession session;
		session = request.getSession();
		Validation validate = new Validation();
		String kid, notice;
		int courseId, CRN, section;
		kid = (String)session.getAttribute("kid");
		notice=request.getParameter("notice");
		if((validate.isInteger(request.getParameter("courseid"))) && (validate.isInteger(request.getParameter("crn"))) && (validate.isInteger(request.getParameter("section")))){
		courseId = Integer.parseInt(request.getParameter("courseid"));
		CRN = Integer.parseInt(request.getParameter("crn"));
		section = Integer.parseInt(request.getParameter("section"));
		if(validate.validateEntry(courseId, CRN, section)){
		
		String msg = new NoticeDAO().addNotice(notice, courseId, CRN, section, kid);
		
		 out.print("<html> <head><link rel='stylesheet' type='text/css' href='mystyles.css'></head> <body bgcolor=\"#23262B\">	<center><h3 class=\"addTitle\">Student Management System</h3></center><center>");
		 out.print("<html><body style='background-color: #23262B; color: white; font-size: 28px, margin-left: 100px' > <center><h3>"+msg+"</h3></body></html>");
		 out.print("</body></html>");
		}else{
		out.print("<html> <head><link rel='stylesheet' type='text/css' href='mystyles.css'></head> <body bgcolor=\"#23262B\">	<center><h3 class=\"addTitle\">Student Management System</h3></center><center>");
		 out.print("<html><body style='background-color: #23262B; color: white; font-size: 28px, margin-left: 100px' > <center><h3>Please Check Your Entries</h3></body></html>");
		 out.print("</body></html>");
		}
		}else{
			out.print("<html> <head><link rel='stylesheet' type='text/css' href='mystyles.css'></head> <body bgcolor=\"#23262B\">	<center><h3 class=\"addTitle\">Student Management System</h3></center><center>");
			 out.print("<html><body style='background-color: #23262B; color: white; font-size: 28px, margin-left: 100px' > <center><h3>Please Enter Valid Values</h3></body></html>");
			 out.print("</body></html>");
		}
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
