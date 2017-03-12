package cn.edu.scu.tmoocsystem.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.edu.scu.tmoocsystem.dao.TestDao;
import cn.edu.scu.tmoocsystem.entity.Test;
import cn.edu.scu.tmoocsystem.util.C3P0Util;

public class TestDaoImpl implements TestDao {

	QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
	
	public List<Test> findtestbypaperid(int paperid) {
		String sql="select * from test where paperid=?";
		Object params[]=new Object[]{paperid};
		try{
			return qr.query(sql, new BeanListHandler<Test>(Test.class),params);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	public List<Test> getAll(int studentid) {
		String sql="select * from test where studentid=" + studentid + " group by paperid";
		try {
			return qr.query(sql, new BeanListHandler<Test>(Test.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
    
