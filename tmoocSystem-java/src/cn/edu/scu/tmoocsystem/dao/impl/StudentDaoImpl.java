package cn.edu.scu.tmoocsystem.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.edu.scu.tmoocsystem.dao.StudentDao;
import cn.edu.scu.tmoocsystem.entity.Student;
import cn.edu.scu.tmoocsystem.util.C3P0Util;

public class StudentDaoImpl implements StudentDao {

	//声明并实例化QueryRunner对象
	QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
	
	public List<Student> findstudentbystudentid(int studentid) {
		String sql="select studentpwd from stuinfo where studentid=?";
		
		Object params[]=new Object[]{studentid};
		
		try{
		return qr.query(sql, new BeanListHandler<Student>(Student.class),params);
	}catch(SQLException e){
		e.printStackTrace();
	}
		return null;
	}
/*
	public List<Student> getAll() {

		String sql="select * from stuinfo where studentid=";
		
		try {
			return qr.query(sql, new BeanListHandler<Test>(Test.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
*/

}
   