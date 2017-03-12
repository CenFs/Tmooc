package cn.edu.scu.tmoocsystem.dao.impl;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.edu.scu.tmoocsystem.dao.TestanswerDao;
import cn.edu.scu.tmoocsystem.entity.Forum;
import cn.edu.scu.tmoocsystem.entity.Note;
import cn.edu.scu.tmoocsystem.entity.Testanswer;
import cn.edu.scu.tmoocsystem.util.C3P0Util;

public class TestanswerDaoImpl implements TestanswerDao {

	QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
	
	public List<Testanswer> findtestanswerbyanswerpaperid(int answerpaperid) {
		String sql="select * from testanswer where answerpaperid=?";
		
		Object params[]=new Object[]{answerpaperid};
		
		try{
		return qr.query(sql, new BeanListHandler<Testanswer>(Testanswer.class),params);
	}catch(SQLException e){
		e.printStackTrace();
	}
		return null;
	}

	public List<Testanswer> findtestanswerbystudentid(int studentid) {
		String sql="select * from testanswer where studentid=?";
		
		Object params[]=new Object[]{studentid};
		
		try{
		return qr.query(sql, new BeanListHandler<Testanswer>(Testanswer.class),params);
	}catch(SQLException e){
		e.printStackTrace();
	}
		return null;
	}

	public List<Testanswer> getAll() {

		String sql="select * from testanswer group by answerpaperid";
		
		try {
			return qr.query(sql, new BeanListHandler<Testanswer>(Testanswer.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public List<Testanswer> getmaxanswerpaperid() {

		String sql="select * from testanswer where answerpaperid=(select max(answerpaperid) from testanswer)";
		try {
			return qr.query(sql, new BeanListHandler<Testanswer>(Testanswer.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Testanswer> endtest(String answer, int studentid, int paperid) {
		
			String sql = "insert into testanswer (paperid,studentid,answer)values(?,?,?)";
			Object params[]=new Object[]{paperid,studentid,answer};
			try {
				qr.update(sql, params);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		String sql2 = "select * from testanswer where paperid=" + paperid +" and studentid=" + studentid;
		try {
			return qr.query(sql2, new BeanListHandler<Testanswer>(Testanswer.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
    
