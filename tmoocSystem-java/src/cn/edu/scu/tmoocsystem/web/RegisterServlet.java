package cn.edu.scu.tmoocsystem.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import cn.edu.scu.tmoocsystem.dao.RegisterDao;
import cn.edu.scu.tmoocsystem.dao.impl.RegisterDaoImpl;
import cn.edu.scu.tmoocsystem.entity.Student;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RegisterDao dao = new RegisterDaoImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		if("register".equals(method)){
			register(request,response);
		}
	}

	private void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		// 获取用户输入的东西
		int studentid = Integer.parseInt(request.getParameter("studentid"));
		String studentname= request.getParameter("studentname");
		String studentpwd= request.getParameter("studentpwd");
		List<Student> studentinfo = dao.register(studentid,studentname,studentpwd);
		//将集合以JSON格式显示
		JSONArray jsonArray = JSONArray.fromObject(studentinfo);
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
