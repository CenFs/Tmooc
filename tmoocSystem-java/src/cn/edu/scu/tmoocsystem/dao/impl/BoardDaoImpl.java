package cn.edu.scu.tmoocsystem.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.edu.scu.tmoocsystem.dao.BoardDao;
import cn.edu.scu.tmoocsystem.entity.Board;
import cn.edu.scu.tmoocsystem.util.C3P0Util;
/**
 * TestDao��ʵ����
 * @author DELL
 *
 */
public class BoardDaoImpl implements BoardDao {

	//������ʵ��QueryRunner����
	QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
	
	public List<Board> findboardbyboardid(int boardid) {
		String sql="select * from board where boardid=?";
		
		Object params[]=new Object[]{boardid};
		
		try{
		return qr.query(sql, new BeanListHandler<Board>(Board.class),params);
	}catch(SQLException e){
		e.printStackTrace();
	}
		return null;
	}

	public List<Board> getAll() {

		String sql="select * from board group by boardid";
		
		try {
			return qr.query(sql, new BeanListHandler<Board>(Board.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
    
