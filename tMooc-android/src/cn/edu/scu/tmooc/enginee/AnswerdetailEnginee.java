package cn.edu.scu.tmooc.enginee;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import cn.edu.scu.tmooc.util.DateUtil;
import cn.edu.scu.tmooc.entity.Board;
import cn.edu.scu.tmooc.entity.Testanswer;

public class AnswerdetailEnginee {
	
	//public static DateUtil dateutil=new DateUtil();
	
	//JSONÊý¾Ý
	public static List<Testanswer> parseJSONWithJSONObject(String jsonData) {
		List<Testanswer> testanswers=new ArrayList<Testanswer>();
		Testanswer testanswer=null;
		
		/**
		 * 
int courseid;
	int paperid; 
	int answerpaperid;
	int studentid; 
	float score; 
	String answer; 
	int teacherid;

		 */
		try {
			JSONArray jsonArray = new JSONArray(jsonData);

			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				int courseid = jsonObject.getInt("courseid");
				int paperid = jsonObject.getInt("paperid");
				int answerpaperid = jsonObject.getInt("answerpaperid");
				int studentid = jsonObject.getInt("studentid");
				String answer = jsonObject.getString("answer");
				int teacherid = jsonObject.getInt("teacherid");
				int score = jsonObject.getInt("score");
				testanswer = new Testanswer();

				testanswer.setCourseid(courseid);
				testanswer.setPaperid(paperid);
				testanswer.setStudentid(studentid);
				testanswer.setScore(score);
				testanswer.setAnswer(answer);
				testanswer.setTeacherid(teacherid);
				testanswer.setAnswerpaperid(answerpaperid);

				testanswers.add(testanswer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return testanswers;
	}

}
