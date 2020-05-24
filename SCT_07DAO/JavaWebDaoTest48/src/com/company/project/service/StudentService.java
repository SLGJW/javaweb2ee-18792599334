package com.company.project.service;

import java.util.List;


import com.company.project.model.po.StudentPo;

public interface StudentService {
	//增加
	void add(StudentPo studentPo) throws Exception;
	//删除
	void delete(int Sid)throws Exception;
	//修改
	void change(StudentPo studentPo)throws Exception;
	//查询
	void findbyId(int Sid)throws Exception;
	//查询所有
	List< StudentPo> findAll()throws Exception;
	

}
