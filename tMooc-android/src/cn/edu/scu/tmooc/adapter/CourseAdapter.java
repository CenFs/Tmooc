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
		// ��ȡ��ǰFruit����
		final Course course = getItem(position);
		System.out.print(position);
		// ���ز����ļ�
		View view = null;
		ViewHolder viewHolder = null;
		if (convertView == null) {
			view = LayoutInflater.from(context).inflate(resourceId, null);
			viewHolder = new ViewHolder();
			viewHolder.courseid = (TextView) view.findViewById(R.id.tv_courseid);
			viewHolder.coursename = (TextView) view.findViewById(R.id.tv_coursename);
			viewHolder.coursedetail = (Button) view.findViewById(R.id.coursedetail);
			view.setTag(viewHolder); // ��ViewHolder�洢��View��
		} else {
			view = convertView;
			viewHolder = (ViewHolder) view.getTag(); // ���»�ȡViewHolder
		}
		
		// ��ȡTextView�ؼ�
		Log.i("course", course+"");
		viewHolder.courseid.setText(course.getCourseid()+"");
		viewHolder.coursename.setText(course.getCoursename());
		viewHolder.coursedetail.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					//Toast.makeText(getContext(), test.getPaperid()+"", Toast.LENGTH_SHORT).show();

			    	//������ͼ����
			    	Intent intent = new Intent(context, CoursedetailActivity.class);
			    	//���������ݷ�װ��Intent������
			    	intent.putExtra("Message",course.getCourseid()+"");
			    	intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);  
			    	//�����µ�Activity
			    	context.startActivity(intent);
					
				}
			});
		return view;
	}

	/***
	 * ���Կ���������������getView()�����н������жϣ����convertView Ϊ�գ���ʹ�� LayoutInflater
	 * ȥ���ز��֣������Ϊ����ֱ�Ӷ�convertView �������á������ʹ������� ListView
	 * ������Ч�ʣ��ڿ��ٹ�����ʱ��Ҳ���Ա��ֳ����õ����ܡ�
	 */

	

	private static class ViewHolder {
		private TextView courseid;
		private TextView coursename;
		private Button coursedetail;
	}
}

