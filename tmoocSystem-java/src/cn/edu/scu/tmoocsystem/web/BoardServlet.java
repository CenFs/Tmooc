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
import cn.edu.scu.tmoocsystem.dao.BoardDao;
import cn.edu.scu.tmoocsystem.dao.impl.BoardDaoImpl;
import cn.edu.scu.tmoocsystem.entity.Board;
import cn.edu.scu.tmoocsystem.entity.Test;

/**
 * Servlet implementation class BoardServlet
 */
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardDao dao=new BoardDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardServlet() {
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
		if("button1".equals(method)){
			button1(request,response);
		}
		if("getall".equals(method)){
			getall(request,response);
		}
	}
private void button1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setContentType("text/json;charset=utf-8");
//		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		// ��ȡ�û�����Ķ���
		int boardid=Integer.parseInt(request.getParameter("comeboardid"));
		List<Board> boards=dao.findboardbyboardid(boardid);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class,new JsDateJsonValueProcessor());

//		//��������JSON��ʽ��ʾ
		JSONArray jsonArray=JSONArray.fromObject(boards,jsonConfig);
		out.println(jsonArray);

		
	}
	private void getall(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out=response.getWriter();
		List<Board> boards=dao.getAll();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class,new JsDateJsonValueProcessor());

		//��������JSON��ʽ��ʾ
		JSONArray jsonArray=JSONArray.fromObject(boards,jsonConfig);
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
