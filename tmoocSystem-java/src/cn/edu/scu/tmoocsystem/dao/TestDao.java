package cn.edu.scu.tmoocsystem.dao;

import java.util.List;

import cn.edu.scu.tmoocsystem.entity.Test;

/**
 * ����Test�������ɾ�Ĳ�
 * @author DELL
 *
 */
public interface TestDao {
    public List<Test> findtestbypaperid(int paperid);
    public  List<Test> getAll(int studentid);  //����������Ϣ
    	
}
