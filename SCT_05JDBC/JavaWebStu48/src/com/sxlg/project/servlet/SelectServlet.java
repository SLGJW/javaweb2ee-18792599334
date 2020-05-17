package com.sxlg.project.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SelectServlet
 */
@WebServlet("/select-servlet")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public SelectServlet() {
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String sid = request.getParameter("sid");
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
			
			//构建查询对象
			PreparedStatement pst = conn.prepareStatement("select * from student where sid = ?");
			pst.setString(1, sid);
			ResultSet rt = pst.executeQuery();
			PrintWriter out = response.getWriter();
			 out.write("<table>");
	            out.write("<tr>");
	            out.write("<th>学号</th>");
	            out.write("<th>姓名</th>");
	            out.write("<th>生日</th>");
	            out.write("<th>性别</th>");
	            out.write("</tr>");
	            while(rt.next()) {
	                out.write("<tr>");
	                out.write("<td>"+rt.getString("sid")+"</td>");
	                out.write("<td>"+rt.getString("sname")+"</td>");
	                out.write("<td>"+rt.getString("sbirthday")+"</td>");
	                out.write("<td>"+rt.getString("ssex")+"</td>");
	                out.write("</tr>");
	            }
	            out.write("</table>");
 			conn.close();
	}catch (Exception e) {
		System.out.println("执行出错了");
	}

}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doGet(request, response);
	}

}
