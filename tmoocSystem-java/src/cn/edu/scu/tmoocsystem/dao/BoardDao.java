package cn.edu.scu.tmoocsystem.dao;

import java.util.List;

import cn.edu.scu.tmoocsystem.entity.Board;
import cn.edu.scu.tmoocsystem.entity.Test;

/**
 * ����Test�������ɾ�Ĳ�
 * @author DELL
 *
 */
public interface BoardDao {
	public List<Board> findboardbyboardid(int boardid);
    public  List<Board> getAll();  //����������Ϣ
    	
}