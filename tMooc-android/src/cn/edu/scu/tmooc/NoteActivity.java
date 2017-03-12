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

import cn.edu.scu.tmooc.adapter.NoteAdapter;
import cn.edu.scu.tmooc.enginee.NoteEnginee;
import cn.edu.scu.tmooc.entity.Note;
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


public class NoteActivity extends Activity {
	  private Button reback,add;
	  public String studentid = null;
	  
	
		protected static final int SHOW_RESPONSE5 = 0;
		//声明ListView控件
		private ListView lv_note;
		private List<Note> notes;

		private Handler handler = new Handler() {
			public void handleMessage(Message msg) {
				switch (msg.what) {
				case SHOW_RESPONSE5:
					String message = msg.obj.toString();
					// 将JSON数组转换为List对象
					notes = NoteEnginee.parseJSONWithJSONObject(message);
					NoteAdapter adapter = new NoteAdapter(
							getApplicationContext(), R.layout.note_item,notes);
					lv_note.setAdapter(adapter);
					break;
				default:
					break;
				}
			};
		};
	  
	  
	  
	  
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
		reback = (Button)findViewById(R.id.reback);
		reback.setOnClickListener(reback1);
		add = (Button)findViewById(R.id.btn_addnote);
		add.setOnClickListener(add1);
		
		//获取上一页面的传值
		Intent intent = getIntent();
		studentid = intent.getStringExtra("userID");
		//Toast.makeText(getApplicationContext(), "studentid="+studentid, Toast.LENGTH_SHORT).show();
		  
		
		new Thread(new Runnable() {
			public void run() {
				// 声明并初始化HttpClient对象
				HttpClient httpClient = new DefaultHttpClient();
				HttpPost httpPost = new HttpPost(MyConstant.URL
						+ "note.do?method=findnotebystudentid");

				List<NameValuePair> params = new ArrayList<NameValuePair>();
				params.add(new BasicNameValuePair("studentid", studentid));
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
						message.what = SHOW_RESPONSE5;
						// 将服务器返回的结果存放到Message中
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

	    public OnClickListener reback1 = new OnClickListener() {
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(); 
				intent.putExtra("userID", studentid);
		        intent.setClass(NoteActivity.this, MainActivity.class); 
		        NoteActivity.this.startActivity(intent);
				NoteActivity.this.finish();
			}
		};
		
		public OnClickListener set1 = new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.putExtra("userID", studentid);
		        intent.setClass(NoteActivity.this, SetActivity.class); 
		        NoteActivity.this.startActivity(intent);
		           
			}
		};
		
		public OnClickListener add1 = new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(); 
				intent.putExtra("userID", studentid);
				//Toast.makeText(getApplicationContext(), "studentid="+studentid, Toast.LENGTH_SHORT).show();
		        intent.setClass(NoteActivity.this, NoteAddActivity.class); 
		        NoteActivity.this.startActivity(intent);
				}
			};
		
		private void initView() {
			lv_note = (ListView) findViewById(R.id.lv_note);
		};
}
 
    

