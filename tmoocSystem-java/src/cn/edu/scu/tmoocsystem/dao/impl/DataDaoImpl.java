package cn.edu.scu.tmoocsystem.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.edu.scu.tmoocsystem.dao.DataDao;
import cn.edu.scu.tmoocsystem.entity.Data;
import cn.edu.scu.tmoocsystem.util.C3P0Util;

public class DataDaoImpl implements DataDao {

	//声明并实例化QueryRunner对象
	QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
	
	public List<Data> finddatapathbydataid(int dataid) {
		String sql="select * from data where dataid=?";
		
		Object params[]=new Object[]{dataid};
		
		try{
		return qr.query(sql, new BeanListHandler<Data>(Data.class),params);
	}catch(SQLException e){
		e.printStackTrace();
	}
		return null;
	}

	public List<Data> getAll(int courseid) {

		String sql="select * from data where courseid="+courseid;
		
		try {
			return qr.query(sql, new BeanListHandler<Data>(Data.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Data> getdatalistbycourseid(int courseid) {

		String sql="select * from data where courseid=?";
		Object params[]=new Object[]{courseid};
		try {
			return qr.query(sql, new BeanListHandler<Data>(Data.class),params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
    
