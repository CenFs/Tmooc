package cn.edu.scu.tmoocsystem.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsDateJsonValueProcessor;
import cn.edu.scu.tmoocsystem.dao.TestanswerDao;
import cn.edu.scu.tmoocsystem.dao.impl.TestanswerDaoImpl;
import cn.edu.scu.tmoocsystem.entity.Note;
import cn.edu.scu.tmoocsystem.entity.Testanswer;

public class TestanswerServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private TestanswerDao dao=new TestanswerDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestanswerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String method=request.getParameter("method");
		if("answerdetail".equals(method)){
			answerdetail(request,response);
		}
		if("findtestanswerbystudentid".equals(method)){
			findtestanswerbystudentid(request,response);
		}
		if("getall".equals(method)){
			getall(request,response);
		}
		if("getmaxanswerpaperid".equals(method)){
			getmaxanswerpaperid(request,response);
		}
		if("endtest".equals(method)){
			endtest(request,response);
		}
	}
	
	private void answerdetail(HttpServletRequest request, HttpServletResponse response) throws IOException {
			response.setContentType("text/json;charset=utf-8");
			PrintWriter out=response.getWriter();
			int answerpaperid=Integer.parseInt(request.getParameter("comeanswerpaperid"));
			List<Testanswer> testanswers=dao.findtestanswerbyanswerpaperid(answerpaperid);
			JSONArray jsonArray=JSONArray.fromObject(testanswers);
			out.println(jsonArray);
		}
	
	private void endtest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out=response.getWriter();
		int paperid = Integer.parseInt(request.getParameter("paperid"));
		int studentid = Integer.parseInt(request.getParameter("studentid"));
		String answer = request.getParameter("answer");
		List<Testanswer> testanswers = dao.endtest(answer,studentid,paperid);
		JSONArray jsonArray=JSONArray.fromObject(testanswers);
		out.println(jsonArray);
	}
	
	
	private void findtestanswerbystudentid(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out=response.getWriter();
		int studentid = Integer.parseInt(request.getParameter("studentid"));
		List<Testanswer> testanswers = dao.findtestanswerbystudentid(studentid);
		JSONArray jsonArray=JSONArray.fromObject(testanswers);
		out.println(jsonArray);
	}
	
	private void getall(HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out=response.getWriter();
		List<Testanswer> testanswers=dao.getAll();
		JSONArray jsonArray=JSONArray.fromObject(testanswers);
		out.println(jsonArray);
	}

	private void getmaxanswerpaperid(HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		List<Testanswer> testanswers = dao.getmaxanswerpaperid();
		JSONArray jsonArray = JSONArray.fromObject(testanswers);
		out.println(jsonArray);
	}
	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}


