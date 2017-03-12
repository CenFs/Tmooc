package cn.edu.scu.tmooc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import cn.edu.scu.tmooc.enginee.ForumEnginee;
import cn.edu.scu.tmooc.enginee.NoteEnginee;
import cn.edu.scu.tmooc.entity.Forum;
import cn.edu.scu.tmooc.entity.Note;
import cn.edu.scu.tmooc.util.MyConstant;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForumsendActivity extends Activity {

	protected static final int SHOW_RESPONSE = 0;
	private Button reback,sendthisforum;
	int forumid;
	String studentid,forumname,foruminformation;
	EditText etforumname,etforumdetail;
	Forum maxforumid;
	List<Forum> forums = new ArrayList<Forum>();
	
	private Handler handlersaveforum = new Handler() {
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case SHOW_RESPONSE:
				String message = msg.obj.toString();
				// 将JSON数组转换为List对象
				List<Forum> forums = ForumEnginee.parseJSONWithJSONObject(message);
				if(forums != null){
					Intent intent = new Intent(ForumsendActivity.this, ForumListActivity.class);
					intent.putExtra("userID", studentid);
					Toast.makeText(getApplicationContext(), "发帖成功!", Toast.LENGTH_SHORT).show();
					startActivity(intent);
					ForumsendActivity.this.finish();
				}else{
					Toast.makeText(getApplicationContext(), "发帖失败!", Toast.LENGTH_SHORT).show();
				}
				break;
			default:
				break;
			}
		};
	};
	

	private Handler handlergetmaxforumid = new Handler() {
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case SHOW_RESPONSE:
				try {
				JSONArray jsonArray = new JSONArray(msg.obj.toString());
					JSONObject jsonObject = jsonArray.getJSONObject(0);
					int forumidt = jsonObject.getInt("forumid");
					String forumnamet = jsonObject.getString("forumname");
					String foruminformationt = jsonObject.getString("foruminformation");
					String forumdatet = jsonObject.getString("forumdate");
					JSONObject jObject = new JSONObject(forumdatet);
					Date d = new Date(jObject.getInt("year")-1900,jObject.getInt("month"),jObject.getInt("day"));
					int studentidt = jsonObject.getInt("studentid");
					
					maxforumid = new Forum();
					maxforumid.setForumid(forumidt);
					maxforumid.setForumname(forumnamet);
					maxforumid.setForuminformation(foruminformationt);
					maxforumid.setForumdate(d);
					maxforumid.setStudentid(studentidt);
					
					forums.add(maxforumid);
				} catch (Exception e) {
				e.printStackTrace();
			}
					forumid = maxforumid.getForumid()+1;
					//Toast.makeText(getApplicationContext(), "forumid="+forumid, Toast.LENGTH_SHORT).show();
				break;
			default:
				break;
			}
		};
	};
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.forumsend);
		
		reback = (Button)findViewById(R.id.reback);
		reback.setOnClickListener(reback1);
		sendthisforum = (Button)findViewById(R.id.btn_sendthisforum);
		sendthisforum.setOnClickListener(sendthisforum1);
		
		Intent intent = getIntent();
		studentid = intent.getStringExtra("userID");
		
		etforumname = (EditText)findViewById(R.id.et_forumtitle);
		etforumdetail = (EditText)findViewById(R.id.et_forumdetail);		

		
		new Thread(new Runnable() {
			public void run() {
				// 声明并初始化HttpClient对象
				HttpClient httpClient = new DefaultHttpClient();
				HttpGet httpGet = new HttpGet(MyConstant.URL + "forum.do?method=getmaxforumid");
				try {
					HttpResponse httpResponse = httpClient.execute(httpGet);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						// 请求和响应都成功
						HttpEntity resEntity = httpResponse.getEntity();
						String response = EntityUtils.toString(resEntity,"utf-8");
						Message message = new Message();
						message.what = SHOW_RESPONSE;
						// 将服务器返回的结果存放到Message中
						message.obj = response.toString();
						handlergetmaxforumid.sendMessage(message);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}).start();
		Exit.getInstance().addActivity(this);
	}
	
	public OnClickListener reback1 = new OnClickListener() {
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent intent = new Intent(); 
			intent.putExtra("userID", studentid);
	        intent.setClass(ForumsendActivity.this, ForumsendActivity.class); 
	        ForumsendActivity.this.startActivity(intent);
	        ForumsendActivity.this.finish();
		}
	};
	
	public OnClickListener set1 = new OnClickListener() {
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.putExtra("userID", studentid);
	        intent.setClass(ForumsendActivity.this, SetActivity.class);  
	        ForumsendActivity.this.startActivity(intent);
		}
	};
	
	public OnClickListener sendthisforum1 = new OnClickListener() {
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			forumname = etforumname.getText().toString();
			foruminformation = etforumdetail.getText().toString();

			new Thread(new Runnable() {
				public void run() {
					// 声明并初始化HttpClient对象
					HttpClient httpClient = new DefaultHttpClient();
					HttpPost httpPost = new HttpPost(MyConstant.URL + "forum.do?method=sendthisforum");

					List<NameValuePair> params = new ArrayList<NameValuePair>();
					params.add(new BasicNameValuePair("studentid", studentid));
					params.add(new BasicNameValuePair("forumid", ""+forumid));
					params.add(new BasicNameValuePair("forumname", forumname));
					params.add(new BasicNameValuePair("foruminformation", foruminformation));
					try {
						UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params,"utf-8");
						httpPost.setEntity(entity);
						HttpResponse httpResponse = httpClient.execute(httpPost);
						if (httpResponse.getStatusLine().getStatusCode() == 200) {
							// 请求和响应都成功
							HttpEntity resEntity = httpResponse.getEntity();
							String response = EntityUtils.toString(resEntity,
									"utf-8");
							Message message = new Message();
							message.what = SHOW_RESPONSE;
							// 将服务器返回的结果存放到Message中
							message.obj = response.toString();
							handlersaveforum.sendMessage(message);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}).start();
			}
		};
}
