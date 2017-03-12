package cn.edu.scu.tmoocsystem.entity;

public class Choice {
	int id;
	int studentid;
	int course;	
	
	public Choice() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Choice(int id, int studentid, int course) {
		super();
		this.id = id;
		this.studentid = studentid;
		this.course = course;
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



	public int getCourse() {
		return course;
	}



	public void setCourse(int course) {
		this.course = course;
	}
	
	

}
