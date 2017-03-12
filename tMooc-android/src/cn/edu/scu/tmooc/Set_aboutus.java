package cn.edu.scu.tmooc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class Set_aboutus extends Activity{
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.set_aboutus);
		Exit.getInstance().addActivity(this);
	}
	public void btn_back(View v) {                                   //�ֻ�ҡһҡ
		Set_aboutus.this.finish();	
	}

}
