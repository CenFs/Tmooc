package cn.edu.scu.tmoocsystem.entity;

public class courseinfo {
	private int courseid;
	private String coursename;
	private String teachername;
	private int teacherid;
	private int coursetype;
	private int studentnum;
	@Override
	public String toString() {
		return "Test [courseid=" + courseid + ", coursename=" + coursename
				+ ", teachername=" + teachername + ", teacherid="
				+ teacherid + ", coursetype=" + coursetype 
				+ ", studentnum=" + studentnum + "]";
	}
	public int getCourseid() {
		return courseid;
	}
	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public String getTeachername() {
		return teachername;
	}
	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}
	
	public int getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
	}
	public int getCoursetype() {
		return coursetype;
	}
	public void setCoursetype(int coursetype) {
		this.coursetype = coursetype;
	}
	public int getStudentnum() {
		return studentnum;
	}
	public void setStudentnum(int studentnum) {
		this.studentnum = studentnum;
	}
}
