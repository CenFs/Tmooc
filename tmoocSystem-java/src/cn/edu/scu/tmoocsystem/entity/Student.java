package cn.edu.scu.tmoocsystem.entity;

public class Student {
	int studentid;
	String studentname;
	String studentpwd;
	
	public Student(int studentid, String studentname, String studentpwd) {
		super();
		this.studentid = studentid;
		this.studentname = studentname;
		this.studentpwd = studentpwd;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public String getStudentpwd() {
		return studentpwd;
	}
	public void setStudentpwd(String studentpwd) {
		this.studentpwd = studentpwd;
	}

}
