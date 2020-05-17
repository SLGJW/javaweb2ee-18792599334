package com.sxlg.project.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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
	        String userName = request.getParameter("userName");
	        String passWord = request.getParameter("passWord");
	        HttpSession session = request.getSession();
	        if("admin".equals(userName)&&"123456".equals(passWord)){
	            session.setAttribute("user",userName);
	            
	    		response.setContentType("text/html;charset=utf-8");
	    		try {
	    			//���ء������ࡱ
	    			Class .forName("oracle.jdbc.driver.OracleDriver");
	    			//������url�����ַ���������ʽ:jdbc.oracle.thin:@localhost:1521:XE,�˿ںţ���������
	    			String  url ="jdbc:oracle:thin:@localhost:1521:XE";
	    			//�������û�����
	    			String username="superman";
	    			//����������/���롱
	    			String  password = "superman";
	    			//��ʼ�������ݿ����Ӷ���
	    		    Connection conn =DriverManager.getConnection(url, username, password);
	    			System.out.println("[��������] ��ϲ�������ݿ����ӳɹ���");
	    			//ִ��SQL���
	    			String sql = "select * from student";
	    			
	    			Statement st = conn.createStatement();
	    			
	    			ResultSet rt = st.executeQuery(sql);
	    			 PrintWriter out = response.getWriter();
	 	            out.write("<a href=\"AddStudent.jsp\">���ѧ��</a>");
	 	            out.write("<a href=\"select.html\">����ѧ��</a>");
	 	            out.write("<table>");
	 	            out.write("<tr>");
	 	            out.write("<th>ѧ��</th>");
	 	            out.write("<th>����</th>");
	 	            out.write("<th>����</th>");
	 	            out.write("<th>�Ա�</th>");
	 	            out.write("</tr>");
	 	            while(rt.next()) {
	 	                out.write("<tr>");
	 	                out.write("<td>"+rt.getString("sid")+"</td>"+"<div id='bt1'>"+"<a href=\"delete.jsp\">ɾ��</a>"+"</div>");
	 	                out.write("<td>"+rt.getString("sname")+"</td>");
	 	                out.write("<td>"+rt.getString("sbirthday")+"</td>");
	 	                out.write("<td>"+rt.getString("ssex")+"</td>");
	 	                out.write("</tr>");
	 	                out.write("<div id='bt1'>"+"<a href=\"delete.jsp\">ɾ��</a>"+"</div>");
	 	                out.write("<div id='bt2'>"+"<a href=\"update.jsp\">�޸�</a>"+"</div>");
	 	                out.write( " <head> <link rel='Stylesheet' href='./bt.css' type='text/css'> </head>");
	 	            }
	 	            out.write("<div id='bt3'>"+"<h3>����ʵ�����</h3>"+"<a href=\"index.jsp\">ע��</a>"+"</div>");
	 	            out.write("</table>");
	    			conn.close();
	    		}catch (Exception e) {
	    			System.out.println("ִ�г�����");
	    		}
	        }else{
	            request.setAttribute("loginlose", "�û������������");
	            request.getRequestDispatcher("/index.jsp").forward(request, response);
	            
	        }
	        		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
