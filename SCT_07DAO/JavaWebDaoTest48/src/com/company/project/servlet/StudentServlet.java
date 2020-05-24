package com.company.project.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.project.dao.oracleimpl.StudentDaoImpl;
import com.company.project.model.po.StudentPo;
import com.company.project.service.StudentService;
import com.company.project.service.impl.StudentServiceImpl;


@WebServlet(value = {"/student/add","/student/delete","/student/change"})
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentService studentService;
    public StudentServlet() {
    	this.studentService =  new StudentServiceImpl();
     
    }

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
        
		private void add(StudentPo studentPo) throws Exception {
		
		this.studentService.add(studentPo);
		
	}
		private void delete(int Sid) throws Exception {
			this.studentService.delete(Sid);
		}
		private void change(StudentPo studentPo) throws Exception {
			this.studentService.change(studentPo);
		}
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
		String url = request.getRequestURL().toString();
        PrintWriter out = response.getWriter();
		StudentPo studentPo = new StudentPo();
		studentPo.setSid( Integer.valueOf(request.getParameter("Sid")));
		studentPo.setSname(request.getParameter("Sname"));
		studentPo.setSbirthday(request.getParameter("Sbirthday"));
		studentPo.setSsex(request.getParameter("Ssex"));
		StudentPo studentPo1 = new StudentPo();
		studentPo1.setSid( Integer.valueOf(request.getParameter("Sid")));
		studentPo1.setSname(request.getParameter("Sname"));
		if (url.endsWith("/student/add")) {
			try {
				this.add(studentPo);
				 out.write("<h1>"+"插入数据成功"+"</h1>"+"<br>");
				 out.write("<div>"+"<h3>功能实现完成请</h3>"+"<a href=\"/javaWebDaoTest48/CRUD.jsp\">返回</a>"+"<h3>实现其他功能</h3>"+"</div>");
			} catch (Exception e) {
				System.out.println("插入数据出错了");
				
			}
			
		} else if (url.endsWith("/student/delete")) {
			  try {
				this.delete(Integer.valueOf(request.getParameter("Sid")));
			    out.write("<h1>"+"删除数据成功"+"</h1>");
			    out.write("<div>"+"<h3>功能实现完成请</h3>"+"<a href=\"/javaWebDaoTest48/CRUD.jsp\">返回</a>"+"<h3>实现其他功能</h3>"+"</div>");
			  } catch (Exception e) {
				System.out.println("删除数据出错了");
			} 
		}else if (url.endsWith("/student/change")) {
			try {
				this.change(studentPo1);
				out.write("<h1>"+"更新数据成功"+"</h1>");
				out.write("<div>"+"<h3>功能实现完成请</h3>"+"<a href=\"/javaWebDaoTest48/CRUD.jsp\">返回</a>"+"<h3>实现其他功能</h3>"+"</div>");
			} catch (Exception e) {
				System.out.println("更新数据出错了");
			}
		}
			
	}
		
		
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
