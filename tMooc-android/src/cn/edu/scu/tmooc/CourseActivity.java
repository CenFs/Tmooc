package cn.edu.scu.tmooc;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import cn.edu.scu.tmooc.adapter.CourseAdapter;
import cn.edu.scu.tmooc.enginee.CourseEnginee;
import cn.edu.scu.tmooc.entity.Course;
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

public class CourseActivity extends Activity {

	protected static final int SHOW_RESPONSE3 = 0;
	private ListView lv_course;
	public String studentid = null;
	private List<Course> courses;
	private Button reback;
		
			private Handler handler = new Handler() {
				public void handleMessage(Message msg) {
					switch (msg.what) {
					case SHOW_RESPONSE3:
						String message = msg.obj.toString();
						// 将JSON数组转换为List对象
						courses = CourseEnginee.parseJSONWithJSONObject(message);
						CourseAdapter adapter = new CourseAdapter(
								getApplicationContext(), R.layout.course_item,courses);
						lv_course.setAdapter(adapter);
						break;
					default:
						break;
					}
				};
			};
		

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_course);
		reback = (Button)findViewById(R.id.reback);
		reback.setOnClickListener(reback1);
		
		Intent intent = getIntent();
		studentid = intent.getStringExtra("userID");
		
		
		new Thread(new Runnable() {
			public void run() {
				HttpClient httpClient = new DefaultHttpClient();
				HttpGet httpGet = new HttpGet(MyConstant.URL + "course.do?method=getall");
				try {
					HttpResponse httpResponse = httpClient.execute(httpGet);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						HttpEntity resEntity = httpResponse.getEntity();
						String response = EntityUtils.toString(resEntity, "utf-8");
						Message message = new Message();
						message.what = SHOW_RESPONSE3;
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
		lv_course=(ListView) findViewById(R.id.lv_course);		
	}


	public OnClickListener reback1=new OnClickListener() {
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			CourseActivity.this.finish();
		}
	};
	
	public OnClickListener set1=new OnClickListener() {
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent intent = new Intent(); 
			intent.putExtra("userID", studentid);
	        intent.setClass(CourseActivity.this, SetActivity.class); 
	        CourseActivity.this.startActivity(intent);
			}
		};
}
