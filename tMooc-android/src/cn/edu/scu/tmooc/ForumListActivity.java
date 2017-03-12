package cn.edu.scu.tmooc;


import java.io.IOException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

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
import cn.edu.scu.tmooc.R;
import cn.edu.scu.tmooc.adapter.ForumAdapter;
import cn.edu.scu.tmooc.enginee.ForumEnginee;
import cn.edu.scu.tmooc.entity.Forum;
import cn.edu.scu.tmooc.util.MyConstant;

public class ForumListActivity extends Activity {
	 private Button reback,sendforum;
	 public String studentid = null;
	 
	//声明ListView控件
		private ListView lv_forum;
		
		
		protected static final int SHOW_RESPONSE4 = 0;
		//声明ListView控件
			private List<Forum> forums;
			
			private Handler handler = new Handler() {
				public void handleMessage(Message msg) {
					switch (msg.what) {
					case SHOW_RESPONSE4:
						String message = msg.obj.toString();
						forums = ForumEnginee.parseJSONWithJSONObject(message);
						ForumAdapter adapter = new ForumAdapter(
								getApplicationContext(), R.layout.forum_item,forums);
						lv_forum.setAdapter(adapter);
						break;
					default:
						break;
					}
				};
			};
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_forum_list);
		reback = (Button)findViewById(R.id.reback);
		reback.setOnClickListener(reback1);
		sendforum = (Button)findViewById(R.id.btn_sendforum);
		sendforum.setOnClickListener(sendforum1);
		
		Intent intent = getIntent();
		studentid = intent.getStringExtra("userID");
		//Toast.makeText(getApplicationContext(), "studentid="+studentid, Toast.LENGTH_SHORT).show();
		
		new Thread(new Runnable() {
			public void run() {
				// 声明并初始化HttpClient对象
				HttpClient httpClient = new DefaultHttpClient();
				HttpGet httpGet = new HttpGet(MyConstant.URL + "forum.do?method=getall");
				try {
					HttpResponse httpResponse = httpClient.execute(httpGet);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						HttpEntity resEntity = httpResponse.getEntity();
						String response = EntityUtils.toString(resEntity,"utf-8");
						Message message = new Message();
						message.what = SHOW_RESPONSE4;
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
		lv_forum=(ListView) findViewById(R.id.lv_forum);
	};
		
		public OnClickListener reback1=new OnClickListener() {
			public void onClick(View arg0) {
				Intent intent = new Intent(); 
				intent.putExtra("userID", studentid);
		        intent.setClass(ForumListActivity.this, MainActivity.class); 
		        ForumListActivity.this.startActivity(intent);
		        ForumListActivity.this.finish();
			}
		};
		
		public OnClickListener set1 = new OnClickListener() {
			//主界面→设置界面
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(); 
				intent.putExtra("userID", studentid);
		        intent.setClass(ForumListActivity.this, SetActivity.class); 
		        ForumListActivity.this.startActivity(intent);
				}
		};
		
		public OnClickListener sendforum1 = new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(); 
				intent.putExtra("userID", studentid);
				//Toast.makeText(getApplicationContext(), "studentid="+studentid, Toast.LENGTH_SHORT).show();
		        intent.setClass(ForumListActivity.this, ForumsendActivity.class); 
		        ForumListActivity.this.startActivity(intent);
				}
			};

	
}
