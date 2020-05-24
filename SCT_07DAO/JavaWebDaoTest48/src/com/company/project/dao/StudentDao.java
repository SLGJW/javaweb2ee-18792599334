package com.company.project.dao;

import java.util.List;

import com.company.project.model.po.StudentPo;

public interface StudentDao {
	//����
		boolean insert(StudentPo studentPo) throws Exception;
		
		//����
		boolean update(StudentPo studentPo)throws Exception;
		//ɾ��
		boolean delete(int sid)throws Exception;
		//��ѯ����
		StudentPo findbyId(int sid)throws Exception;
		//��ѯ����
		List< StudentPo> findAll()throws Exception;

}
