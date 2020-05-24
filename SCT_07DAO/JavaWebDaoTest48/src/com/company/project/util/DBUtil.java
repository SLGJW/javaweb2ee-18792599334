
/*
 * 主题：数据库连接类
 * 文件名：
 * 作者：刘志宝
 * 创建日期：2016-08-18
 * 版权：版权所有 2015-2016 西安中卓信息技术有限公司
 * 描述：
 * 		
 * 注意：
 * 			
 * 修改人：刘志宝
 * 修改时间：2016-10-25
 * 修改单号：〈修改单号〉
 * 修改内容：〈修改内容〉
 */
package com.company.project.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//类：数据库连接。
public class DBUtil {
	//声明“数据库连接对象”，单例模式
	private static Connection conn;
	

	//方法：获取“数据库连接对象”，单例模式。
	public static Connection getConnection(){
		//判断“数据库连接对象”是否存在
		try {
			//判断条件：连接对象不为空  并且  连接对象不是关闭的
			if (conn != null  && !conn.isClosed()) {
				return conn;
				//返回成功后，后面的代码将不会被执行。
			}
			
			//加载“驱动类”
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//创建“URL连接字符串”。格式：jdbc:oracle:thin:@ 主机名/IP : 端口号 ：服务名称
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			
			//创建“用户名”
			String username = "superman";
			//创建“密码”
			String password = "superman";
			
			//初始化“数据库连接对象”
			conn = DriverManager.getConnection(url,username,password);
			System.out.println("[操作提示]恭喜您，数据库连接成功！");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	//方法:关闭"数据库连接对象"及"语句对象"
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
	
	//方法:关闭"数据库连接对象","语句对象"及"结果集对象"
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
