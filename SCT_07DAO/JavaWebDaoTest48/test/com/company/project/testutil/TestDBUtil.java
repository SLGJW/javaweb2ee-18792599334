/**
 * ���⣺���ݿ����ӵ�Ԫ����
 * ���ߣ���־��
 * ʱ�䣺2016��8��29��
 * ������
 * 		
 * 		��ʾ�û�����������쳣��
 * ע�⣺
 * 		
 */

package com.company.project.testutil;

import java.sql.Connection;
import com.company.project.util.DBUtil;
import junit.framework.TestCase;

//�ࣺ���ݿ���ԡ�
public class TestDBUtil extends TestCase {

	// �������������ݿ�����
	public void testGetConnection() {

		Connection conn = DBUtil.getConnection();

		if (conn != null) {
			System.out.println("[������ʾ]���ݿ����ӳɹ���");
		} else {
			System.out.println("[������ʾ]���ݿ�����ʧ�ܣ�");
		}

	}

}
