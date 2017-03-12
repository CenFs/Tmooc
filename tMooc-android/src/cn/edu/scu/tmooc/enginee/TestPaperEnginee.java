package cn.edu.scu.tmooc.enginee;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import cn.edu.scu.tmooc.entity.Test;

public class TestPaperEnginee {
	//JSON数据
	public static List<Test> parseJSONWithJSONObject(String jsonData) {
		List<Test> tests=new ArrayList<Test>();
		Test test=null;
		try {
			JSONArray jsonArray = new JSONArray(jsonData);
			//遍历JSON数组
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				String question = jsonObject.getString("question");
				String option1 = jsonObject.getString("option1");
				String option2 = jsonObject.getString("option2");
				String option3 = jsonObject.getString("option3");
				String option4 = jsonObject.getString("option4");
				test=new Test();
				//为Product对象设置属性
				test.setQuestion(question);
				test.setOption1(option1);
				test.setOption2(option2);
				test.setOption3(option3);
				test.setOption4(option4);
				//将Product对象放到集合中
				tests.add(test);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tests;
	}
}
