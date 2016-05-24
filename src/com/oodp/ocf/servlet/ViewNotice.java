package com.oodp.ocf.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oodp.ocf.beans.CourseRegistered;
import com.oodp.ocf.beans.Notice;
import com.oodp.ocf.dao.CoursesDAO;
import com.oodp.ocf.dao.NoticeDAO;

/**
 * Servlet implementation class ViewNotice
 */
public class ViewNotice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewNotice() {
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
		ArrayList<Notice> noticeList = new NoticeDAO().getNotice(KID);
		 if(noticeList.isEmpty()){
			 out.print("<html><body style='background-color: #23262B; color: white; font-size: 28px, margin-left: 100px' > <center><h3>You Have No Notice To Display</h3></body></html>");
			 out.print("</body></html>");
		 }else{
			 out.print("<html> <head><link rel='stylesheet' type='text/css' href='mystyles.css'></head> <body bgcolor=\"#23262B\">	<center><h3 class=\"addTitle\">Student Management System</h3></center><center>");
			 out.print("<html><body style='background-color: #23262B; color: white; font-size: 28px, margin-left: 100px' > <center><h3>Notices</h3></body></html>");
	         String coursesTableHtml = getHTMLTableString(noticeList);
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
	
	private String getHTMLTableString(ArrayList<Notice> noticeList) {
		Notice notice;
		String table = "<table cellpadding=\"10\" cellspacing=\"10\"><tr><th>From</th><th>Notice</th><th>Sent</th>" +
				"</tr>";
		try {
                for (int i = noticeList.size()-1; i > -1; i--) {
                	notice = noticeList.get(i);
                	String row = "<tr><td>" + notice.getFrom()+"<br> CourseID: "+notice.getCourseId()+"\n <br> Section: "+notice.getSection()+"" + "</td>" + "<td>" +notice.getNotice()+"</td>"
                	+"<td>" + notice.getTime() + "</td>"
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
