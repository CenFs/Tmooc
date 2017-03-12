package cn.edu.scu.tmoocsystem.dao.impl;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.edu.scu.tmoocsystem.dao.NoteDao;
import cn.edu.scu.tmoocsystem.entity.Note;
import cn.edu.scu.tmoocsystem.util.C3P0Util;

public class NoteDaoImpl implements NoteDao {

	//声明并实例化QueryRunner对象
	QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
	
	public List<Note> findnotebystudentid(int studentid) {
		String sql="select * from note where studentid=?";
		Object params[]=new Object[]{studentid};
		try {
			return qr.query(sql, new BeanListHandler<Note>(Note.class),params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Note> getmaxnoteid() {

		String sql="select * from note where id=(select max(id) from note)";
		try {
			return qr.query(sql, new BeanListHandler<Note>(Note.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Note> getalldetail(int noteid) {

		String sql="select * from note where noteid=?";
		Object params[]=new Object[]{noteid};
		try {
			return qr.query(sql, new BeanListHandler<Note>(Note.class),params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public List<Note> savenote(int noteid, int studentid, String notetitle, String notetext, String status) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date time = null;
		try {
		   time = sdf.parse(sdf.format(new Date()));
		} catch (ParseException e) {
		   e.printStackTrace();
		}
		
		if(status.equals("add")){
			String sql = "insert into note (noteid,studentid,notetitle,notetext,notedate)values(?,?,?,?,?)";
			Object params[]=new Object[]{noteid,studentid,notetitle,notetext,time};
			try {
				qr.update(sql, params);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		else if(status.equals("update")){
			String sql = "update note set studentid=?, notetitle=?, notetext=?, notedate=? where noteid=?";
			Object params[]=new Object[]{studentid,notetitle,notetext,time,noteid};
			try {
				qr.update(sql, params);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		String sql = "select * from note where noteid=" + noteid;
		try {
			return qr.query(sql, new BeanListHandler<Note>(Note.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void deletenote(int noteid) {

		String sql="delete from note where noteid=?";
		Object params[]=new Object[]{noteid};
		try {
			qr.update(sql, params);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
}
    