package cn.edu.scu.tmoocsystem.entity;

/**
 * 在线课程实体类
 * @author lenovo
 *
 */

public class Course {
	// 1.定义成员变量
	private int courseid;
	private String coursename;
	private String teachername;
	private int teacherid;
	private int coursetype;
	private int studentnum;
	
	public Course() {
		super();
	}

	public Course(int courseid,String coursename,String teachername,
			      int teacherid,int coursetype,int studentnum) {
		super();
		this.courseid = courseid;
		this.coursename = coursename;
		this.teachername = teachername;
		this.teacherid = teacherid;
		this.coursetype = coursetype;
		this.studentnum = studentnum;
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
