package com.company.project.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login-servlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    request.setCharacterEncoding("utf-8");
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        HttpSession session = request.getSession();
	        if("admin".equals(username)&&"123456".equals(password)){
	            session.setAttribute("user",username);
	            response.sendRedirect(request.getContextPath()+"/CRUD.jsp");
	        }else{
	            request.setAttribute("loginlose", "µÇÂ¼ÃûºÍÃÜÂë´íÎó»òÕßÎª¿Õ£¬µÇÂ½Ê§°Ü¯¯");
	            request.getRequestDispatcher("/index.jsp").forward(request, response);
	        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doGet(request, response);
	}

}
