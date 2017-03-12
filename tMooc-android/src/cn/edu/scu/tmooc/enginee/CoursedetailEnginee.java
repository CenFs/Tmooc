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
	
		//JSON����
		public static List<Course> parseJSONWithJSONObject(String jsonData) {
			List<Course> courses=new ArrayList<Course>();
			Course course=null;
			
			
			try {
				JSONArray jsonArray = new JSONArray(jsonData);
				//����JSON����
				for (int i = 0; i < jsonArray.length(); i++) {
					JSONObject jsonObject = jsonArray.getJSONObject(i);
					int courseid = jsonObject.getInt("courseid");
					String coursename = jsonObject.getString("coursename");
					int teacherid = jsonObject.getInt("teacherid");
					String teachername = jsonObject.getString("teachername");
					int coursetype = jsonObject.getInt("coursetype");
					int studentnum = jsonObject.getInt("studentnum");
					
					

					course=new Course();
					//ΪProduct������������
					course.setCourseid(courseid);
					course.setCoursename(coursename);
					course.setTeacherid(teacherid);
					course.setTeachername(teachername);
					course.setCoursetype(coursetype);
					course.setStudentnum(studentnum);
					//��Product����ŵ�������
					courses.add(course);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return courses;
		}

	}
