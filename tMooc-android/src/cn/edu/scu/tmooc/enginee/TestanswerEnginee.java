package cn.edu.scu.tmooc.enginee;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import cn.edu.scu.tmooc.entity.Testanswer;

public class TestanswerEnginee {
	//JSON数据
	public static List<Testanswer> parseJSONWithJSONObject(String jsonData) {
		List<Testanswer> testanswers=new ArrayList<Testanswer>();
		Testanswer testanswer=null;
		try {
			JSONArray jsonArray = new JSONArray(jsonData);
			//遍历JSON数组
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				int courseid = jsonObject.getInt("courseid");
				int answerpaperid = jsonObject.getInt("answerpaperid");
				int studentid = jsonObject.getInt("studentid");
				testanswer=new Testanswer();
				//为Product对象设置属性
				testanswer.setCourseid(courseid);
				testanswer.setAnswerpaperid(answerpaperid);
				testanswer.setStudentid(studentid);
				//将Product对象放到集合中
				testanswers.add(testanswer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return testanswers;
	}
	

}
