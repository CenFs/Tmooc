package cn.edu.scu.tmooc.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
//���ڹ�����
public class DateUtil {
	//��ʽ
	public static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
	/***
	 * ����ת��Ϊ�ַ���
	 * @param date
	 * @return
	 */
	public static String date2Str(Date date){
		
		
		return sdf.format(date);
	}
	
	/**
	 * ���ַ���ת��Ϊ����
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
