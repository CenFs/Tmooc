package cn.edu.scu.tmooc.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
//日期工具类
public class DateUtil {
	//格式
	public static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
	/***
	 * 日期转换为字符串
	 * @param date
	 * @return
	 */
	public static String date2Str(Date date){
		
		
		return sdf.format(date);
	}
	
	/**
	 * 把字符串转换为日期
	 * @param str
	 * @return
	 */
	public static Date str2Date(String str){
		try {
			return sdf.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
