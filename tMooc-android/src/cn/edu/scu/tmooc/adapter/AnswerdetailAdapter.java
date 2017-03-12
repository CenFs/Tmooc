package cn.edu.scu.tmooc.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import cn.edu.scu.tmooc.entity.Testanswer;
import cn.edu.scu.tmooc.R;

public class AnswerdetailAdapter extends ArrayAdapter<Testanswer> {
	
	private int resourceId;
	private Context context;
	public AnswerdetailAdapter(Context context, int textViewResourceId, List<Testanswer> objects) {
		super(context, textViewResourceId, objects);
		this.resourceId = textViewResourceId;
		this.context = context;
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		// 获取当前Fruit对象
		final Testanswer testanswer = getItem(position);
		// 加载布局文件
		View view = null;
		ViewHolder viewHolder = null;
		//我们用getView()方法进行了判断，如果convertVie为空，则使用LayoutInflater去加载布局，如果不为空则直接对convertView进行重用，提高效率
		if (convertView == null) {
			view = LayoutInflater.from(context).inflate(resourceId, null);
			viewHolder = new ViewHolder();
			
			viewHolder.courseid = (TextView) view.findViewById(R.id.tv_courseid);
			viewHolder.paperid = (TextView) view.findViewById(R.id.tv_paperid);
			viewHolder.answerpaperid = (TextView) view.findViewById(R.id.tv_answerpaperid);
			viewHolder.studentid = (TextView) view.findViewById(R.id.tv_studentid);			
			viewHolder.score = (TextView) view.findViewById(R.id.tv_score);
			viewHolder.answer = (TextView) view.findViewById(R.id.tv_answer);
			viewHolder.teacherid = (TextView) view.findViewById(R.id.tv_teacherid);	
			view.setTag(viewHolder); // 将ViewHolder存储在View中
		} else {
			view = convertView;
			viewHolder = (ViewHolder) view.getTag(); // 重新获取ViewHolder
		}
		/**
		 * 
int courseid;
	int paperid; 
	int answerpaperid;
	int studentid; 
	float score; 
	String answer; 
	int teacherid;

		 */

		// 获取TextView控件
		viewHolder.courseid.setText(testanswer.getCourseid()+"");
		viewHolder.paperid.setText(testanswer.getPaperid()+"");
		viewHolder.answerpaperid.setText(testanswer.getAnswerpaperid()+"");
		viewHolder.studentid.setText(testanswer.getStudentid()+"");
		viewHolder.score.setText(testanswer.getScore()+"");
		viewHolder.answer.setText(testanswer.getAnswer());
		viewHolder.teacherid.setText(testanswer.getTeacherid()+"");
	
		return view;
	}
	
	public static class ViewHolder {
		private TextView courseid;
		private TextView paperid;
		private TextView answerpaperid;
		private TextView studentid;
		private TextView score;
		private TextView answer;
		private TextView teacherid;
	}

}
