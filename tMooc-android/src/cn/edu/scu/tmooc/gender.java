package cn.edu.scu.tmooc;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;


	public class gender extends Activity {
		public RadioGroup gendergroup;
		public RadioButton radiobutton2;
		public RadioButton radiobutton3;
		private Button login_reback_btn;
		 @Override
		 protected void onCreate(Bundle savedInstanceState) {
		  super.onCreate(savedInstanceState);
		  setContentView(R.layout.gender);
		  
		  login_reback_btn = (Button) findViewById(R.id.login_reback_btn);
		  login_reback_btn.setOnClickListener(listener);
		  
		  gendergroup = (RadioGroup) findViewById(R.id.gendergroup);
		  radiobutton2 = (RadioButton) findViewById(R.id.radiobutton2);
		  radiobutton3 = (RadioButton) findViewById(R.id.radiobutton3);
		  gendergroup.setOnCheckedChangeListener(radiogpchange);
		  
		  Exit.getInstance().addActivity(this);

		 }

		 private RadioGroup.OnCheckedChangeListener radiogpchange = new RadioGroup.OnCheckedChangeListener() {
		  @Override
		
		  public void onCheckedChanged(RadioGroup group, int checkedId) {
			  DialogInterface.OnClickListener ss = new DialogInterface.OnClickListener(){
				  public void onClick(DialogInterface dialog,
							int which) {
						// TODO Auto-generated method stub
						Intent in = new Intent();
						in.setClass(gender.this,
								SetActivity.class);
						startActivity(in);
						gender.this.onDestroy();
					}
				};  
		   if (checkedId == radiobutton3.getId()) {
		   
		    new AlertDialog.Builder(gender.this)
			.setTitle("选择性别成功！").setMessage("您选择的性别为：女性")
			.setPositiveButton("确认", ss).show();
		   } else if (checkedId == radiobutton2.getId()) {
		    
		    new AlertDialog.Builder(gender.this)
			.setTitle("选择性别成功！").setMessage("您选择的性别为：男性")
			.setPositiveButton("确认", ss).show();
		   }
		  }
		 };
		 public OnClickListener listener=new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(); 
		            intent.setClass(gender.this,SetActivity.class); 
		            gender.this.startActivity(intent);
		     
		           
				}
			};
	}


	







