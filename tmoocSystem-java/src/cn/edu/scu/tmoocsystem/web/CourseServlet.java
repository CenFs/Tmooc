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
import cn.edu.scu.tmoocsystem.dao.CourseDao;
import cn.edu.scu.tmoocsystem.dao.impl.CourseDaoImpl;
import cn.edu.scu.tmoocsystem.entity.Board;
import cn.edu.scu.tmoocsystem.entity.Course;

/**
 * Servlet implementation class CourseServlet
 */
public class CourseServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
		private CourseDao dao = new CourseDaoImpl();
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public CourseServlet() {
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
			if("coursedetail".equals(method)){
				coursedetail(request,response);
			}
			if("getall".equals(method)){
				getall(request,response);
			}
		}
		private void coursedetail(HttpServletRequest request, HttpServletResponse response) throws IOException {
			
			response.setContentType("text/json;charset=utf-8");
//			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			int courseid=Integer.parseInt(request.getParameter("comecourseid"));
			List<Course> courses=dao.findcourseinfobycourseid(courseid);
			

//			//��������JSON��ʽ��ʾ
			JSONArray jsonArray=JSONArray.fromObject(courses);
			out.println(jsonArray);

			
		}	
		private void getall(HttpServletRequest request,HttpServletResponse response) throws IOException {
			
			response.setContentType("text/json;charset=utf-8");
			PrintWriter out=response.getWriter();
			List<Course> courses=dao.getAll();
			

			//��������JSON��ʽ��ʾ
			JSONArray jsonArray=JSONArray.fromObject(courses);
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