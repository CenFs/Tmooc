package cn.edu.scu.tmooc.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import cn.edu.scu.tmooc.adapter.BoarddetailAdapter.ViewHolder;
import cn.edu.scu.tmooc.entity.Board;
import cn.edu.scu.tmooc.util.DateUtil;
import cn.edu.scu.tmooc.R;
import android.widget.ArrayAdapter;

public class BoarddetailAdapter extends ArrayAdapter<Board> {
	
	private int resourceId;
	private Context context;
	public BoarddetailAdapter(Context context, int textViewResourceId, List<Board> objects) {
		super(context, textViewResourceId, objects);
		this.resourceId = textViewResourceId;
		this.context = context;
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		// 获取当前Fruit对象
		final Board board = getItem(position);
		// 加载布局文件
		View view = null;
		ViewHolder viewHolder = null;
		//我们用getView()方法进行了判断，如果convertVie为空，则使用LayoutInflater去加载布局，如果不为空则直接对convertView进行重用，提高效率
		if (convertView == null) {
			view = LayoutInflater.from(context).inflate(resourceId, null);
			viewHolder = new ViewHolder();
			viewHolder.boardid = (TextView) view.findViewById(R.id.tv_boardid);
			viewHolder.boardtitle = (TextView) view.findViewById(R.id.tv_boardtitle);
			viewHolder.boardtext = (TextView) view.findViewById(R.id.tv_boardtext);
			viewHolder.date = (TextView) view.findViewById(R.id.tv_boarddate);			
			
			view.setTag(viewHolder); // 将ViewHolder存储在View中
		} else {
			view = convertView;
			viewHolder = (ViewHolder) view.getTag(); // 重新获取ViewHolder
		}
		

		// 获取TextView控件
		viewHolder.boardid.setText(board.getBoardid()+"");
		viewHolder.boardtitle.setText(board.getTitle());
		viewHolder.boardtext.setText(board.getText());
	//	viewHolder.date.setText(board.getDate());
		viewHolder.date.setText(DateUtil.date2Str(board.getDate()));
		return view;
	}
	
	public static class ViewHolder {
		private TextView boardid;
		private TextView boardtitle;
		private TextView boardtext;
		private TextView date;
	}

}
