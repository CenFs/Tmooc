package cn.edu.scu.tmooc.enginee;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import cn.edu.scu.tmooc.entity.Forum;

public class ForumEnginee {
	
	//JSON数据
	public static List<Forum> parseJSONWithJSONObject(String jsonData) {
		List<Forum> forums = new ArrayList<Forum>();
		Forum forum=null;
		/*
		 * 	private String forumname;
			private int studentid;
			private String foruminformation;
			private Date forumdate;
			private int forummainid;
			private int forumtype;
			private int forumid;
		 * 
		 * */
		
		try {
			JSONArray jsonArray = new JSONArray(jsonData);
			//遍历JSON数组
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				int forumid = jsonObject.getInt("forumid");
				String forumname = jsonObject.getString("forumname");
				String foruminformation = jsonObject.getString("foruminformation");
				String forumdate=jsonObject.getString("forumdate");
				JSONObject jObject=new JSONObject(forumdate);
				Date d=new Date(jObject.getInt("year")-1900,jObject.getInt("month"),jObject.getInt("day"));
				int studentid = jsonObject.getInt("studentid");
				//int forummainid = jsonObject.getInt("forummainid");
				//int forumtype = jsonObject.getInt("forumtype");
				
				forum=new Forum();
				//为Product对象设置属性
				forum.setForumname(forumname);
				forum.setStudentid(studentid);
				forum.setForuminformation(foruminformation);
				forum.setForumdate(d);
				//forum.setForummainid(forummainid);
				//forum.setForumtype(forumtype);
				forum.setForumid(forumid);
				
				
				//将Product对象放到集合中
				forums.add(forum);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return forums;
	}

}
