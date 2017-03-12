package cn.edu.scu.tmoocsystem.entity;
/**
 * Test的实体类
 * @author DELL
 *
 */
public class Test {
	//设定成员变量
	int paperid;
	String papername;
	int questionid;
	//questiontype 1.选择 2.多选 3。简答
	int questiontype;
	String question;
	String option1;
	String option2;
	String option3;
	String option4;
	int studentid;
	
	//设定构造函数
	public Test() {
		super();
	}

	public Test(int paperid,String papername,int questionid, int questiontype,String question,
			String option1, String option2, String option3, String option4, int studentid) {
		super();
		this.paperid=paperid;
		this.papername=papername;
		this.questionid=questionid;
		this.questiontype=questiontype;
		this.question=question;
		this.option1=option1;
		this.option2=option2;
		this.option3=option3;
		this.option4=option4;
		this.studentid=studentid;
		
	}
	
	//设定getting/setting方法

	public int getPaperid() {
		return paperid;
	}

	public void setPaperid(int paperid) {
		this.paperid = paperid;
	}

	public int getQuestionid() {
		return questionid;
	}

	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}

	public int getQuestiontype() {
		return questiontype;
	}

	public void setQuestiontype(int questiontype) {
		this.questiontype = questiontype;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getPapername() {
		return papername;
	}

	public void setPapername(String papername) {
		this.papername = papername;
	}
	
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	
	public int getStudentid() {
		return studentid;
	}
	
	public String toString() {
		return "Test [paperid=" + paperid + ", papername=" + papername
				+ ", questionid=" + questionid + ", questiontype="
				+ questiontype + ", question=" + question + ", option1="
				+ option1 + ", option2=" + option2 + ", option3=" + option3
				+ ", option4=" + option4 + "]";
	}
	

}