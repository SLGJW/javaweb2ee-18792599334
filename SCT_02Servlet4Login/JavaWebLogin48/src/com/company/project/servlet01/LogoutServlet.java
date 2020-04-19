package com.company.project.servlet01;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/logout-servlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public LogoutServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 response.setContentType("text/html;charset=utf-8");
	        PrintWriter out = response.getWriter();

	        Cookie cookie = new Cookie("songlu", "1718064048");
	        cookie.setMaxAge(0);
	        response.addCookie(cookie);

	        response.sendRedirect("/JavaWebLogin48/login.html");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doGet(request, response);
	}

}
