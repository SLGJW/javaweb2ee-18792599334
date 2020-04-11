package com.company.project.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/secondServlet")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SecondServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		 String studynum=request.getParameter("studynum");
         String name=request.getParameter("name");
         String birhtday = request.getParameter("birhtday");
         String  sex = request.getParameter("sex");
         String[] hobbys=request.getParameterValues("hobby");
		  out.println("学号： "+studynum+"<br>");
         out.println("姓名："+name+"<br>");
         out.print("生日："+birhtday+"<br>");
         out.print("性别："+sex+"<br>");
         out.print(" 体育爱好:");
         for(String h:hobbys){
             out.println(h+"<br>");
         }
		System.out.println("我是跳转以后处理的！！！");
		
		out.close();

		/*
		 * System.out.println(uString); System.out.println(pString);
		 */
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
