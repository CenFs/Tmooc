package cn.edu.scu.tmoocsystem.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import cn.edu.scu.tmoocsystem.dao.TestDao;
import cn.edu.scu.tmoocsystem.dao.impl.TestDaoImpl;
import cn.edu.scu.tmoocsystem.entity.Test;

/**
 * Servlet implementation class TestServlet
 */
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TestDao dao=new TestDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
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
		if("findtestbypaperid".equals(method)){
			findtestbypaperid(request,response);
		}
		if("getall".equals(method)){
			getall(request,response);
		}
	}
	
	private void findtestbypaperid(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out=response.getWriter();
		int paperid=Integer.parseInt(request.getParameter("comepapaerid"));
		List<Test> tests=dao.findtestbypaperid(paperid);
		JSONArray jsonArray=JSONArray.fromObject(tests);
		out.println(jsonArray);

		
	}
	
	private void getall(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		int studentid = Integer.parseInt(request.getParameter("studentid"));
		List<Test> tests = dao.getAll(studentid);
		JSONArray jsonArray=JSONArray.fromObject(tests);
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
