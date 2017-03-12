package cn.edu.scu.tmooc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Set_phonenumber extends Activity implements View.OnClickListener {
	private EditText numberet;
	private TextView textview;
	private Button reback;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.set_phonenumber);
		reback = (Button) findViewById(R.id.reback);
		reback.setOnClickListener(reback1);
		findViewById(R.id.button1).setOnClickListener(this);
    	numberet = (EditText) findViewById(R.id.numberet);
    	textview = (TextView) findViewById(R.id.textview);
    	Exit.getInstance().addActivity(this);
	}
	public void onClick(View v) {
		textview.setText(numberet.getText()); // !
	}
	public OnClickListener reback1=new OnClickListener() {
		
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Set_phonenumber.this.finish();
     
           
		}
		

	};
}