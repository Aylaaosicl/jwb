package com.software.jdbcutil;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * JDBC�����Ĺ�����
 * @author liqkjm
 *
 */
public class JDBCUtils {
	
	
	/** JDBC2.0 �ṩ��javax.sql.DataSource�ӿڣ��������������ݿ�����ӣ�����Ӧ�ó����з������ݿ�ʱ 
		���ر�д�������ݿ�Ĵ��룬ֱ������DataSource��ȡ���ݿ�����Ӷ��󼴿ɡ����ڻ�ȡ��������Connection����
	 */
	private static DataSource dataSource = null;
	
	static{
		//����Դֻ�ܱ�����һ��
		/**
		 * 1. ����˼�룺����Ϊ���ݿ⽨��һ��������ء���Ԥ���ڻ�����з���һ�����������ӣ�����Ҫ�������ݿ�����ʱ��
		 * ֻ��Ҫ�ӡ�����ء���ȡ��һ����ʹ������ٷŻ�ȥ���������ظ����������ĵ�ʱ������Դ��
	����	 * 2. ְ�����ݿ����ӳظ�����䣬�������ͷ����ݿ����ӣ�������Ӧ�ó����ظ�ʹ��һ�����е����ݿ����ӣ��������½���һ����
	����        * 3. JDBC�����ݿ����ӳ�ʹ��javax.sql.DataSource ����ʾ��DataSource ֻ��һ���ӿڣ�
		 * �ýӿ�ͨ���ɷ�������Webblogic��Tomact���ṩʵ�֣�Ҳ��һЩ��Դ��֯�ṩʵ�֣�DBCP��C3P0��
		 */
		dataSource = new ComboPooledDataSource("hua.project"); // ���ء�c3p0-config.xml���ļ��ж���ġ�hua.project���������Ԫ��
	}
	
	/**
	 * 
	 * @return ����Դ��һ��Connection����
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
	
	/**
	 * �ر�Connection����
	 * @param conn
	 */
	public static void closeConnection(Connection conn){
		if(conn != null){
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
