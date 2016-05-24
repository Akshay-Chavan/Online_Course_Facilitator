package com.oodp.ocf.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oodp.ocf.beans.User;

/**
 * Servlet implementation class CreateSession
 */
public class CreateSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateSession() {
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
		String KID,password,category;
		KID=request.getParameter("kid");
		password=request.getParameter("password");
		category=request.getParameter("category");
		User user = new User(KID,password,category);
		System.out.println(user.toString());
		if(user.validate()){
		 session=request.getSession(true);
		 session.setAttribute("kid", KID);
		 session.setAttribute("password", password);
		 session.setAttribute("category", category);
		 category.toLowerCase();
		 response.sendRedirect(category.toLowerCase()+"home.html");
		} else{
			out.print("<html><body style='background-color: #23262B; color: white;' > <h1>login unsuccessful</h1><br><a href='login.jsp'>login here</a></body></html>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
