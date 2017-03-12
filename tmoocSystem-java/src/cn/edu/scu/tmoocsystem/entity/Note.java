package cn.edu.scu.tmoocsystem.entity;

import java.util.Date;

public class Note {
	int noteid;
	int studentid;
	String notetitle;
	String notetext;
	Date notedate;

	public Note() {
		super();
	}

	public Note(int noteid, int studentid, String notetitle, String notetext,
			Date notedate) {
		super();
		this.noteid = noteid;
		this.studentid = studentid;
		this.notetitle = notetitle;
		this.notetext = notetext;
		this.notedate = notedate;
	}

	public int getNoteid() {
		return noteid;
	}

	public void setNoteid(int noteid) {
		this.noteid = noteid;
	}

	public int getStudentid() {
		return studentid;
	}

	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}

	public String getNotetitle() {
		return notetitle;
	}

	public void setNotetitle(String notetitle) {
		this.notetitle = notetitle;
	}

	public String getNotetext() {
		return notetext;
	}

	public void setNotetext(String notetext) {
		this.notetext = notetext;
	}

	public Date getNotedate() {
		return notedate;
	}

	public void setNotedate(Date notedate) {
		this.notedate = notedate;
	}
}