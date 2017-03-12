package cn.edu.scu.tmoocsystem.dao;

import java.util.List;

import cn.edu.scu.tmoocsystem.entity.Student;

public interface RegisterDao {
	public  List<Student> register(int studentid, String studentname, String studentpwd);  //返回所有信息
}
