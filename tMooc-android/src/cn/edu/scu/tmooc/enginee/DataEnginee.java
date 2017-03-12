package cn.edu.scu.tmooc.enginee;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import cn.edu.scu.tmooc.entity.Data;

public class DataEnginee {

	public static List<Data> parseJSONWithJSONObject(String jsonData) {
		List<Data> datas = new ArrayList<Data>();
		Data data = null;
		/*
		 int dataid;
        int courseid;
        String dataname;
        String datapath;
        Date date;
	 * */
	
		try {
			JSONArray jsonArray = new JSONArray(jsonData);
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				int dataid = jsonObject.getInt("dataid");
				String dataname = jsonObject.getString("dataname");
				String datapath = jsonObject.getString("datapath");
				/*String datadate = jsonObject.getString("datadate");
				JSONObject jObject = new JSONObject(datadate);
				Date d = new Date(jObject.getInt("year")-1900,jObject.getInt("month"),jObject.getInt("day"));*/
				int courseid = jsonObject.getInt("courseid");
				
				data = new Data();
				
				data.setDataid(dataid);
				data.setDataname(dataname);
				data.setCourseid(courseid);
				//data.setDatadate(d);
				data.setDatapath(datapath);
				
				datas.add(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return datas;
	}

}
