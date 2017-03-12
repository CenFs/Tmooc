package cn.edu.scu.tmooc.enginee;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import cn.edu.scu.tmooc.entity.Testanswer;

public class TestanswerEnginee {
	//JSON����
	public static List<Testanswer> parseJSONWithJSONObject(String jsonData) {
		List<Testanswer> testanswers=new ArrayList<Testanswer>();
		Testanswer testanswer=null;
		try {
			JSONArray jsonArray = new JSONArray(jsonData);
			//����JSON����
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				int courseid = jsonObject.getInt("courseid");
				int answerpaperid = jsonObject.getInt("answerpaperid");
				int studentid = jsonObject.getInt("studentid");
				testanswer=new Testanswer();
				//ΪProduct������������
				testanswer.setCourseid(courseid);
				testanswer.setAnswerpaperid(answerpaperid);
				testanswer.setStudentid(studentid);
				//��Product����ŵ�������
				testanswers.add(testanswer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return testanswers;
	}
	

}
