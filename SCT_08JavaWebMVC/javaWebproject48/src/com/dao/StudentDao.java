package com.dao;

import com.domain.Course;
import com.domain.Student;
import com.domain.Teacher;

import java.util.List;
import java.util.Map;

public interface StudentDao {
   
    public Map<Course,Teacher> findCandT(Student student) throws Exception;
    
    public Student doLogin(Student student) throws Exception;
    
    public boolean chooseCourse(int sid,int cid) throws Exception;
    //鍙栨秷閫夎
    public boolean cancelCourse(int sid,int cid) throws Exception;
   
    public List<Object[]> findNot(int sid) throws Exception;
}
