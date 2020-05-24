/**
 * 主题：数据库连接单元测试
 * 作者：刘志宝
 * 时间：2016年8月29日
 * 描述：
 * 		
 * 		演示用户名密码错误异常；
 * 注意：
 * 		
 */

package com.company.project.testutil;

import java.sql.Connection;
import com.company.project.util.DBUtil;
import junit.framework.TestCase;

//类：数据库测试。
public class TestDBUtil extends TestCase {

	// 方法：测试数据库连接
	public void testGetConnection() {

		Connection conn = DBUtil.getConnection();

		if (conn != null) {
			System.out.println("[测试提示]数据库连接成功！");
		} else {
			System.out.println("[测试提示]数据库连接失败！");
		}

	}

}
