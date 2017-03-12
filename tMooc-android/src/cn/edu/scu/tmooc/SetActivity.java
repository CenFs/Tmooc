package cn.edu.scu.tmooc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SetActivity extends Activity {
	private Button reback,btn_exit;
	String studentid = "61234";
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_set);
		
		Intent intent = getIntent();
		studentid = intent.getStringExtra("userID");
		
		btn_exit = (Button)findViewById(R.id.btn_exit);
		btn_exit.setOnClickListener(exit1);
		reback = (Button)findViewById(R.id.reback);
		reback.setOnClickListener(reback1);
		Exit.getInstance().addActivity(this);
	}
	
	public OnClickListener exit1 = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent intent = new Intent(); 
		    intent.setClass(SetActivity.this, ExitActivity.class); 
		    SetActivity.this.startActivity(intent);
		    SetActivity.this.finish();
			
		}
	};
	
	public void changgepassword(View v) {                                   
		Intent intent = new Intent();   
		//Toast.makeText(this, "test", Toast.LENGTH_SHORT).show();
        intent.setClass(SetActivity.this, DateTime.class);    
        SetActivity.this.startActivity(intent);
	}
	public void phonenumber(View v) {                                   
		Intent intent = new Intent();   
        intent.setClass(SetActivity.this, Set_phonenumber.class);    
        SetActivity.this.startActivity(intent);
	}
	public void email(View v) {                                   
		Intent intent = new Intent();   
        intent.setClass(SetActivity.this, gender.class);    
        SetActivity.this.startActivity(intent);
	}
	public void pingjia(View v) {                                   
		Intent intent = new Intent();   
        intent.setClass(SetActivity.this, Set_evaluate.class);    
        SetActivity.this.startActivity(intent);
	}
	public void introduce(View v) {                                   
		Intent intent = new Intent();   
        intent.setClass(SetActivity.this, Set_introduce.class);    
        SetActivity.this.startActivity(intent);
	}
	public void fankui(View v) {                                   
		Intent intent = new Intent();   
        intent.setClass(SetActivity.this, Set_feedback.class);    
        SetActivity.this.startActivity(intent);
	}
	public void aboutus(View v) {                                   
		Intent intent = new Intent();   
        intent.setClass(SetActivity.this, Set_aboutus.class);    
        SetActivity.this.startActivity(intent);
	}
	
	public OnClickListener reback1 = new OnClickListener() {
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent intent = new Intent(); 
			intent.putExtra("userID", studentid);
	        intent.setClass(SetActivity.this, MainActivity.class); 
	        SetActivity.this.startActivity(intent);
	        SetActivity.this.finish();
		}
	};
}
