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

public class NoteDetailActivity extends Activity {
	
	protected static final int SHOW_RESPONSE = 0;
	private Button reback,save;
	int studentid,noteid;
	String notetitle,notetext,notedate;
	EditText etnotetitle,etnotetext;
	Note notedetail;
	List<Note> notes = new ArrayList<Note>();

	private Handler handlersavenote = new Handler() {
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case SHOW_RESPONSE:
				String message = msg.obj.toString();
				// 将JSON数组转换为List对象
				List<Note> notes = NoteEnginee.parseJSONWithJSONObject(message);
				if(notes != null){
					Intent intent = new Intent(NoteDetailActivity.this, NoteActivity.class);
					intent.putExtra("userID", ""+studentid);
					Toast.makeText(getApplicationContext(), "保存成功!", Toast.LENGTH_SHORT).show();
					startActivity(intent);
					NoteDetailActivity.this.finish();
				}else{
					Toast.makeText(getApplicationContext(), "保存失败!", Toast.LENGTH_SHORT).show();
				}
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
		
		//获取上一页面的传值
		Intent intent = getIntent();
		studentid = Integer.parseInt(intent.getStringExtra("userID"));
		noteid = Integer.parseInt(intent.getStringExtra("noteid"));
		notetext = intent.getStringExtra("notetext");
		notetitle = intent.getStringExtra("notetitle");
		notedate = intent.getStringExtra("notedate");
		
		etnotetitle = (EditText)findViewById(R.id.et_notetitle);
		etnotetext = (EditText)findViewById(R.id.et_notedetail);
		
		etnotetitle.setText(notetitle);
		etnotetext.setText(notetext);

		
		reback = (Button)findViewById(R.id.reback);
		reback.setOnClickListener(reback1);
		save = (Button)findViewById(R.id.btn_savenote);
		save.setOnClickListener(save1);
		
		
		Exit.getInstance().addActivity(this);
		
	}
	
	
    public OnClickListener reback1 = new OnClickListener() {
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			NoteDetailActivity.this.finish();
		}
	};
	
	public OnClickListener set1 = new OnClickListener() {
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();  
	        intent.setClass(NoteDetailActivity.this, SetActivity.class);  
	        NoteDetailActivity.this.startActivity(intent);
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
					params.add(new BasicNameValuePair("studentid", ""+studentid));
					params.add(new BasicNameValuePair("noteid", ""+noteid));
					params.add(new BasicNameValuePair("notetitle", notetitle));
					params.add(new BasicNameValuePair("notetext", notetext));
					params.add(new BasicNameValuePair("status", "update"));
					try {
						UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params,"utf-8");
						httpPost.setEntity(entity);
						HttpResponse httpResponse = httpClient.execute(httpPost);
						if (httpResponse.getStatusLine().getStatusCode() == 200) {
							// 请求和响应都成功
							HttpEntity resEntity = httpResponse.getEntity();
							String response = EntityUtils.toString(resEntity,"utf-8");
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
