package cn.edu.scu.tmoocsystem.dao;

import java.util.List;

import cn.edu.scu.tmoocsystem.entity.Student;

public interface StudentDao {
	
	public  List<Student> findstudentbystudentid(int studentid);  //����������Ϣ

}
