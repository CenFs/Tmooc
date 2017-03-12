package cn.edu.scu.tmooc;
import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
 
public class DateTime extends Activity {
 
	private TextView tvDisplayDate;
	private DatePicker dpResult;
	private Button btnChangeDate;
 
	private int year;
	private int month;
	private int day;
	private Button login_reback_btn;
	static final int DATE_DIALOG_ID = 999;
 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.birth);
		
		login_reback_btn = (Button) findViewById(R.id.login_reback_btn);
		login_reback_btn.setOnClickListener(listener);
		
		setCurrentDateOnView();
		addListenerOnButton();
 
		Exit.getInstance().addActivity(this);
		
	}
 
	// display current date
	public void setCurrentDateOnView() {
 
		tvDisplayDate = (TextView) findViewById(R.id.tvDate);
		dpResult = (DatePicker) findViewById(R.id.dpResult);
 
		final Calendar c = Calendar.getInstance();
		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH);
		day = c.get(Calendar.DAY_OF_MONTH);
 
		// set current date into textview
		tvDisplayDate.setText(new StringBuilder()
			// Month is 0 based, just add 1
			.append(month + 1).append("-").append(day).append("-")
			.append(year).append(" "));
		tvDisplayDate.setTextColor(Color.BLACK); 
		// set current date into datepicker
		dpResult.init(year, month, day, null);
 
	}
 
	public void addListenerOnButton() {
 
		btnChangeDate = (Button) findViewById(R.id.btnChangeDate);
 
		btnChangeDate.setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View v) {
 
				showDialog(DATE_DIALOG_ID);
 
			}
 
		});
 
	}
 
	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case DATE_DIALOG_ID:
		   // set date picker as current date
		   return new DatePickerDialog(this, datePickerListener, 
                         year, month,day);
		}
		return null;
	}
 
	private DatePickerDialog.OnDateSetListener datePickerListener 
                = new DatePickerDialog.OnDateSetListener() {
 
		// when dialog box is closed, below method will be called.
		public void onDateSet(DatePicker view, int selectedYear,
				int selectedMonth, int selectedDay) {
			year = selectedYear;
			month = selectedMonth;
			day = selectedDay;
 
			// set selected date into textview
			tvDisplayDate.setText(new StringBuilder().append(month + 1)
			   .append("-").append(day).append("-").append(year)
			   .append(" "));
			tvDisplayDate.setTextColor(Color.BLACK); 
			// set selected date into datepicker also
			dpResult.init(year, month, day, null);
 
		}
	};
	public OnClickListener listener=new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();  
            //鍦↖ntent瀵硅薄褰撲腑娣诲姞涓�涓敭鍊煎  
            //璁剧疆Intent瀵硅薄瑕佸惎鍔ㄧ殑Activity   
            intent.setClass(DateTime.this,SetActivity.class);  
            //閫氳繃Intent瀵硅薄鍚姩鍙﹀涓�涓狝ctivity   
            DateTime.this.startActivity(intent);
     
           
		}
	};
}