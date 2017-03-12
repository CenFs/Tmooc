package cn.edu.scu.tmoocsystem.dao;

import java.util.List;

import cn.edu.scu.tmoocsystem.entity.Testanswer;

/**
 * 锟斤拷锟斤拷Test锟斤拷锟斤拷锟斤拷锟缴撅拷牟锟�
 * @author DELL
 *
 */
public interface TestanswerDao {
	public List<Testanswer> findtestanswerbyanswerpaperid(int answerpaperid);
	public List<Testanswer> findtestanswerbystudentid(int studentid);
    public List<Testanswer> getAll();
    public List<Testanswer> getmaxanswerpaperid();
    public List<Testanswer> endtest(String answer, int studentid, int paperid);
}