package cn.edu.scu.tmooc.adapter;

import java.util.List;

import cn.edu.scu.tmooc.AnswerdetailActivity;
import cn.edu.scu.tmooc.R;
import cn.edu.scu.tmooc.entity.Testanswer;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

public class TestanswerAdapter extends ArrayAdapter<Testanswer> {

	protected static final int SHOW_RESPONSE7 = 0;
	private int resourceId;
	private Context context;
	

	
	public TestanswerAdapter(Context context, int textViewResourceId, List<Testanswer> objects) {
		super(context, textViewResourceId, objects);
		this.resourceId = textViewResourceId;
		this.context = context;

	}


     
	
	public View getView(final int position, View convertView, ViewGroup parent) {
		// ��ȡ��ǰ����
		final Testanswer testanswer = getItem(position);
		System.out.print(position);
		// ���ز����ļ�
		View view = null;
		ViewHolder viewHolder = null;
		//final TextView tv_test = (TextView)view.findViewById(R.id.testid);
		
		if (convertView == null) {
			view = LayoutInflater.from(context).inflate(resourceId, null);
			
			
			
			
			
			viewHolder = new ViewHolder();
			viewHolder.answerpaperid = (TextView) view.findViewById(R.id.answerpaperid);
			viewHolder.courseid = (TextView) view.findViewById(R.id.courseid);
			viewHolder.answerdetail = (Button) view.findViewById(R.id.answerdetail);		
			
			view.setTag(viewHolder); // ��ViewHolder�洢��View��
		} else {
			
			view = convertView;
			viewHolder = (ViewHolder) view.getTag(); // ���»�ȡViewHolder
		}
		

		// ��ȡTextView�ؼ�
		Log.i("testanswer", testanswer+"");
		viewHolder.answerpaperid.setText(testanswer.getAnswerpaperid()+"");
		viewHolder.courseid.setText(testanswer.getCourseid()+"");
		
		viewHolder.answerdetail.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				//Toast.makeText(getContext(), test.getPaperid()+"", Toast.LENGTH_SHORT).show();

		    	//������ͼ����
		    	Intent intent=new Intent(context, AnswerdetailActivity.class);
		    	//���������ݷ�װ��Intent������
		    	intent.putExtra("Message", testanswer.getAnswerpaperid()+"");
		    	intent.putExtra("userID", testanswer.getStudentid()+"");
		    	intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);  
		    	//�����µ�Activity
		    	context.startActivity(intent);
				
				
			}
		});
		return view;
	}
	
	public static class ViewHolder {
		private TextView answerpaperid;
		private TextView courseid;
		private Button answerdetail;
	}

}