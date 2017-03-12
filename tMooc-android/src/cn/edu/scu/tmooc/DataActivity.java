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

import cn.edu.scu.tmooc.adapter.DataAdapter;
import cn.edu.scu.tmooc.enginee.DataEnginee;
import cn.edu.scu.tmooc.entity.Data;
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


public class DataActivity extends Activity {
	  private Button reback;
	  public String studentid,courseid;
	  
	
		protected static final int SHOW_RESPONSE5 = 0;
		//声明ListView控件
		private ListView lv_data;
		private List<Data> datas;

		private Handler handler = new Handler() {
			public void handleMessage(Message msg) {
				switch (msg.what) {
				case SHOW_RESPONSE5:
					String message = msg.obj.toString();
					datas = DataEnginee.parseJSONWithJSONObject(message);
					DataAdapter adapter = new DataAdapter(
							getApplicationContext(), R.layout.data_item,datas);
					lv_data.setAdapter(adapter);
					break;
				default:
					break;
				}
			};
		};
	  
	  
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
		reback = (Button)findViewById(R.id.reback);
		reback.setOnClickListener(reback1);
		
		//获取上一页面的传值
		Intent intent = getIntent();
		//studentid = intent.getStringExtra("userID");
		courseid = intent.getStringExtra("courseid");
		//Toast.makeText(getApplicationContext(), "courseid="+courseid, Toast.LENGTH_SHORT).show();
		  
		new Thread(new Runnable() {
			public void run() {
				HttpClient httpClient = new DefaultHttpClient();
				HttpPost httppost = new HttpPost(MyConstant.URL + "data.do?method=getdatalistbycourseid");
			 	List<NameValuePair> params = new ArrayList<NameValuePair>();
		    	params.add(new BasicNameValuePair("courseid", ""+courseid));
				try {
					UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params,"utf-8");
					httppost.setEntity(entity);
					HttpResponse httpResponse = httpClient.execute(httppost);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						HttpEntity resEntity = httpResponse.getEntity();
						String response = EntityUtils.toString(resEntity, "utf-8");
						Message message = new Message();
						message.what = SHOW_RESPONSE5;
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
				DataActivity.this.finish();
			}
		};
		
		private void initView() {
			lv_data = (ListView) findViewById(R.id.lv_data);
		};
}
 
    

