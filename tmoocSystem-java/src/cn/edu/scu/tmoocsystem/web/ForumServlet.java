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
import cn.edu.scu.tmoocsystem.dao.ForumDao;
import cn.edu.scu.tmoocsystem.dao.impl.ForumDaoImpl;
import cn.edu.scu.tmoocsystem.entity.Forum;
import cn.edu.scu.tmoocsystem.entity.Note;

/**
 * Servlet implementation class ForumServlet
 */
public class ForumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ForumDao dao=new ForumDaoImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForumServlet() {
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
		if("getall".equals(method)){
			getall(request,response);
		}
		if("sendthisforum".equals(method)){
			sendthisforum(request,response);
		}
		if("getmaxforumid".equals(method)){
			getmaxforumid(request,response);
		}
	}
	
	private void getall(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out=response.getWriter();
		List<Forum> forums=dao.getAll();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class,new JsDateJsonValueProcessor());

		//将集合以JSON格式显示
		JSONArray jsonArray=JSONArray.fromObject(forums,jsonConfig);
		out.println(jsonArray);
		
	}
	
	private void sendthisforum(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		int forumid = Integer.parseInt(request.getParameter("forumid"));
		int studentid = Integer.parseInt(request.getParameter("studentid"));
		String forumname = request.getParameter("forumname");
		String foruminformation = request.getParameter("foruminformation");
		List<Forum> forums = dao.sendthisforum(forumid, studentid, forumname, foruminformation);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class,new JsDateJsonValueProcessor());

		//将集合以JSON格式显示
		JSONArray jsonArray = JSONArray.fromObject(forums,jsonConfig);
		out.println(jsonArray);
		
	}
	
	private void getmaxforumid(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		List<Forum> forums = dao.getmaxforumid();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class,new JsDateJsonValueProcessor());

		//将集合以JSON格式显示
		JSONArray jsonArray = JSONArray.fromObject(forums,jsonConfig);
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
