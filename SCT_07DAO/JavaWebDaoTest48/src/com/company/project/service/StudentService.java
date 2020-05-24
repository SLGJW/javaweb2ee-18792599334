package com.company.project.service;

import java.util.List;


import com.company.project.model.po.StudentPo;

public interface StudentService {
	//����
	void add(StudentPo studentPo) throws Exception;
	//ɾ��
	void delete(int Sid)throws Exception;
	//�޸�
	void change(StudentPo studentPo)throws Exception;
	//��ѯ
	void findbyId(int Sid)throws Exception;
	//��ѯ����
	List< StudentPo> findAll()throws Exception;
	

}
