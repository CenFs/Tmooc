package cn.edu.scu.tmooc.adapter;

import java.util.List;

import cn.edu.scu.tmooc.CoursedetailActivity;
import cn.edu.scu.tmooc.R;
import cn.edu.scu.tmooc.entity.Course;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

public class CourseAdapter extends ArrayAdapter<Course> {
	protected static final int SHOW_RESPONSE8 = 0;
	private int resourceId;
	private Context context;

	public CourseAdapter(Context context, int textViewResourceId,
			List<Course> objects) {
		super(context, textViewResourceId, objects);
		this.resourceId = textViewResourceId;
		this.context = context;
	}


	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// 获取当前Fruit对象
		final Course course = getItem(position);
		System.out.print(position);
		// 加载布局文件
		View view = null;
		ViewHolder viewHolder = null;
		if (convertView == null) {
			view = LayoutInflater.from(context).inflate(resourceId, null);
			viewHolder = new ViewHolder();
			viewHolder.courseid = (TextView) view.findViewById(R.id.tv_courseid);
			viewHolder.coursename = (TextView) view.findViewById(R.id.tv_coursename);
			viewHolder.coursedetail = (Button) view.findViewById(R.id.coursedetail);
			view.setTag(viewHolder); // 将ViewHolder存储在View中
		} else {
			view = convertView;
			viewHolder = (ViewHolder) view.getTag(); // 重新获取ViewHolder
		}
		
		// 获取TextView控件
		Log.i("course", course+"");
		viewHolder.courseid.setText(course.getCourseid()+"");
		viewHolder.coursename.setText(course.getCoursename());
		viewHolder.coursedetail.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					//Toast.makeText(getContext(), test.getPaperid()+"", Toast.LENGTH_SHORT).show();

			    	//定义意图对象
			    	Intent intent = new Intent(context, CoursedetailActivity.class);
			    	//将传送数据封装到Intent对象中
			    	intent.putExtra("Message",course.getCourseid()+"");
			    	intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);  
			    	//开启新的Activity
			    	context.startActivity(intent);
					
				}
			});
		return view;
	}

	/***
	 * 可以看到，现在我们在getView()方法中进行了判断，如果convertView 为空，则使用 LayoutInflater
	 * 去加载布局，如果不为空则直接对convertView 进行重用。这样就大大提高了 ListView
	 * 的运行效率，在快速滚动的时候也可以表现出更好的性能。
	 */

	

	private static class ViewHolder {
		private TextView courseid;
		private TextView coursename;
		private Button coursedetail;
	}
}

