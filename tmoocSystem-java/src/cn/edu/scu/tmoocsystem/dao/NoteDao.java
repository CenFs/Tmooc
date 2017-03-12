package cn.edu.scu.tmoocsystem.dao;

import java.util.List;

import cn.edu.scu.tmoocsystem.entity.Note;
import cn.edu.scu.tmoocsystem.entity.Test;

public interface NoteDao {
	
	public List<Note> savenote(int noteid, int studentid, String notetitle, String notetext, String status);  //返回所有信息
	public List<Note> findnotebystudentid(int studentid);
	public List<Note> getalldetail(int noteid);
	public List<Note> getmaxnoteid();
	public void deletenote(int noteid);
}
