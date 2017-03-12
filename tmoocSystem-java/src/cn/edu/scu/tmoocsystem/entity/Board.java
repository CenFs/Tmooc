package cn.edu.scu.tmoocsystem.entity;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ����֪ͨʵ����
 * @author kirrysky17
 *
 */
public class Board {

	// 1.�����Ա����
  private int boardid;
  private String title;
  private String text;
  private Date date;
	// 2.���幹�캯��
	public Board() {
		super();
	}

	public Board(int boardid,String title,String text, Date date) {
		super();
		
		this.boardid = boardid;
		this.title = title;
		this.text = text;
		this.date = date;
		
	}
	// 3.����setter/getter����

	public int getBoardid() {
		return boardid;
	}

	public void setBoardid(int boardid) {
		this.boardid = boardid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
  
}
