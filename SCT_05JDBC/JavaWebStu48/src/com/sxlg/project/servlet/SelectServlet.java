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
			
			//������ѯ����
			PreparedStatement pst = conn.prepareStatement("select * from student where sid = ?");
			pst.setString(1, sid);
			ResultSet rt = pst.executeQuery();
			PrintWriter out = response.getWriter();
			 out.write("<table>");
	            out.write("<tr>");
	            out.write("<th>ѧ��</th>");
	            out.write("<th>����</th>");
	            out.write("<th>����</th>");
	            out.write("<th>�Ա�</th>");
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
		System.out.println("ִ�г�����");
	}

}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doGet(request, response);
	}

}
