package com.company.project.servlet01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/welcome-servlet")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public WelcomeServlet() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html;charset=utf-8");
	        PrintWriter out = response.getWriter();
	        Cookie[] c = request.getCookies();
	        if(c!=null&&c.length>0){
	            for (Cookie c1 : c) {
	                String name = c1.getName();
	                String value = c1.getValue();
	                if(name.equals("songlu")&&value.equals("1718064048")){
	                    out.write("<html lang=\"en\">\n" +
	                            "<head>\n" +
	                            "    <meta charset=\"UTF-8\">\n" +
	                            "    <title>�ܱ�����ҳ��</title>\n" +
	                            "</head>\n" +
	                            "<body>\n" +
	                            "    <h1>��¼�ܱ���ҳ��</h1>\n" +
	                            "    <h3>��ӭ��·���ʱ�ϵͳ<a href=\"logout-servlet\">��ע����</a></h3>\n" +
	                            "</body>\n" +
	                            "</html>");
	                    return;
	                }
	            }
	        }
	        out.write("<html lang=\"en\">\n" +
	                "<head>\n" +
	                "    <meta charset=\"UTF-8\">\n" +
	                "    <title>δ��¼</title>\n" +
	                "</head>\n" +
	                "<body>\n" +
	                "    <h1>����δ��¼���޷����ʵ�¼�ܱ���ҳ��</h1>\n" +
	                "    <h3>����<a href=\"/JavaWebLogin48/login.html\">��¼</a></h3>\n" +
	                "</body>\n" +
	                "</html>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doGet(request, response);
	}

}
