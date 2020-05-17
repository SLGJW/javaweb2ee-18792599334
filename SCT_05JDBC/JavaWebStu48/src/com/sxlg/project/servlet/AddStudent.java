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
@WebServlet("/add-student")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AddStudent() {
        super();
      
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    request.setCharacterEncoding("utf-8");
		    response.setContentType("text/html;charset=utf-8");
		    String sid = request.getParameter("sid");
		    String sname = request.getParameter("sname");
		    String sbirthday = request.getParameter("sbirthday");
		    String ssex = request.getParameter("ssex");
		    //PrintWriter pw = response .getWriter();
		   // pw.write(sid);
		   
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
			//创建SQL语句			
			String sql = "insert into student(SID,SNAME,SBIRTHDAY,SSEX) values(?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, sid);
			pst.setString(2, sname);
			pst.setString(3, sbirthday);
			pst.setString(4, ssex);
			int i = pst.executeUpdate();					
			PrintWriter out = response.getWriter();
			out.write("信息保存成功，请点击链接查看 <a href='login-servlet'>查看学生信息</a>");
		}
		catch (Exception e) {
			System.out.println("语句出错了");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		this.doGet(request, response);
	}

}
