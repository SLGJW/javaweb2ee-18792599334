package com.company.project.testdao;

import java.util.List;

import com.company.project.dao.StudentDao;
import com.company.project.dao.oracleimpl.StudentDaoImpl;
import com.company.project.model.po.StudentPo;

import junit.framework.TestCase;

public class StudentDaoTest extends TestCase{
	
	public void testfindById() throws Exception {
		StudentDao studentdao = new StudentDaoImpl();
		
		StudentPo studentPo = studentdao.findbyId(333333);
		if (studentdao!=null) {
			System.out.println(studentPo);
		}else { 
			System.out.println("���Ϊ��");
		}
	}	
	
	public void testfindall() throws Exception {
		//����dao����
		
		StudentDao studentDao = new StudentDaoImpl();
		
		//���ս��
		
		List<StudentPo> studentPos =studentDao.findAll();
		//����
		for (StudentPo studentPo : studentPos) {
			System.out.println(studentPo);
		}
		
	}

}
