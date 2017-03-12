package cn.edu.scu.tmoocsystem.dao;

import java.util.List;

import cn.edu.scu.tmoocsystem.entity.Test;

/**
 * 用于Test对象的增删改查
 * @author DELL
 *
 */
public interface TestDao {
    public List<Test> findtestbypaperid(int paperid);
    public  List<Test> getAll(int studentid);  //返回所有信息
    	
}
