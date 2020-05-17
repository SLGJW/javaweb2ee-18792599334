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
			//����SQL���			
			String sql = "insert into student(SID,SNAME,SBIRTHDAY,SSEX) values(?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, sid);
			pst.setString(2, sname);
			pst.setString(3, sbirthday);
			pst.setString(4, ssex);
			int i = pst.executeUpdate();					
			PrintWriter out = response.getWriter();
			out.write("��Ϣ����ɹ����������Ӳ鿴 <a href='login-servlet'>�鿴ѧ����Ϣ</a>");
		}
		catch (Exception e) {
			System.out.println("��������");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		this.doGet(request, response);
	}

}
