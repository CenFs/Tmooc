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

import cn.edu.scu.tmooc.adapter.CoursedetailAdapter;
import cn.edu.scu.tmooc.enginee.CoursedetailEnginee;
import cn.edu.scu.tmooc.entity.Course;
import cn.edu.scu.tmooc.util.MyConstant;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

public class CoursedetailActivity extends ActionBarActivity {

	protected static final int SHOW_RESPONSE8 = 0;
	private Button datalist;
	String studentid,comecourseid;;
	private Button reback;
	private ListView lv_coursedetail;
	private List<Course> coursedetails;
		
	
		private Handler handler = new Handler() {
			public void handleMessage(Message msg) {
				switch (msg.what) {
				case SHOW_RESPONSE8:
					String message = msg.obj.toString();
					// 将JSON数组转换为List对象
					coursedetails = CoursedetailEnginee.parseJSONWithJSONObject(message);
					CoursedetailAdapter adapter = new CoursedetailAdapter(
							getApplicationContext(), R.layout.coursedetail_item,coursedetails);
					lv_coursedetail.setAdapter(adapter);
					break;
				default:
					break;
				}
			};
		};
		
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_coursedetail);
		
		reback = (Button)findViewById(R.id.reback);
		reback.setOnClickListener(reback1);
		
		Intent intent = getIntent();
		comecourseid = intent.getStringExtra("Message");
		//studentid = intent.getStringExtra("userID");
		//Toast.makeText(getApplicationContext(), comecourseid, Toast.LENGTH_SHORT).show();
		
		new Thread(new Runnable() {
			public void run() {
				// 声明并初始化HttpClient对象
				HttpClient httpClient = new DefaultHttpClient();
				HttpPost httpPost = new HttpPost(MyConstant.URL + "course.do?method=coursedetail");
			 	List<NameValuePair> params = new ArrayList<NameValuePair>();
		    	params.add(new BasicNameValuePair("comecourseid", comecourseid));
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
						message.what = SHOW_RESPONSE8;
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
	
	private void initView() {
		lv_coursedetail=(ListView) findViewById(R.id.lv_coursedetail);
	};
	
	public OnClickListener reback1 = new OnClickListener() {
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			CoursedetailActivity.this.finish();
		}
	};
	
}
