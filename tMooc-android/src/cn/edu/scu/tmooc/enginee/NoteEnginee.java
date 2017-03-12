package cn.edu.scu.tmooc.enginee;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import cn.edu.scu.tmooc.entity.Note;

public class NoteEnginee {
	
	//JSON数据
	public static List<Note> parseJSONWithJSONObject(String jsonData) {
		List<Note> notes = new ArrayList<Note>();
		Note note = null;
		/*
			int noteid;
			int studentid;
			String notetitle;
			String notetext;
			Date notedate;
		 * 
		 * */
		
		try {
			JSONArray jsonArray = new JSONArray(jsonData);
			//遍历JSON数组
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				int noteid = jsonObject.getInt("noteid");
				String notetitle = jsonObject.getString("notetitle");
				String notetext = jsonObject.getString("notetext");
				String notedate=jsonObject.getString("notedate");
				JSONObject jObject=new JSONObject(notedate);
				Date d = new Date(jObject.getInt("year")-1900,jObject.getInt("month"),jObject.getInt("day"));
				int studentid = jsonObject.getInt("studentid");
				
				note = new Note();
				//为Product对象设置属性
				note.setNoteid(noteid);
				note.setNotetitle(notetitle);
				note.setNotetext(notetext);
				note.setNotedate(d);
				note.setStudentid(studentid);
				
				
				//将Product对象放到集合中
				notes.add(note);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return notes;
	}

}
