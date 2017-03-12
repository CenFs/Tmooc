package cn.edu.scu.tmooc.enginee;

import org.json.JSONArray;
import org.json.JSONObject;

public class StudentEnginee {
	//JSON数据
		public static String parseJSONWithJSONObject(String jsonData) {
			String stupwd = null;
			try {
				JSONArray jsonArray = new JSONArray(jsonData);
				//遍历JSON数组
					JSONObject jsonObject = jsonArray.getJSONObject(0);
					stupwd = jsonObject.getString("studentpwd");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return stupwd;
		}
	}
