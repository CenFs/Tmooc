package cn.edu.scu.tmoocsystem.util;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Util {
     //�������ݿ����ӳض���
	private static DataSource dataSource=new ComboPooledDataSource();
	/**
	 * 
	 * @return �������ӳض���
	 */
	public static DataSource getDataSource(){
		return dataSource;
	}
	
}
