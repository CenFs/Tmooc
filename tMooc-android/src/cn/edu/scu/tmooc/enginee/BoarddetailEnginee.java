package cn.edu.scu.tmooc.enginee;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import cn.edu.scu.tmooc.util.DateUtil;

import cn.edu.scu.tmooc.entity.Board;

public class BoarddetailEnginee {
	
	//public static DateUtil dateutil=new DateUtil();
	
	//JSON����
	public static List<Board> parseJSONWithJSONObject(String jsonData) {
		List<Board> boards=new ArrayList<Board>();
		Board board=null;
		
		
		try {
			JSONArray jsonArray = new JSONArray(jsonData);
			//����JSON����
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				int boardid = jsonObject.getInt("boardid");
				String title = jsonObject.getString("title");
				String text = jsonObject.getString("text");
				String date=jsonObject.getString("date");
				JSONObject jObject=new JSONObject(date);
				Date d=new Date(jObject.getInt("year")-1900,jObject.getInt("month"),jObject.getInt("day"));
				board=new Board();
				//ΪProduct������������
				board.setBoardid(boardid);
				board.setTitle(title);
				board.setText(text);
				board.setDate(d);
				//��Product����ŵ�������
				boards.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return boards;
	}

}
