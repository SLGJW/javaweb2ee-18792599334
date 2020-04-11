package com.company.project.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/indexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public IndexServlet() {
        super();
       
    }	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		  response.setCharacterEncoding("utf-8");
		  request.setCharacterEncoding("utf-8");
		  response.setContentType("text/html;charset=utf-8");
		  PrintWriter out = response.getWriter();
          String studynum=request.getParameter("studynum");
          String name=request.getParameter("name");
          String birhtday = request.getParameter("birhtday");
          String  sex = request.getParameter("sex");
          String[] hobbys=request.getParameterValues("hobby");
		  out.println("ѧ�ţ� "+studynum+"<br>");
          out.println("������"+name+"<br>");
          out.print("���գ�"+birhtday+"<br>");
          out.print("�Ա�"+sex+"<br>");
          out.print(" ��������:");
          for(String h:hobbys){
              out.println(h+"<br>");
          }
          System.out.println("����û��ת����ģ�����");
      /*RequestDispatcher requestDispatcher = request.getRequestDispatcher("/secondServlet");
       requestDispatcher.forward(request, response);*/
         out.close();
		
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		this.doGet(request, response);

}
}
