package com.company.project.servlet01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login-servlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public LoginServlet() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        if("songlu".equals(username)&&"1718064048".equals(password)){
	            Cookie cookie = new Cookie(username, password);
	            response.addCookie(cookie);
	            response.sendRedirect("/JavaWebLogin48/welcome-servlet");
	        }else{
	            response.sendRedirect("/JavaWebLogin48/loginfail.html");
	        }
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doGet(request, response);
	}

}
