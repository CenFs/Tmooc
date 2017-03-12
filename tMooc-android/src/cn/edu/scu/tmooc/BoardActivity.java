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
import cn.edu.scu.tmooc.R;
import cn.edu.scu.tmooc.adapter.BoardAdapter;
import cn.edu.scu.tmooc.enginee.BoardEnginee;
import cn.edu.scu.tmooc.entity.Board;
import cn.edu.scu.tmooc.util.MyConstant;

public class BoardActivity extends Activity {
	
	protected static final int SHOW_RESPONSE2 = 0;

	private Button reback;
		private ListView lv_board;
		private List<Board> boards;
		String userID = null;
		
		private Handler handler = new Handler() {
			public void handleMessage(Message msg) {
				switch (msg.what) {
				case SHOW_RESPONSE2:
					String message = msg.obj.toString();
					boards = BoardEnginee.parseJSONWithJSONObject(message);
					BoardAdapter adapter = new BoardAdapter(
							getApplicationContext(), R.layout.board_item,boards);
					lv_board.setAdapter(adapter);
					break;
				default:
					break;
				}
			};
		};


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_board_list);
		reback = (Button)findViewById(R.id.reback);
		reback.setOnClickListener(reback1);

		Intent intent = getIntent();
		userID = intent.getStringExtra("userID");
		
		new Thread(new Runnable() {
			public void run() {
				HttpClient httpClient = new DefaultHttpClient();
				HttpGet httpGet = new HttpGet(MyConstant.URL + "board.do?method=getall");
				try {
					HttpResponse httpResponse = httpClient.execute(httpGet);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						HttpEntity resEntity = httpResponse.getEntity();
						String response = EntityUtils.toString(resEntity, "utf-8");
						Message message = new Message();
						message.what = SHOW_RESPONSE2;
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
		lv_board=(ListView) findViewById(R.id.lv_board);
	};

	
	public OnClickListener reback1=new OnClickListener() {
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				BoardActivity.this.finish();
			}
		};
		
		public OnClickListener set1=new OnClickListener() {
			//主界面→设置界面
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(); 
				intent.putExtra("userID", userID);
		        intent.setClass(BoardActivity.this, SetActivity.class); 
		        BoardActivity.this.startActivity(intent);
				}
			};
}
