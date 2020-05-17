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
	    			//加载“驱动类”
	    			Class .forName("oracle.jdbc.driver.OracleDriver");
	    			//创建“url连接字符串”，格式:jdbc.oracle.thin:@localhost:1521:XE,端口号，服务名称
	    			String  url ="jdbc:oracle:thin:@localhost:1521:XE";
	    			//创建“用户名”
	    			String username="superman";
	    			//创建“口令/密码”
	    			String  password = "superman";
	    			//初始化“数据库连接对象”
	    		    Connection conn =DriverManager.getConnection(url, username, password);
	    			System.out.println("[操作提醒] 恭喜您，数据库连接成功！");
	    			//执行SQL语句
	    			String sql = "select * from student";
	    			
	    			Statement st = conn.createStatement();
	    			
	    			ResultSet rt = st.executeQuery(sql);
	    			 PrintWriter out = response.getWriter();
	 	            out.write("<a href=\"AddStudent.jsp\">添加学生</a>");
	 	            out.write("<a href=\"select.html\">查找学生</a>");
	 	            out.write("<table>");
	 	            out.write("<tr>");
	 	            out.write("<th>学号</th>");
	 	            out.write("<th>姓名</th>");
	 	            out.write("<th>生日</th>");
	 	            out.write("<th>性别</th>");
	 	            out.write("</tr>");
	 	            while(rt.next()) {
	 	                out.write("<tr>");
	 	                out.write("<td>"+rt.getString("sid")+"</td>"+"<div id='bt1'>"+"<a href=\"delete.jsp\">删除</a>"+"</div>");
	 	                out.write("<td>"+rt.getString("sname")+"</td>");
	 	                out.write("<td>"+rt.getString("sbirthday")+"</td>");
	 	                out.write("<td>"+rt.getString("ssex")+"</td>");
	 	                out.write("</tr>");
	 	                out.write("<div id='bt1'>"+"<a href=\"delete.jsp\">删除</a>"+"</div>");
	 	                out.write("<div id='bt2'>"+"<a href=\"update.jsp\">修改</a>"+"</div>");
	 	                out.write( " <head> <link rel='Stylesheet' href='./bt.css' type='text/css'> </head>");
	 	            }
	 	            out.write("<div id='bt3'>"+"<h3>功能实现完成</h3>"+"<a href=\"index.jsp\">注销</a>"+"</div>");
	 	            out.write("</table>");
	    			conn.close();
	    		}catch (Exception e) {
	    			System.out.println("执行出错了");
	    		}
	        }else{
	            request.setAttribute("loginlose", "用户名或密码错误");
	            request.getRequestDispatcher("/index.jsp").forward(request, response);
	            
	        }
	        		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
