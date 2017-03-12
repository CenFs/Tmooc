package cn.edu.scu.tmooc.adapter;

import java.util.List;

import cn.edu.scu.tmooc.R;
import cn.edu.scu.tmooc.entity.Forum;
import cn.edu.scu.tmooc.util.DateUtil;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

public class ForumAdapter extends ArrayAdapter<Forum> {

	private int resourceId;
	private Context context;

	public ForumAdapter(Context context, int textViewResourceId,
			List<Forum> objects) {
		super(context, textViewResourceId, objects);
		this.resourceId = textViewResourceId;
		this.context = context;
	}

	/**
	 * ����������һ���ڲ���ViewHolder�����ڶԿؼ���ʵ�����л��档��convertView Ϊ��
��ʱ�򣬴���һ��ViewHolder ���󣬲����ؼ���ʵ���������ViewHolder �Ȼ�����View
��setTag()��������ViewHolder ����洢��View �С���convertView ��Ϊ�յ�ʱ�������
View ��getTag()��������ViewHolder ����ȡ�����������пؼ���ʵ������������ViewHolder
���û�б�Ҫÿ�ζ�ͨ��findViewById()��������ȡ�ؼ�ʵ���ˡ�
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// ��ȡ��ǰFruit����
		final Forum forum = getItem(position);
		// ���ز����ļ�
		View view = null;
		ViewHolder viewHolder = null;
		
		if (convertView == null) {
			view = LayoutInflater.from(context).inflate(resourceId, null);
			viewHolder = new ViewHolder();
		
			viewHolder.forumname = (TextView) view.findViewById(R.id.tv_forumname);
			viewHolder.studentid = (TextView) view.findViewById(R.id.tv_studentid);
			viewHolder.foruminformation = (TextView) view.findViewById(R.id.tv_foruminformation);
			viewHolder.forumdate= (TextView) view.findViewById(R.id.tv_forumdate);
			
			view.setTag(viewHolder); // ��ViewHolder�洢��View��
			
		} else {
			
			view = convertView;
			viewHolder = (ViewHolder) view.getTag(); // ���»�ȡViewHolder
			
		}
		
		// ����ImageView��ͼƬ
		
		// ��ȡTextView�ؼ�
		viewHolder.forumname.setText(forum.getForumname());
		viewHolder.studentid.setText(""+forum.getStudentid());
		viewHolder.foruminformation.setText(forum.getForuminformation());
		viewHolder.forumdate.setText(DateUtil.date2Str(forum.getForumdate()));
		
		return view;
	}

	/***
	 * ���Կ���������������getView()�����н������жϣ����convertView Ϊ�գ���ʹ�� LayoutInflater
	 * ȥ���ز��֣������Ϊ����ֱ�Ӷ�convertView �������á������ʹ������� ListView
	 * ������Ч�ʣ��ڿ��ٹ�����ʱ��Ҳ���Ա��ֳ����õ����ܡ�
	 */

	

	private static class ViewHolder {
		
		private TextView forumname;
		private TextView studentid;
		private TextView foruminformation;
		private TextView forumdate;
		private Button sendthisforum;
	}
}

