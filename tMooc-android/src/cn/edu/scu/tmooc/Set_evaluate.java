package cn.edu.scu.tmooc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;

public class Set_evaluate extends Activity{
	RatingBar rb;
	TextView tv;
	private Button reback;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.set_evaluate);
		reback = (Button) findViewById(R.id.reback);
		reback.setOnClickListener(reback1);
		tv=(TextView)findViewById(R.id.tv);
        rb=(RatingBar)findViewById(R.id.rb);
        rb.setNumStars(5);
        rb.setRating(3);   
        rb.setOnRatingBarChangeListener(rbLis);
        //定义一个监听器
        Exit.getInstance().addActivity(this);
	}
	 private OnRatingBarChangeListener rbLis=new OnRatingBarChangeListener(){
		 
			@Override
			public void onRatingChanged(RatingBar ratingBar, float rating,
					boolean fromUser) {
				tv.setText(String.valueOf(rb.getRating()));
				//输出评分
			}
	 
	    };
	public void btn_back(View v) {                                   
		Set_evaluate.this.finish();	
	}
	public OnClickListener reback1=new OnClickListener() {
		
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Set_evaluate.this.finish();
     
           
		}
		

	};
}
