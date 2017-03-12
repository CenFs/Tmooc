package cn.edu.scu.tmooc.adapter;

import java.util.List;

import cn.edu.scu.tmooc.R;
import cn.edu.scu.tmooc.entity.Test;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class TestpaperAdapter extends ArrayAdapter<Test> {

	private int resourceId;
	private Context context;
	
	public TestpaperAdapter(Context context, int textViewResourceId, List<Test> objects) {
		super(context, textViewResourceId, objects);
		this.resourceId = textViewResourceId;
		this.context = context;
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		final Test test = getItem(position);
		View view = null;
		ViewHolder viewHolder = null;
		if (convertView == null) {
			view = LayoutInflater.from(context).inflate(resourceId, null);
			viewHolder = new ViewHolder();
			viewHolder.question = (TextView) view.findViewById(R.id.tv_question);
			viewHolder.option1= (TextView) view.findViewById(R.id.tv_option1);	
			viewHolder.option2= (TextView) view.findViewById(R.id.tv_option2);	
			viewHolder.option3= (TextView) view.findViewById(R.id.tv_option3);	
			viewHolder.option4= (TextView) view.findViewById(R.id.tv_option4);
			//viewHolder.answer = (EditText) view.findViewById(R.id.et_answer);
			//viewHolder.endtest = (Button) view.findViewById(R.id.btn_endtest);
			view.setTag(viewHolder); // 将ViewHolder存储在View中
		} else {
			view = convertView;
			viewHolder = (ViewHolder) view.getTag(); // 重新获取ViewHolder
		}
		

		// 获取TextView控件
		viewHolder.question.setText(test.getQuestion());
		viewHolder.option1.setText(test.getOption1());
		viewHolder.option2.setText(test.getOption2());
		viewHolder.option3.setText(test.getOption3());
		viewHolder.option4.setText(test.getOption4());
		/*viewHolder.endtest.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View arg0) {
				Toast.makeText(getContext(), test.getPaperid()+"", Toast.LENGTH_SHORT).show();
			}
		});
		*/
		return view;
		
	}
	
	public static class ViewHolder {
		private TextView question;
		private TextView option1;
		private TextView option2;
		private TextView option3;
		private TextView option4;
		//private EditText answer;
		//private Button endtest;
	}

}
