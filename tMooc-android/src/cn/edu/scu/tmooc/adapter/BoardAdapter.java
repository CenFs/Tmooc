package cn.edu.scu.tmooc.adapter;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import cn.edu.scu.tmooc.entity.Board;
import cn.edu.scu.tmooc.util.DateUtil;
import cn.edu.scu.tmooc.BoarddetailActivity;
import cn.edu.scu.tmooc.R;

public class BoardAdapter extends ArrayAdapter<Board> {
	protected static final int SHOW_RESPONSE6 = 0;
	private int resourceId;
	private Context context;
	public BoardAdapter(Context context, int textViewResourceId, List<Board> objects) {
		super(context, textViewResourceId, objects);
		this.resourceId = textViewResourceId;
		this.context = context;
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		// 获取当前Fruit对象
		final Board board = getItem(position);
		System.out.print(position);
		// 加载布局文件
		View view = null;
		ViewHolder viewHolder = null;
		//我们用getView()方法进行了判断，如果convertVie为空，则使用LayoutInflater去加载布局，如果不为空则直接对convertView进行重用，提高效率
		if (convertView == null) {
			view = LayoutInflater.from(context).inflate(resourceId, null);
			viewHolder = new ViewHolder();
			viewHolder.boardid = (TextView) view.findViewById(R.id.tv_boardid);
			viewHolder.boardtitle = (TextView) view.findViewById(R.id.tv_boardtitle);
			viewHolder.date = (TextView) view.findViewById(R.id.tv_boarddate);	
			viewHolder.button1 = (Button) view.findViewById(R.id.button1);
			
			view.setTag(viewHolder); // 将ViewHolder存储在View中
		} else {
			view = convertView;
			viewHolder = (ViewHolder) view.getTag(); // 重新获取ViewHolder
		}
		

		// 获取TextView控件
		Log.i("board", board+"");
		viewHolder.boardid.setText(board.getBoardid()+"");
		viewHolder.boardtitle.setText(board.getTitle());
		viewHolder.date.setText(DateUtil.date2Str(board.getDate()));
        viewHolder.button1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
		    	//定义意图对象
		    	Intent intent=new Intent(context, BoarddetailActivity.class);
		    	intent.putExtra("Message",board.getBoardid()+"");
		    	intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);  
		    	context.startActivity(intent);
			}
		});
		return view;
	}
	
	public static class ViewHolder {
		private TextView boardid;
		private TextView boardtitle;
		private Button button1;
		private TextView date;
	}

}
