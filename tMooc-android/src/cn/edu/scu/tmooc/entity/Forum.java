package cn.edu.scu.tmooc.entity;


import java.util.Date;
/**
 * ѧϰ��̳ʵ����
 * @author lenovo
 *
 */

public class Forum {
	// 1.�����Ա����
  private String forumname;
  private int studentid;
  private String foruminformation;
  private Date forumdate;
  private int forummainid;
  private int forumtype;
  private int forumid;
  
	// 2.���幹�캯��
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
	// 3.����setter/getter����

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
