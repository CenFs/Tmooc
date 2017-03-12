package cn.edu.scu.tmooc.entity;


import java.util.Date;
/**
 * 学习论坛实体类
 * @author lenovo
 *
 */

public class Forum {
	// 1.定义成员变量
  private String forumname;
  private int studentid;
  private String foruminformation;
  private Date forumdate;
  private int forummainid;
  private int forumtype;
  private int forumid;
  
	// 2.定义构造函数
	public Forum() {
		super();
	}

	public Forum(String forumname,int studentid,String foruminformation, 
			Date forumdate,int forummainid,int forumtype,int forumid) {
		super();
		
		this.forumname = forumname;
		this.studentid = studentid;
		this.foruminformation = foruminformation;
		this.forumdate = forumdate;
		this.forummainid = forummainid;
		this.forumtype = forumtype;
		this.forumid = forumid;
	}
	// 3.定义setter/getter方法

	public String getForumname() {
		return forumname;
	}

	public void setForumname(String forumname) {
		this.forumname = forumname;
	}

	public int getStudentid() {
		return studentid;
	}

	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}

	public String getForuminformation() {
		return foruminformation;
	}

	public void setForuminformation(String foruminformation) {
		this.foruminformation = foruminformation;
	}

	public Date getForumdate() {
		return forumdate;
	}

	public void setForumdate(Date forumdate) {
		this.forumdate = forumdate;
	}

	public int getForummainid() {
		return forummainid;
	}

	public void setForummainid(int forummainid) {
		this.forummainid = forummainid;
	}

	public int getForumtype() {
		return forumtype;
	}

	public void setForumtype(int forumtype) {
		this.forumtype = forumtype;
	}

	public int getForumid() {
		return forumid;
	}

	public void setForumid(int forumid) {
		this.forumid = forumid;
	}

  
}
