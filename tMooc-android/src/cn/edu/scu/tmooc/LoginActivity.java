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

import cn.edu.scu.tmooc.adapter.TestpaperAdapter;
import cn.edu.scu.tmooc.enginee.StudentEnginee;
import cn.edu.scu.tmooc.enginee.TestPaperEnginee;
import cn.edu.scu.tmooc.entity.Student;
import cn.edu.scu.tmooc.entity.Test;
import cn.edu.scu.tmooc.util.MyConstant;
import android.support.v4.app.Fragment;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Build;

public class LoginActivity extends Activity {
	private Button bt1,bt2,reback;
	private EditText editUser,editPassword;
	private String userName,passWord;
	private String loginInfo;
	protected static final int SHOW_RESPONSE5 = 0;
	private final static int MSG_SUCCESS = 1;
	private String studentpwd;
	
	
	
	private Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case SHOW_RESPONSE5:
				String message = msg.obj.toString();
				// 将JSON数组转换为List对象
				studentpwd = StudentEnginee.parseJSONWithJSONObject(message);
				if(passWord.equals(studentpwd)){
					Intent intent = new Intent(LoginActivity.this, MainActivity.class);
					intent.putExtra("userID", userName);
					Toast.makeText(getApplicationContext(), "登陆成功,你的ID是"+userName, Toast.LENGTH_SHORT).show();
					startActivity(intent);
					LoginActivity.this.finish();
				}else{
					Toast.makeText(getApplicationContext(), "登陆失败！账号或密码错误！", Toast.LENGTH_SHORT).show();
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
		setContentView(R.layout.activity_login);
		
		
		editUser = (EditText)findViewById(R.id.numberet1);
		editPassword = (EditText)findViewById(R.id.passwordet1);
		
		
			bt1 = (Button)findViewById(R.id.login);
			bt1.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					userName = editUser.getText().toString();
					passWord = editPassword.getText().toString();
					
					new Thread(new Runnable() {
						public void run() {
							HttpClient httpClient = new DefaultHttpClient();
							HttpPost httpPost = new HttpPost(MyConstant.URL
									+ "login.do?method=findstudentbystudentid");

							List<NameValuePair> params = new ArrayList<NameValuePair>();
							params.add(new BasicNameValuePair("studentid", userName));
							try {
								 UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params,"utf-8");
								httpPost.setEntity(entity);
								HttpResponse httpResponse = httpClient.execute(httpPost);
								if (httpResponse.getStatusLine().getStatusCode() == 200) {
									HttpEntity resEntity = httpResponse.getEntity();
									String response = EntityUtils.toString(resEntity,
											"utf-8");
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
				}
			});
			bt2 = (Button)findViewById(R.id.register);
			bt2.setOnClickListener(listener2);
			Exit.getInstance().addActivity(this);
		}
	
	
		public OnClickListener listener2=new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(); 
	            intent.setClass(LoginActivity.this, RegisterActivity.class); 
	            LoginActivity.this.startActivity(intent);
			}
		};
}
