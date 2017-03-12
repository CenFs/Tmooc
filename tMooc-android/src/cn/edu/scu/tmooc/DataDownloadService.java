package cn.edu.scu.tmooc;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.os.Environment;

public class DataDownloadService {
	
	// 《android4.0网络编程详解》 P184
	public void getObject(String datapath, String dataname) throws Exception {
		//datapath = "http://localhost:8080/tmoocSystem/DownloadData/test.jpg";
		//dataname = "test.jpg";
		String urlpath = datapath;
		URL url = new URL(urlpath);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setConnectTimeout(6*1000);
		if(conn.getResponseCode() == 200) {
			InputStream inputStream = conn.getInputStream();
			byte[] data = readInstream(inputStream);
			//File file = new File(dataname);
			//String sdpath = getSDPath() + "/tMoocDownload/";
			//String allpath = Environment.getExternalStorageDirectory().toString() + "/tMoocDownload/" + dataname; 
			
			String pathName = Environment.getExternalStorageDirectory().toString()+"/tMoocDownload/";
			String fileName = dataname;
			File path = new File(pathName);
			File file = new File(pathName + fileName);
			if(!path.exists()) {
				path.mkdir();
			}
			if(!file.exists()) {
				file.createNewFile();
			}
			System.out.println("path=" + pathName);
			//FileOutputStream stream = new FileOutputStream(file);
			//String s = "this is a test string writing to file.";
			//byte[] buf = s.getBytes();
			//stream.write(buf);

			//File savefile = new File(allpath);
			FileOutputStream outputStream = new FileOutputStream(file);
			outputStream.write(data);
			outputStream.close();
		}
	}
	
	public byte[] readInstream(InputStream inputStream) throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int length = -1;
		while ((length = inputStream.read(buffer)) != -1) {
			byteArrayOutputStream.write(buffer, 0, length);
		}
		;
		byteArrayOutputStream.close();
		inputStream.close();
		return byteArrayOutputStream.toByteArray();
	}
	
	public String getSDPath() { 
	    File sdDir = null; 
	    boolean sdCardExist = Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED);//判断sd卡是否存在
	    if(sdCardExist) sdDir = Environment.getExternalStorageDirectory();//获取跟目录
	    return sdDir.toString(); 
	}
	
	//判断外部存储是否可以读写
	public boolean isExternalStorageWritable() {
		String state = Environment.getExternalStorageState();
		if (Environment.MEDIA_MOUNTED.equals(state)) return true;
		return false;
	}
	
	//判断外部存储是否至少可以读
	public boolean isExternalStorageReadable() {
		String state = Environment.getExternalStorageState();
		if (Environment.MEDIA_MOUNTED.equals(state) || Environment.MEDIA_MOUNTED_READ_ONLY.equals(state))
			return true;
		return false;
	}



}
