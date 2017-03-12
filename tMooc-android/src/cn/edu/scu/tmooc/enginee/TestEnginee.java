package cn.edu.scu.tmooc.enginee;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import cn.edu.scu.tmooc.entity.Test;

public class TestEnginee {
	//JSON数据
	public static List<Test> parseJSONWithJSONObject(String jsonData) {
		List<Test> tests = new ArrayList<Test>();
		Test test = null;
		try {
			JSONArray jsonArray = new JSONArray(jsonData);
			//遍历JSON数组
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				int paperid = jsonObject.getInt("paperid");
				int studentid = jsonObject.getInt("studentid");
				String papername = jsonObject.getString("papername");
				
				test=new Test();
				//为Product对象设置属性
				test.setPaperid(paperid);
				test.setStudentid(studentid);
				test.setPapername(papername);
				
				//将Product对象放到集合中
				tests.add(test);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tests;
	}
	

}
