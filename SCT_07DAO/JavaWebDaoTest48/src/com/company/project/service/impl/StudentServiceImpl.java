package com.company.project.service.impl;

import java.util.List;

import com.company.project.dao.StudentDao;
import com.company.project.dao.oracleimpl.StudentDaoImpl;
import com.company.project.model.po.StudentPo;
import com.company.project.service.StudentService;

public class StudentServiceImpl implements StudentService{
	private StudentDao studentdao;
	
	public StudentServiceImpl() {
		studentdao = new StudentDaoImpl();
	}

	@Override
	public void add(StudentPo studentPo) throws Exception {
		if (studentdao.insert(studentPo)==true) {
			System.out.println("�������ݳɹ�");
		}else {
			System.out.println("��������ʧ��");
		}
	}

	@Override
	public void delete(int Sid) throws Exception {
		if (studentdao.delete(Sid)==true) {
			System.out.println("ɾ���ɹ�");
			
		}else {
			System.out.println("ɾ��ʧ��");
		}
		
		
	}

	@Override
	public void change(StudentPo studentPo) throws Exception {
	if (studentdao.update(studentPo)==true) {
		System.out.println("���ݸ��³ɹ�");
	}else {
		System.out.println("���ݸ���ʧ��");
	}
		
	}

	@Override
	public void findbyId(int Sid) throws Exception {
		StudentPo studentPo = studentdao.findbyId(Sid);
		if (studentdao!=null) {
			System.out.println(studentPo);
		}else {
			System.out.println("��ѯʧ��");
		}
		
		
	}

	@Override
	public List<StudentPo> findAll() throws Exception {
		List<StudentPo> studentPos = studentdao.findAll();
		return studentPos;
	  
	}

	public StudentDao getStudentdao() {
		return studentdao;
	}

	public void setStudentdao(StudentDao studentdao) {
		this.studentdao = studentdao;
	}

	
}
