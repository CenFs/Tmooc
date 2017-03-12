package cn.edu.scu.tmoocsystem.dao;

import java.util.List;

import cn.edu.scu.tmoocsystem.entity.Forum;

public interface ForumDao {
	
	public List<Forum> getAll();  //返回所有信息
	public List<Forum> sendthisforum(int forumid, int studentid, String forumname, String foruminformation);
	public List<Forum> getmaxforumid();
}
