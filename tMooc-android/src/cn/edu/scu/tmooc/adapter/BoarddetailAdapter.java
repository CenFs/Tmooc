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
		// ��ȡ��ǰFruit����
		final Board board = getItem(position);
		// ���ز����ļ�
		View view = null;
		ViewHolder viewHolder = null;
		//������getView()�����������жϣ����convertVieΪ�գ���ʹ��LayoutInflaterȥ���ز��֣������Ϊ����ֱ�Ӷ�convertView�������ã����Ч��
		if (convertView == null) {
			view = LayoutInflater.from(context).inflate(resourceId, null);
			viewHolder = new ViewHolder();
			viewHolder.boardid = (TextView) view.findViewById(R.id.tv_boardid);
			viewHolder.boardtitle = (TextView) view.findViewById(R.id.tv_boardtitle);
			viewHolder.boardtext = (TextView) view.findViewById(R.id.tv_boardtext);
			viewHolder.date = (TextView) view.findViewById(R.id.tv_boarddate);			
			
			view.setTag(viewHolder); // ��ViewHolder�洢��View��
		} else {
			view = convertView;
			viewHolder = (ViewHolder) view.getTag(); // ���»�ȡViewHolder
		}
		

		// ��ȡTextView�ؼ�
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
