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

import cn.edu.scu.tmooc.enginee.NoteEnginee;
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

public class NoteAddActivity extends Activity {
	
	protected static final int SHOW_RESPONSE = 0;
	private Button reback,save;
	String studentid,notetitle,notetext;
	int noteid;
	EditText etnotetitle,etnotetext;
	Note maxnoteid;
	List<Note> notes = new ArrayList<Note>();
	
	private Handler handlersavenote = new Handler() {
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case SHOW_RESPONSE:
				String message = msg.obj.toString();
				// 将JSON数组转换为List对象
				List<Note> notes = NoteEnginee.parseJSONWithJSONObject(message);
				if(notes != null){
					Intent intent = new Intent(NoteAddActivity.this, NoteActivity.class);
					intent.putExtra("userID", studentid);
					Toast.makeText(getApplicationContext(), "保存成功!", Toast.LENGTH_SHORT).show();
					startActivity(intent);
					NoteAddActivity.this.finish();
				}else{
					Toast.makeText(getApplicationContext(), "保存失败!", Toast.LENGTH_SHORT).show();
				}
				break;
			default:
				break;
			}
		};
	};
	

	private Handler handlergetmaxnoteid = new Handler() {
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case SHOW_RESPONSE:
				try {
				JSONArray jsonArray = new JSONArray(msg.obj.toString());
					JSONObject jsonObject = jsonArray.getJSONObject(0);
					int noteidt = jsonObject.getInt("noteid");
					String notetitlet = jsonObject.getString("notetitle");
					String notetextt = jsonObject.getString("notetext");
					String notedatet = jsonObject.getString("notedate");
					JSONObject jObject = new JSONObject(notedatet);
					Date d = new Date(jObject.getInt("year")-1900,jObject.getInt("month"),jObject.getInt("day"));
					int studentidt = jsonObject.getInt("studentid");
					
					maxnoteid = new Note();
					maxnoteid.setNoteid(noteidt);
					maxnoteid.setNotetitle(notetitlet);
					maxnoteid.setNotetext(notetextt);
					maxnoteid.setNotedate(d);
					maxnoteid.setStudentid(studentidt);
					
					notes.add(maxnoteid);
				} catch (Exception e) {
				e.printStackTrace();
			}
					noteid = maxnoteid.getNoteid()+1;
					//Toast.makeText(getApplicationContext(), "maxnoteid="+noteid, Toast.LENGTH_SHORT).show();
				break;
			default:
				break;
			}
		};
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notedetail);
		
		reback = (Button)findViewById(R.id.reback);
		reback.setOnClickListener(reback1);
		
		//获取上一页面的传值
		Intent intent = getIntent();
		studentid = intent.getStringExtra("userID");
		
		etnotetitle = (EditText)findViewById(R.id.et_notetitle);
		etnotetext = (EditText)findViewById(R.id.et_notedetail);		

		
		new Thread(new Runnable() {
			public void run() {
				// 声明并初始化HttpClient对象
				HttpClient httpClient = new DefaultHttpClient();
				HttpGet httpGet = new HttpGet(MyConstant.URL + "note.do?method=getmaxnoteid");
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
						handlergetmaxnoteid.sendMessage(message);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		reback = (Button)findViewById(R.id.reback);
		reback.setOnClickListener(reback1);
		save = (Button)findViewById(R.id.btn_savenote);
		save.setOnClickListener(save1);
		
		
		Exit.getInstance().addActivity(this);
		
	}
	
	
    public OnClickListener reback1 = new OnClickListener() {
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			NoteAddActivity.this.finish();
		}
	};
	
	public OnClickListener set1 = new OnClickListener() {
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent intent = new Intent(); 
			intent.putExtra("userID", studentid);
	        intent.setClass(NoteAddActivity.this, SetActivity.class);  
	        NoteAddActivity.this.startActivity(intent);
		}
	};
	
	public OnClickListener save1 = new OnClickListener() {
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			notetitle = etnotetitle.getText().toString();
			notetext = etnotetext.getText().toString();

			new Thread(new Runnable() {
				public void run() {
					// 声明并初始化HttpClient对象
					HttpClient httpClient = new DefaultHttpClient();
					HttpPost httpPost = new HttpPost(MyConstant.URL + "note.do?method=savenote");

					List<NameValuePair> params = new ArrayList<NameValuePair>();
					params.add(new BasicNameValuePair("studentid", studentid));
					params.add(new BasicNameValuePair("noteid", ""+noteid));
					params.add(new BasicNameValuePair("notetitle", notetitle));
					params.add(new BasicNameValuePair("notetext", notetext));
					params.add(new BasicNameValuePair("status", "add"));
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
							handlersavenote.sendMessage(message);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}).start();
			}
		};
}
