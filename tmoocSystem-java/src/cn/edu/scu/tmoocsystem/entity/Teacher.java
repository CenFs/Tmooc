package cn.edu.scu.tmoocsystem.entity;

public class Teacher {
	int teacherid;
	String teachername;
	String teacherpwd;
	public int getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
	}
	public String getTeachername() {
		return teachername;
	}
	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}
	public String getTeacherpwd() {
		return teacherpwd;
	}
	public void setTeacherpwd(String teacherpwd) {
		this.teacherpwd = teacherpwd;
	}
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Teacher(int teacherid, String teachername, String teacherpwd) {
		super();
		this.teacherid = teacherid;
		this.teachername = teachername;
		this.teacherpwd = teacherpwd;
	}

}
