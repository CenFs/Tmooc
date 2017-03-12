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
import org.json.JSONArray;
import org.json.JSONObject;

import cn.edu.scu.tmooc.enginee.TestEnginee;
import cn.edu.scu.tmooc.enginee.TestPaperEnginee;
import cn.edu.scu.tmooc.adapter.TestpaperAdapter;
import cn.edu.scu.tmooc.entity.Test;
import cn.edu.scu.tmooc.entity.Testanswer;
import cn.edu.scu.tmooc.util.MyConstant;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class TestpaperActivity extends Activity {

	protected static final int SHOW_RESPONSE = 0;
	protected static final int SHOW_RESPONSE2 = 2;
	private ListView lv_testpaper;
	private List<Test> testpapers;
	String comepaperid, answer;
	int studentid, answerpaperid, courseid, teacherid;
	private Button endtest;
	EditText etanswer;
	Testanswer maxanswerpaperid;
	List<Testanswer> testanswers = new ArrayList<Testanswer>();
	private Button reback;
	
	private Handler handlerinsertanswer = new Handler() {
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case SHOW_RESPONSE:
				String message = msg.obj.toString();
				List<Test> tests = TestEnginee.parseJSONWithJSONObject(message);
				if(tests != null){
					Intent intent = new Intent(TestpaperActivity.this, TestActivity.class);
					intent.putExtra("userID", ""+studentid);
					Toast.makeText(getApplicationContext(), "提交成功!", Toast.LENGTH_SHORT).show();
					startActivity(intent);
					TestpaperActivity.this.finish();
				}else{
					Toast.makeText(getApplicationContext(), "保存失败!", Toast.LENGTH_SHORT).show();
				}
				break;
			default:
				break;
			}
		};
	};
	
	private Handler handlergetmaxanswerpaperid = new Handler() {
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case SHOW_RESPONSE:
				try {
					JSONArray jsonArray = new JSONArray(msg.obj.toString());
					JSONObject jsonObject = jsonArray.getJSONObject(0);
					int answerpaperidt = jsonObject.getInt("answerpaperid");
					maxanswerpaperid = new Testanswer();
					maxanswerpaperid.setAnswerpaperid(answerpaperidt);
					testanswers.add(maxanswerpaperid);
				} catch (Exception e) {
				e.printStackTrace();
			}
				answerpaperid = maxanswerpaperid.getAnswerpaperid()+1;
				//Toast.makeText(getApplicationContext(), "maxnoteid="+maxanswerpaperid, Toast.LENGTH_SHORT).show();
				break;
			default:
				break;
			}
		};
	};
	
	
	private Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case SHOW_RESPONSE:
				String message = msg.obj.toString();
				testpapers = TestPaperEnginee.parseJSONWithJSONObject(message);
				TestpaperAdapter adapter = new TestpaperAdapter(
						getApplicationContext(), R.layout.testpaper_item, testpapers);
				lv_testpaper.setAdapter(adapter);
				break;
			default:
				break;
			}
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.testpaper);
		
		reback = (Button)findViewById(R.id.reback);
		reback.setOnClickListener(reback1);
		
		Intent intent = getIntent();
		comepaperid = intent.getStringExtra("Message");
		studentid = Integer.parseInt(intent.getStringExtra("userID"));
		
		new Thread(new Runnable() {
			public void run() {
				HttpClient httpClient = new DefaultHttpClient();
				HttpPost httpPost = new HttpPost(MyConstant.URL + "test.do?method=findtestbypaperid");
				List<NameValuePair> params = new ArrayList<NameValuePair>();
				params.add(new BasicNameValuePair("comepapaerid", comepaperid));
				try {
					 UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params,"utf-8");
					httpPost.setEntity(entity);
					HttpResponse httpResponse = httpClient.execute(httpPost);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						HttpEntity resEntity = httpResponse.getEntity();
						String response = EntityUtils.toString(resEntity, "utf-8");
						Message message = new Message();
						message.what = SHOW_RESPONSE;
						message.obj = response.toString();
						handler.sendMessage(message);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

				
				httpClient = new DefaultHttpClient();
				httpPost = new HttpPost(MyConstant.URL + "testanswer.do?method=getmaxanswerpaperid");
				params = new ArrayList<NameValuePair>();
				try {
					 UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params,"utf-8");
					httpPost.setEntity(entity);
					HttpResponse httpResponse = httpClient.execute(httpPost);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						HttpEntity resEntity = httpResponse.getEntity();
						String response = EntityUtils.toString(resEntity, "utf-8");
						Message message = new Message();
						message.what = SHOW_RESPONSE2;
						message.obj = response.toString();
						handlergetmaxanswerpaperid.sendMessage(message);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		
		etanswer = (EditText)findViewById(R.id.et_answer);
		endtest = (Button)findViewById(R.id.btn_endtest);
		endtest.setOnClickListener(endtest1);
		
		initView();
		Exit.getInstance().addActivity(this);
	}

	private void initView() {
		lv_testpaper = (ListView) findViewById(R.id.lv_testpaper);
	};
	
	public OnClickListener endtest1 = new OnClickListener() {
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			answer = etanswer.getText().toString();
			//Toast.makeText(getApplicationContext(), "answer="+answer+"   comepaperid="+comepaperid+"   studentid="+studentid, Toast.LENGTH_SHORT).show();
			
			new Thread(new Runnable() {
				public void run() {
					HttpClient httpClient = new DefaultHttpClient();
					HttpPost httpPost = new HttpPost(MyConstant.URL + "testanswer.do?method=endtest");

					List<NameValuePair> params = new ArrayList<NameValuePair>();
					params.add(new BasicNameValuePair("answer", ""+answer));
					params.add(new BasicNameValuePair("studentid", ""+studentid));
					params.add(new BasicNameValuePair("paperid", ""+comepaperid));
					try {
						UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params,"utf-8");
						httpPost.setEntity(entity);
						HttpResponse httpResponse = httpClient.execute(httpPost);
						if (httpResponse.getStatusLine().getStatusCode() == 200) {
							HttpEntity resEntity = httpResponse.getEntity();
							String response = EntityUtils.toString(resEntity, "utf-8");
							Message message = new Message();
							message.what = SHOW_RESPONSE;
							message.obj = response.toString();
							handlerinsertanswer.sendMessage(message);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}).start();
			}
		};
		
		public OnClickListener reback1=new OnClickListener() {
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				TestpaperActivity.this.finish();
			}
		};
}
