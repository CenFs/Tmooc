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

import cn.edu.scu.tmooc.adapter.TestanswerAdapter;
import cn.edu.scu.tmooc.enginee.TestanswerEnginee;
import cn.edu.scu.tmooc.entity.Testanswer;
import cn.edu.scu.tmooc.util.MyConstant;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class TestanswerActivity extends ActionBarActivity {

	protected static final int SHOW_RESPONSE7 = 10;
	public String studentid = null;
	private ListView lv_testanswer;
	private List<Testanswer> testanswers;
	private Button reback;
	private Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case SHOW_RESPONSE7:
				String message = msg.obj.toString();
				testanswers = TestanswerEnginee.parseJSONWithJSONObject(message);
				TestanswerAdapter adapter = new TestanswerAdapter(
						getApplicationContext(), R.layout.testanswer_item,testanswers);
				lv_testanswer.setAdapter(adapter);
				break;
			default:
				break;
			}
		};
	};

	@Override
      protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_testanswer);
		
		reback = (Button)findViewById(R.id.reback);
		reback.setOnClickListener(reback1);

		Intent intent = getIntent();
		studentid = intent.getStringExtra("userID");
		
		//Toast.makeText(getApplicationContext(), "studentid="+studentid, Toast.LENGTH_SHORT).show();
		
		new Thread(new Runnable() {
			public void run() {
				HttpClient httpClient = new DefaultHttpClient();
				HttpPost httpPost = new HttpPost(MyConstant.URL + "testanswer.do?method=findtestanswerbystudentid");
				Log.i("testxx","hehe");
				List<NameValuePair> params = new ArrayList<NameValuePair>();
				params.add(new BasicNameValuePair("studentid", studentid));
				try {
					UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params,"utf-8");
					httpPost.setEntity(entity);
					HttpResponse httpResponse = httpClient.execute(httpPost);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						HttpEntity resEntity = httpResponse.getEntity();
						String response = EntityUtils.toString(resEntity,"utf-8");
						Log.i("test2222",response);
						Message message = new Message();
						message.what = SHOW_RESPONSE7;
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
		lv_testanswer=(ListView) findViewById(R.id.lv_testanswer);
	};
		public OnClickListener reback1=new OnClickListener() {
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				TestanswerActivity.this.finish();
			}
		};
		public OnClickListener set1=new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(); 
				intent.putExtra("userID", studentid);
		        intent.setClass(TestanswerActivity.this, SetActivity.class); 
		        TestanswerActivity.this.startActivity(intent);
				}
			};
	}