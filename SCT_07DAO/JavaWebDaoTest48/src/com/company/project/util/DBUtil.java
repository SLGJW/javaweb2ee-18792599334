
/*
 * ���⣺���ݿ�������
 * �ļ�����
 * ���ߣ���־��
 * �������ڣ�2016-08-18
 * ��Ȩ����Ȩ���� 2015-2016 ������׿��Ϣ�������޹�˾
 * ������
 * 		
 * ע�⣺
 * 			
 * �޸��ˣ���־��
 * �޸�ʱ�䣺2016-10-25
 * �޸ĵ��ţ����޸ĵ��š�
 * �޸����ݣ����޸����ݡ�
 */
package com.company.project.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//�ࣺ���ݿ����ӡ�
public class DBUtil {
	//���������ݿ����Ӷ��󡱣�����ģʽ
	private static Connection conn;
	

	//��������ȡ�����ݿ����Ӷ��󡱣�����ģʽ��
	public static Connection getConnection(){
		//�жϡ����ݿ����Ӷ����Ƿ����
		try {
			//�ж����������Ӷ���Ϊ��  ����  ���Ӷ����ǹرյ�
			if (conn != null  && !conn.isClosed()) {
				return conn;
				//���سɹ��󣬺���Ĵ��뽫���ᱻִ�С�
			}
			
			//���ء������ࡱ
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//������URL�����ַ���������ʽ��jdbc:oracle:thin:@ ������/IP : �˿ں� ����������
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			
			//�������û�����
			String username = "superman";
			//���������롱
			String password = "superman";
			
			//��ʼ�������ݿ����Ӷ���
			conn = DriverManager.getConnection(url,username,password);
			System.out.println("[������ʾ]��ϲ�������ݿ����ӳɹ���");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	//����:�ر�"���ݿ����Ӷ���"��"������"
	public static void closeConnection(Connection conn ,Statement statement) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//����:�ر�"���ݿ����Ӷ���","������"��"���������"
	public static void closeConnection(Connection conn ,Statement statement ,ResultSet resultSet) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (resultSet  != null) {
			
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
