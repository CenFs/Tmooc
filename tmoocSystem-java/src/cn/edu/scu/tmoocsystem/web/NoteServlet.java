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
import cn.edu.scu.tmoocsystem.dao.NoteDao;
import cn.edu.scu.tmoocsystem.dao.impl.NoteDaoImpl;
import cn.edu.scu.tmoocsystem.entity.Note;
import cn.edu.scu.tmoocsystem.entity.Test;

/**
 * Servlet implementation class NoteServlet
 */
public class NoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/*********************/
	private NoteDao dao=new NoteDaoImpl();
/*********************/
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoteServlet() {
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
		if("findnotebystudentid".equals(method)){
			findnotebystudentid(request,response);
		}
		if("savenote".equals(method)){
			savenote(request,response);
		}
		if("getalldetail".equals(method)){
			getalldetail(request,response);
		}
		if("getmaxnoteid".equals(method)){
			getmaxnoteid(request,response);
		}
		if("deletenote".equals(method)){
			deletenote(request,response);
		}
	}
	
	private void findnotebystudentid(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		int studentid = Integer.parseInt(request.getParameter("studentid"));
		List<Note> notes = dao.findnotebystudentid(studentid);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class,new JsDateJsonValueProcessor());

		//将集合以JSON格式显示
		JSONArray jsonArray = JSONArray.fromObject(notes,jsonConfig);
		out.println(jsonArray);
		
	}
	
	private void savenote(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		int noteid = Integer.parseInt(request.getParameter("noteid"));
		int studentid = Integer.parseInt(request.getParameter("studentid"));
		String notetitle = request.getParameter("notetitle");
		String notetext = request.getParameter("notetext");
		String status = request.getParameter("status");
		List<Note> notes = dao.savenote(noteid, studentid, notetitle, notetext, status);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class,new JsDateJsonValueProcessor());

		//将集合以JSON格式显示
		JSONArray jsonArray = JSONArray.fromObject(notes,jsonConfig);
		out.println(jsonArray);
		
	}
	
	private void getalldetail(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		int noteid = Integer.parseInt(request.getParameter("noteid"));
		List<Note> notes = dao.getalldetail(noteid);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class,new JsDateJsonValueProcessor());

		//将集合以JSON格式显示
		JSONArray jsonArray = JSONArray.fromObject(notes,jsonConfig);
		out.println(jsonArray);
		
	}

	private void getmaxnoteid(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		List<Note> notes = dao.getmaxnoteid();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class,new JsDateJsonValueProcessor());

		//将集合以JSON格式显示
		JSONArray jsonArray = JSONArray.fromObject(notes,jsonConfig);
		out.println(jsonArray);
		
	}
	
	private void deletenote(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		response.setContentType("text/json;charset=utf-8");
		int noteid = Integer.parseInt(request.getParameter("noteid"));
		dao.deletenote(noteid);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
