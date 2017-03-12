package cn.edu.scu.tmooc.adapter;

import java.util.List;

import cn.edu.scu.tmooc.R;
import cn.edu.scu.tmooc.TestpaperActivity;
import cn.edu.scu.tmooc.entity.Test;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TestAdapter extends ArrayAdapter<Test> {

	protected static final int SHOW_RESPONSE = 0;
	private int resourceId;
	private Context context;
	

	
	public TestAdapter(Context context, int textViewResourceId, List<Test> objects) {
		super(context, textViewResourceId, objects);
		this.resourceId = textViewResourceId;
		this.context = context;

	}


     
	
	public View getView(final int position, View convertView, ViewGroup parent) {
		// 获取当前对象
		final Test test = getItem(position);
		System.out.print(position);
		// 加载布局文件
		View view = null;
		ViewHolder viewHolder = null;
		//final TextView tv_test = (TextView)view.findViewById(R.id.testid);
		
		if (convertView == null) {
			view = LayoutInflater.from(context).inflate(resourceId, null);
			
			viewHolder = new ViewHolder();
			viewHolder.testid = (TextView) view.findViewById(R.id.testid);
			viewHolder.papername = (TextView) view.findViewById(R.id.papename);
			viewHolder.begintest = (Button) view.findViewById(R.id.begintest);
			viewHolder.testanswer = (Button) view.findViewById(R.id.testanswer);	
			
			view.setTag(viewHolder); // 将ViewHolder存储在View中
		} else {
			
			view = convertView;
			viewHolder = (ViewHolder) view.getTag(); // 重新获取ViewHolder
		}
		

		// 获取TextView控件
		Log.i("test", test+"");
		viewHolder.testid.setText(test.getPaperid()+"");
		viewHolder.papername.setText(test.getPapername());
		viewHolder.begintest.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				//Toast.makeText(getContext(), test.getStudentid()+"", Toast.LENGTH_SHORT).show();
		    	Intent intent = new Intent(context, TestpaperActivity.class);
		    	intent.putExtra("userID", test.getStudentid()+"");
		    	intent.putExtra("Message", test.getPaperid()+"");
		    	intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);  
		    	context.startActivity(intent);
			}
		});

		return view;
	}
	
	public static class ViewHolder {
		private TextView testid;
		private TextView papername;
		private Button begintest;
		private Button testanswer;
	}

}