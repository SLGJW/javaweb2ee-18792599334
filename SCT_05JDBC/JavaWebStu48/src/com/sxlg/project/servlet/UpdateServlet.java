package com.sxlg.project.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/update-servlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UpdateServlet() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String sid = request.getParameter("sid");
		String sname=request.getParameter("sname");
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
			String sql="update student set sname=? where sid=?";
			//������ѯ����
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, sname);
			pst.setString(2, sid);
			int i = pst.executeUpdate();
			PrintWriter out = response.getWriter();
			out.write("��Ϣ�޸ĳɹ����������Ӳ鿴<a href='login-servlet'>�鿴ѧ����Ϣ</a>");
			conn.close();
		}catch (Exception e) {
			System.out.println("ִ�г�����");
		}
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doGet(request, response);
	}

}
