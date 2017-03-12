package cn.edu.scu.tmoocsystem.entity;

/**
 * 答卷 （课程ID 试卷ID 学生ID 分数 答案1 答案2 答案3 答案4 老师ID）
Testanswer （int courseid int paperid  int studentid float score 
char answer1 char answer2 char answer3 char answer4 Int teacherid）
 * @author DELL
 *
 */
public class Testanswer {
	
	//设定成员变量
	int courseid;
	int paperid; 
	int answerpaperid;
	int studentid; 
	int score; 
	String answer; 
	int teacherid;
	
	//设定构造函数
	public Testanswer() {
		super();
	}

	public Testanswer(int courseid,int paperid,int answerpaperid,int studentid,
			int score,String answer,int teacherid) {
		super();
		this.courseid=courseid;
		this.paperid=paperid;
		this.answerpaperid=answerpaperid;
        this.studentid=studentid;
        this.score=score;
        this.answer=answer;
        this.teacherid=teacherid;
	}

	//设定getting/setting方法
	public int getCourseid() {
		return courseid;
	}

	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}

	public int getPaperid() {
		return paperid;
	}

	public void setPaperid(int paperid) {
		this.paperid = paperid;
	}

	public int getStudentid() {
		return studentid;
	}

	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}


	public int getTeacherid() {
		return teacherid;
	}

	public void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
	}

	public int getAnswerpaperid() {
		return answerpaperid;
	}

	public void setAnswerpaperid(int answerpaperid) {
		this.answerpaperid = answerpaperid;
	}
	
}
