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

import cn.edu.scu.tmooc.enginee.StudentEnginee;
import cn.edu.scu.tmooc.util.MyConstant;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends Activity {

	Button bt1,reback;
	private EditText editUser,editPassword,editPassword2,editUsername;
	private String userID,passWord,passWord2,stuName;
	protected static final int SHOW_RESPONSE7 = 0;
	
	
	private Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case SHOW_RESPONSE7:
				String message = msg.obj.toString();
				String studentpwd = StudentEnginee.parseJSONWithJSONObject(message);
				if(passWord.equals(studentpwd)){
					Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
					intent.putExtra("userID", userID);
					Toast.makeText(getApplicationContext(), "注册成功,你的ID是"+userID, Toast.LENGTH_SHORT).show();
					startActivity(intent);
					RegisterActivity.this.finish();
				} else {
					Toast.makeText(getApplicationContext(), "居然能失败。。程序员去吃屎。。", Toast.LENGTH_SHORT).show();
				}
				break;
			default:
				break;
			}
		};
	};
	
	
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		
		editUser = (EditText)findViewById(R.id.numberet2);
		editUsername = (EditText)findViewById(R.id.numberet1);
		editPassword = (EditText)findViewById(R.id.passwordet1);
		editPassword2 = (EditText)findViewById(R.id.once_more_passwordet1);
		
			// TODO Auto-generated method stub
			bt1 = (Button)findViewById(R.id.register);
			bt1.setOnClickListener(register);
			reback = (Button)findViewById(R.id.reback);
			reback.setOnClickListener(reback1);
			
			Exit.getInstance().addActivity(this);
			
		}
		
		public OnClickListener register = new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				userID = editUser.getText().toString();
				stuName = editUsername.getText().toString();
				passWord = editPassword.getText().toString();
				passWord2 = editPassword2.getText().toString();
				
				if(passWord.equals(passWord2)){
				
					new Thread(new Runnable() {
						public void run() {	
							HttpClient httpClient = new DefaultHttpClient();
							HttpPost httpPost = new HttpPost(MyConstant.URL	+ "register.do?method=register");
	
							List<NameValuePair> params = new ArrayList<NameValuePair>();
							params.add(new BasicNameValuePair("studentid", userID));
							params.add(new BasicNameValuePair("studentname", stuName));
							params.add(new BasicNameValuePair("studentpwd", passWord));
							try {
								UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params,"utf-8");
								httpPost.setEntity(entity);
								HttpResponse httpResponse = httpClient.execute(httpPost);
								if (httpResponse.getStatusLine().getStatusCode() == 200) {
									HttpEntity resEntity = httpResponse.getEntity();
									String response = EntityUtils.toString(resEntity,"utf-8");
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
					
				}else{
					Toast.makeText(getApplicationContext(), "两次密码输入不一致！", Toast.LENGTH_SHORT).show();
				}
			}
		};
		
		public OnClickListener reback1=new OnClickListener() {
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				RegisterActivity.this.finish();
			}
		};
}
