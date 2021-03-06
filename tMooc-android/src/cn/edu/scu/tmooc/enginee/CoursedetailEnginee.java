package cn.edu.scu.tmooc.enginee;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import cn.edu.scu.tmooc.entity.Board;
import cn.edu.scu.tmooc.entity.Course;

public class CoursedetailEnginee {

	//public static DateUtil dateutil=new DateUtil();
	
		//JSON数据
		public static List<Course> parseJSONWithJSONObject(String jsonData) {
			List<Course> courses=new ArrayList<Course>();
			Course course=null;
			
			
			try {
				JSONArray jsonArray = new JSONArray(jsonData);
				//遍历JSON数组
				for (int i = 0; i < jsonArray.length(); i++) {
					JSONObject jsonObject = jsonArray.getJSONObject(i);
					int courseid = jsonObject.getInt("courseid");
					String coursename = jsonObject.getString("coursename");
					int teacherid = jsonObject.getInt("teacherid");
					String teachername = jsonObject.getString("teachername");
					int coursetype = jsonObject.getInt("coursetype");
					int studentnum = jsonObject.getInt("studentnum");
					
					

					course=new Course();
					//为Product对象设置属性
					course.setCourseid(courseid);
					course.setCoursename(coursename);
					course.setTeacherid(teacherid);
					course.setTeachername(teachername);
					course.setCoursetype(coursetype);
					course.setStudentnum(studentnum);
					//将Product对象放到集合中
					courses.add(course);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return courses;
		}

	}
