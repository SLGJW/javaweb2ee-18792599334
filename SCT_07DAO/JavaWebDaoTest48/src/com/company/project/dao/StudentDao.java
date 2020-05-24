package com.company.project.dao;

import java.util.List;

import com.company.project.model.po.StudentPo;

public interface StudentDao {
	//插入
		boolean insert(StudentPo studentPo) throws Exception;
		
		//更新
		boolean update(StudentPo studentPo)throws Exception;
		//删除
		boolean delete(int sid)throws Exception;
		//查询主键
		StudentPo findbyId(int sid)throws Exception;
		//查询所有
		List< StudentPo> findAll()throws Exception;

}
