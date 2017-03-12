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
import cn.edu.scu.tmoocsystem.dao.DataDao;
import cn.edu.scu.tmoocsystem.dao.impl.DataDaoImpl;
import cn.edu.scu.tmoocsystem.entity.Data;
import cn.edu.scu.tmoocsystem.entity.Test;

/**
 * Servlet implementation class DataServlet
 */
public class DataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DataDao dao = new DataDaoImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataServlet() {
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
		if("finddatapathbydataid".equals(method)){
			finddatapathbydataid(request,response);
		}
		if("getall".equals(method)){
			getall(request,response);
		}
		if("getdatalistbycourseid".equals(method)){
			getdatalistbycourseid(request,response);
		}
	}
	
	private void finddatapathbydataid(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out=response.getWriter();
		int dataid = Integer.parseInt(request.getParameter("comepapaerid"));
		List<Data> datas = dao.finddatapathbydataid(dataid);
		JSONArray jsonArray=JSONArray.fromObject(datas);
		out.println(jsonArray);

		
	}
	private void getdatalistbycourseid(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out=response.getWriter();
		int courseid = Integer.parseInt(request.getParameter("courseid"));
		//int courseid = 111;
		List<Data> datas = dao.getdatalistbycourseid(courseid);
		JSONArray jsonArray=JSONArray.fromObject(datas);
		out.println(jsonArray);

		
	}
	private void getall(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out=response.getWriter();
		int courseid = Integer.parseInt(request.getParameter("courseid"));
		//int courseid = 111;
		List<Data> datas = dao.getAll(courseid);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class,new JsDateJsonValueProcessor());
		JSONArray jsonArray = JSONArray.fromObject(datas,jsonConfig);
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
