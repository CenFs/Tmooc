package cn.edu.scu.tmooc;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import cn.edu.scu.tmooc.adapter.TestAdapter;
import cn.edu.scu.tmooc.enginee.TestEnginee;
import cn.edu.scu.tmooc.entity.Test;
import cn.edu.scu.tmooc.util.MyConstant;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class TestActivity extends Activity {

	protected static final int SHOW_RESPONSE1 = 0;
	//声明ListView控件
	private ListView lv_test;
	private List<Test> tests;
	private Button reback,btn_testanswer;
	public String studentid = null;
	
	private Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case SHOW_RESPONSE1:
				String message = msg.obj.toString();
				// 将JSON数组转换为List对象
				tests = TestEnginee.parseJSONWithJSONObject(message);
				TestAdapter adapter = new TestAdapter(
						getApplicationContext(), R.layout.test_item,tests);
				lv_test.setAdapter(adapter);
				break;
			default:
				break;
			}
		};
	};

	@Override
      protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);
		reback = (Button)findViewById(R.id.reback);
		reback.setOnClickListener(reback1);
		btn_testanswer = (Button)findViewById(R.id.testanswer);
		btn_testanswer.setOnClickListener(testanswer);
		
		Intent intent = getIntent();
		studentid = intent.getStringExtra("userID");
		//Toast.makeText(getApplicationContext(), "studentid="+studentid, Toast.LENGTH_SHORT).show();
		
		new Thread(new Runnable() {
			public void run() {
				HttpClient httpClient = new DefaultHttpClient();
				HttpPost httpPost = new HttpPost(MyConstant.URL + "test.do?method=getall");
				List<NameValuePair> params = new ArrayList<NameValuePair>();
				params.add(new BasicNameValuePair("studentid", studentid));
				try {
					UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params,"utf-8");
					httpPost.setEntity(entity);
					HttpResponse httpResponse = httpClient.execute(httpPost);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						HttpEntity resEntity = httpResponse.getEntity();
						String response = EntityUtils.toString(resEntity,"utf-8");
						Message message = new Message();
						message.what = SHOW_RESPONSE1;
						message.obj = response.toString();
						handler.sendMessage(message);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}).start();	
		initView();
		Exit.getInstance().addActivity(this);
   	 }

     private void initView() {
		//实例化控件
		lv_test=(ListView) findViewById(R.id.lv_test);
		};
	
		
	
		public OnClickListener reback1=new OnClickListener() {
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(); 
				intent.putExtra("userID", studentid);
		        intent.setClass(TestActivity.this, MainActivity.class); 
		        TestActivity.this.startActivity(intent);
				TestActivity.this.finish();
			}
		};
		
		public OnClickListener set1=new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();  
				intent.putExtra("userID", studentid);
		        intent.setClass(TestActivity.this, SetActivity.class); 
		        TestActivity.this.startActivity(intent);
				}
			};
			
			public OnClickListener testanswer = new OnClickListener() {
				//主界面→设置界面
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent intent = new Intent();  
					intent.putExtra("userID", studentid); 
			        intent.setClass(TestActivity.this, TestanswerActivity.class);  
			        //Toast.makeText(getApplicationContext(), "studentid="+studentid, Toast.LENGTH_SHORT).show();
			        TestActivity.this.startActivity(intent);
					}
				};
	}