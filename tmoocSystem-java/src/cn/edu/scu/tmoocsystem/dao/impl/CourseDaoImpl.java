package cn.edu.scu.tmoocsystem.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.edu.scu.tmoocsystem.dao.CourseDao;
import cn.edu.scu.tmoocsystem.entity.Board;
import cn.edu.scu.tmoocsystem.entity.Course;
import cn.edu.scu.tmoocsystem.util.C3P0Util;

public class CourseDaoImpl implements CourseDao {

	//������ʵ��QueryRunner����
	QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
	
	public List<Course> findcourseinfobycourseid(int courseid) {
		String sql="select * from courseinfo where courseid=?";
		
		Object params[]=new Object[]{courseid};
		
		try{
		return qr.query(sql, new BeanListHandler<Course>(Course.class),params);
	}catch(SQLException e){
		e.printStackTrace();
	}
		return null;
	}

	
	public List<Course> getAll() {

		String sql="select * from courseinfo group by courseid";
		
		try {
			return qr.query(sql, new BeanListHandler<Course>(Course.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}