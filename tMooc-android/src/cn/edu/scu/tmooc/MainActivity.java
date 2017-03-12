package cn.edu.scu.tmooc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	
	private Button btn_board,btn_class,btn_forum,btn_test,btn_note,set;
	private String userID = null;
	
	protected void onCreate(Bundle savedInstanceState) {
		
	   super.onCreate(savedInstanceState);
	   setContentView(R.layout.activity_main);
	   
	   Intent intent = getIntent();
	   userID = intent.getStringExtra("userID");
	   
	   btn_board = (Button)findViewById(R.id.btn_board);
	   btn_board.setOnClickListener(board);
	   btn_class = (Button)findViewById(R.id.btn_class);
	   btn_class.setOnClickListener(course);
	   btn_forum = (Button)findViewById(R.id.btn_forum);
	   btn_forum.setOnClickListener(forum);
	   btn_test = (Button)findViewById(R.id.btn_test);
	   btn_test.setOnClickListener(test);
	   btn_note = (Button)findViewById(R.id.btn_note);
	   btn_note.setOnClickListener(note);
	   set = (Button)findViewById(R.id.set);
	   set.setOnClickListener(set1);
	   
	   Exit.getInstance().addActivity(this);
}
	
	public OnClickListener board = new OnClickListener() {
		//登录界面→通知公告界面
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent intent = new Intent(); 
			intent.putExtra("userID", userID);
            intent.setClass(MainActivity.this, BoardActivity.class);  
            MainActivity.this.startActivity(intent);
		}
	};
	
	public OnClickListener course = new OnClickListener() {
		//登录界面→选课界面
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();  
			intent.putExtra("userID", userID);
            intent.setClass(MainActivity.this, CourseActivity.class); 
            MainActivity.this.startActivity(intent);
		}
	};
	
	public OnClickListener forum = new OnClickListener() {
		//登录界面→论坛界面
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent intent = new Intent(); 
			intent.putExtra("userID", userID);
            intent.setClass(MainActivity.this, ForumListActivity.class); 
            MainActivity.this.startActivity(intent);
		}
	};
	
	public OnClickListener test = new OnClickListener() {
		//登录界面→在线测试界面
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();  
			intent.putExtra("userID", userID);
            intent.setClass(MainActivity.this, TestActivity.class); 
            MainActivity.this.startActivity(intent);
		}
	};
	
	public OnClickListener note = new OnClickListener() {
		//登录界面→日记界面
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();  
			intent.putExtra("userID", userID);
			//intent.putExtra("refresh", "no");
            intent.setClass(MainActivity.this, NoteActivity.class); 
            MainActivity.this.startActivity(intent);
		}
	};
	
	public OnClickListener set1 = new OnClickListener() {
		//主界面→设置界面
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent intent = new Intent(); 
			intent.putExtra("userID", userID);
		    intent.setClass(MainActivity.this, SetActivity.class); 
		    MainActivity.this.startActivity(intent);
		}
	};
}