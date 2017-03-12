package cn.edu.scu.tmooc.entity;

public class Choice {
	int id;
	int studentid;
	int courseid;
	public Choice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Choice(int id, int studentid, int courseid) {
		super();
		this.id = id;
		this.studentid = studentid;
		this.courseid = courseid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public int getCourseid() {
		return courseid;
	}
	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}
	

}
