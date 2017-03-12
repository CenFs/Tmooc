package cn.edu.scu.tmoocsystem.dao;

import java.util.List;

import cn.edu.scu.tmoocsystem.entity.Board;
import cn.edu.scu.tmoocsystem.entity.Course;


public interface CourseDao {
	public List<Course> findcourseinfobycourseid(int courseid);
	public  List<Course> getAll();  //����������Ϣ
}
