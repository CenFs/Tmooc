package cn.edu.scu.tmoocsystem.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import cn.edu.scu.tmoocsystem.dao.StudentDao;
import cn.edu.scu.tmoocsystem.dao.impl.StudentDaoImpl;
import cn.edu.scu.tmoocsystem.entity.Student;

/**
 * Servlet implementation class StudentServlet
 */
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private StudentDao dao = new StudentDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
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
		if("findstudentbystudentid".equals(method)){
			findstudentbystudentid(request,response);
		}
	}
	
	private void findstudentbystudentid(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		// ��ȡ�û�����Ķ���
		int studentid = Integer.parseInt(request.getParameter("studentid"));
		List<Student> studentpwd = dao.findstudentbystudentid(studentid);
		//��������JSON��ʽ��ʾ
		JSONArray jsonArray = JSONArray.fromObject(studentpwd);
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
