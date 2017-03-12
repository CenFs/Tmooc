package cn.edu.scu.tmooc.adapter;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import cn.edu.scu.tmooc.DataActivity;
import cn.edu.scu.tmooc.R;
import cn.edu.scu.tmooc.entity.Course;

public class CoursedetailAdapter extends ArrayAdapter<Course> {

	private int resourceId;
	private Context context;
	public CoursedetailAdapter(Context context, int textViewResourceId, List<Course> objects) {
		super(context, textViewResourceId, objects);
		this.resourceId = textViewResourceId;
		this.context = context;
	}
	/**
	 * private int courseid;
	private String coursename;
	private String teachername;
	private int teacherid;
	private int coursetype;
	private int studentnum;
	 */
	public View getView(int position, View convertView, ViewGroup parent) {
		// 获取当前Fruit对象
		final Course course = getItem(position);
		// 加载布局文件
		View view = null;
		ViewHolder viewHolder = null;
		//我们用getView()方法进行了判断，如果convertVie为空，则使用LayoutInflater去加载布局，如果不为空则直接对convertView进行重用，提高效率
		if (convertView == null) {
			view = LayoutInflater.from(context).inflate(resourceId, null);
			viewHolder = new ViewHolder();
			viewHolder.courseid = (TextView) view.findViewById(R.id.tv_courseid);
			viewHolder.coursename = (TextView) view.findViewById(R.id.tv_coursename);
			viewHolder.teachername = (TextView) view.findViewById(R.id.tv_teachername);
			viewHolder.teacherid = (TextView) view.findViewById(R.id.tv_teacherid);	
			viewHolder.coursetype = (TextView) view.findViewById(R.id.tv_coursetype);
			viewHolder.studentnum = (TextView) view.findViewById(R.id.tv_studentnum);
			viewHolder.datalist = (Button) view.findViewById(R.id.btn_datalist);
			
			view.setTag(viewHolder); // 将ViewHolder存储在View中
		} else {
			view = convertView;
			viewHolder = (ViewHolder) view.getTag(); // 重新获取ViewHolder
		}
		

		// 获取TextView控件
		viewHolder.courseid.setText(course.getCourseid()+"");
		viewHolder.coursename.setText(course.getCoursename());
		viewHolder.teachername.setText(course.getTeachername());
		viewHolder.teacherid.setText(course.getTeacherid()+"");
		viewHolder.coursetype.setText(course.getCoursetype()+"");
		viewHolder.studentnum.setText(course.getStudentnum()+"");
		viewHolder.datalist.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(context, DataActivity.class);
				intent.putExtra("courseid", course.getCourseid()+"");
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);  
		    	context.startActivity(intent);
			}
		});
		
		return view;
	}
	
	public static class ViewHolder {
		private TextView courseid;
		private TextView coursename;
		private TextView teachername;
		private TextView teacherid;
		private TextView coursetype;
		private TextView studentnum;
		private Button datalist;
	}

}
