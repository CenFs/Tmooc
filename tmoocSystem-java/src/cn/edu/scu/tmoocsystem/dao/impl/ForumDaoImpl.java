package cn.edu.scu.tmoocsystem.dao.impl;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.edu.scu.tmoocsystem.dao.ForumDao;
import cn.edu.scu.tmoocsystem.entity.Forum;
import cn.edu.scu.tmoocsystem.entity.Note;
import cn.edu.scu.tmoocsystem.util.C3P0Util;

public class ForumDaoImpl implements ForumDao {

	//声明并实例化QueryRunner对象
	QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
	
	public List<Forum> getAll() {
		String sql="select * from forum order by id desc";
		try {
			return qr.query(sql, new BeanListHandler<Forum>(Forum.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Forum> getmaxforumid() {

		String sql="select * from forum where id=(select max(id) from forum)";
		try {
			return qr.query(sql, new BeanListHandler<Forum>(Forum.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Forum> sendthisforum(int forumid, int studentid, String forumname, String foruminformation) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date time = null;
		try {
		   time = sdf.parse(sdf.format(new Date()));
		} catch (ParseException e) {
		   e.printStackTrace();
		}

			String sql = "insert into forum (forumid,studentid,forumname,foruminformation,forumdate)values(?,?,?,?,?)";
			Object params[]=new Object[]{forumid,studentid,forumname,foruminformation,time};
			try {
				qr.update(sql, params);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		String sql2 = "select * from forum where forumid=" + forumid;
		try {
			return qr.query(sql2, new BeanListHandler<Forum>(Forum.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
}
    