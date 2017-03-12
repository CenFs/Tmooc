package cn.edu.scu.tmooc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Set_changgepassword extends Activity{
	Button reback,bt1;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.set_changgepassword);
		reback = (Button)findViewById(R.id.reback);
		reback.setOnClickListener(reback1);
		bt1 = (Button)findViewById(R.id.button1);
		bt1.setOnClickListener(listener1);
		Exit.getInstance().addActivity(this);
	}
public OnClickListener reback1=new OnClickListener() {
		
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
	        Set_changgepassword.this.finish();
     
           
		}
		

	};
public OnClickListener listener1=new OnClickListener() {
		
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
	        Set_changgepassword.this.finish();
     
           
		}
		

	};
}
