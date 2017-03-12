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
	 * 我们新增了一个内部类ViewHolder，用于对控件的实例进行缓存。当convertView 为空
的时候，创建一个ViewHolder 对象，并将控件的实例都存放在ViewHolder 里，然后调用View
的setTag()方法，将ViewHolder 对象存储在View 中。当convertView 不为空的时候则调用
View 的getTag()方法，把ViewHolder 重新取出。这样所有控件的实例都缓存在了ViewHolder
里，就没有必要每次都通过findViewById()方法来获取控件实例了。
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// 获取当前Fruit对象
		final Forum forum = getItem(position);
		// 加载布局文件
		View view = null;
		ViewHolder viewHolder = null;
		
		if (convertView == null) {
			view = LayoutInflater.from(context).inflate(resourceId, null);
			viewHolder = new ViewHolder();
		
			viewHolder.forumname = (TextView) view.findViewById(R.id.tv_forumname);
			viewHolder.studentid = (TextView) view.findViewById(R.id.tv_studentid);
			viewHolder.foruminformation = (TextView) view.findViewById(R.id.tv_foruminformation);
			viewHolder.forumdate= (TextView) view.findViewById(R.id.tv_forumdate);
			
			view.setTag(viewHolder); // 将ViewHolder存储在View中
			
		} else {
			
			view = convertView;
			viewHolder = (ViewHolder) view.getTag(); // 重新获取ViewHolder
			
		}
		
		// 设置ImageView的图片
		
		// 获取TextView控件
		viewHolder.forumname.setText(forum.getForumname());
		viewHolder.studentid.setText(""+forum.getStudentid());
		viewHolder.foruminformation.setText(forum.getForuminformation());
		viewHolder.forumdate.setText(DateUtil.date2Str(forum.getForumdate()));
		
		return view;
	}

	/***
	 * 可以看到，现在我们在getView()方法中进行了判断，如果convertView 为空，则使用 LayoutInflater
	 * 去加载布局，如果不为空则直接对convertView 进行重用。这样就大大提高了 ListView
	 * 的运行效率，在快速滚动的时候也可以表现出更好的性能。
	 */

	

	private static class ViewHolder {
		
		private TextView forumname;
		private TextView studentid;
		private TextView foruminformation;
		private TextView forumdate;
		private Button sendthisforum;
	}
}

