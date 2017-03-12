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
		// ��ȡ��ǰFruit����
		final Testanswer testanswer = getItem(position);
		// ���ز����ļ�
		View view = null;
		ViewHolder viewHolder = null;
		//������getView()�����������жϣ����convertVieΪ�գ���ʹ��LayoutInflaterȥ���ز��֣������Ϊ����ֱ�Ӷ�convertView�������ã����Ч��
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
			view.setTag(viewHolder); // ��ViewHolder�洢��View��
		} else {
			view = convertView;
			viewHolder = (ViewHolder) view.getTag(); // ���»�ȡViewHolder
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

		// ��ȡTextView�ؼ�
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
