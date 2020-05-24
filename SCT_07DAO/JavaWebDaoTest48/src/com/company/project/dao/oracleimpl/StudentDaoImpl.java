package com.company.project.dao.oracleimpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.company.project.dao.StudentDao;
import com.company.project.model.po.StudentPo;
import com.company.project.util.DBUtil;

public class StudentDaoImpl  implements StudentDao {
	private Connection conn;
	
	public StudentDaoImpl() {
		conn = DBUtil.getConnection();
	}

	@Override
	public boolean insert(StudentPo studentPo) throws Exception {
		boolean flag = false;
		String sql = "insert into student(SID,SNAME,SBIRTHDAY,SSEX) values(?,?,?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, studentPo.getSid());
		pst.setString(2, studentPo.getSname());
		pst.setString(3, studentPo.getSbirthday());
		pst.setString(4, studentPo.getSsex());
		int i=pst.executeUpdate();
		if (i>0) {
			flag=true;
		}else {
			flag=false;
		}
		return flag;
	}

	@Override
	public boolean update(StudentPo studentPo) throws SQLException {
		boolean flag = false;
		String sql="update student set sname=? where sid=?";
		//构建查询对象
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, studentPo.getSname());
		pst.setInt(2, studentPo.getSid());
		int i = pst.executeUpdate();
		if (i>0) {
			flag=true;
		}else {
			flag=false;
		}
		return flag;
	}

	@Override
	public boolean delete(int Sid) throws SQLException {
		boolean flag = false;
		String sql ="delete student where Sid = ?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, Sid);
		ResultSet rt = pst.executeQuery();
		if (rt!=null) {
			flag=true;
		}else {
			flag= false;
		}
		return flag;
	}

	@Override
	public StudentPo findbyId(int Sid) throws SQLException {
		String sql="select Sid,Sname,Sbirthday,Ssex from STUDENT where Sid = ?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, Sid);
		StudentPo studentPo=null;
		ResultSet rt = pst.executeQuery();
        while(rt.next()) {
        	     studentPo = new StudentPo();
        		studentPo.setSid(rt.getInt(1));
        		studentPo.setSname(rt.getString(2));
        		studentPo.setSbirthday(rt.getString(3));
        		studentPo.setSsex(rt.getString(4));
        	 }
		
		
		return studentPo;
	}

	@Override
	public List<StudentPo> findAll() throws SQLException {
		List<StudentPo> studentPos =null;
		StudentPo studentPo=null;
		PreparedStatement st =null;
		String sql = "select Sid,Sname,Sbirthday,Ssex from STUDENT";
		
		 st = conn.prepareStatement(sql);
		
		ResultSet rt = st.executeQuery();
		
			while(rt.next()) {
				studentPo = new StudentPo();
				
				studentPos = new ArrayList<>();
				
				studentPo.setSid(rt.getInt("Sid"));
				
				studentPo.setSname(rt.getString("Sname"));
				
				studentPo.setSbirthday(rt.getString("Sbirthday"));
				
				studentPo.setSsex(rt.getString("Ssex"));
				
				studentPos.add(studentPo);
			}
		
		return studentPos;
	}

	
}
