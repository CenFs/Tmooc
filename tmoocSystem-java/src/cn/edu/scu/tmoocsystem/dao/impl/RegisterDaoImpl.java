package cn.edu.scu.tmoocsystem.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.edu.scu.tmoocsystem.dao.RegisterDao;
import cn.edu.scu.tmoocsystem.entity.Student;
import cn.edu.scu.tmoocsystem.util.C3P0Util;

public class RegisterDaoImpl implements RegisterDao {

	//声明并实例化QueryRunner对象
	QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
	
	public List<Student> register(int studentid, String studentname, String studentpwd) {
		String sql="insert into stuinfo (studentid,studentname,studentpwd)values(?,?,?)";
		String sql2="select * from stuinfo where studentid="+studentid;
		
		Object params[]=new Object[]{studentid,studentname,studentpwd};
		
		try {
			qr.update(sql, params);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try{
		return qr.query(sql2, new BeanListHandler<Student>(Student.class));
	}catch(SQLException e){
		e.printStackTrace();
	}
		return null;
	}

}
   