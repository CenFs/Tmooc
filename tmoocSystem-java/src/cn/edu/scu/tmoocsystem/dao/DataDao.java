package cn.edu.scu.tmoocsystem.dao;

import java.util.List;

import cn.edu.scu.tmoocsystem.entity.Data;

public interface DataDao {
    public List<Data> finddatapathbydataid(int dataid);
    public  List<Data> getAll(int courseid);  //返回所有信息
    public  List<Data> getdatalistbycourseid(int courseid);  //返回所有信息
}
