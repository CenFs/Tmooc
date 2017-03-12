package cn.edu.scu.tmooc;

import android.app.Activity;
import android.os.Bundle;

public class ExitActivity extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Exit.getInstance().addActivity(this);
		Exit.getInstance().exit(this);
	}
}
