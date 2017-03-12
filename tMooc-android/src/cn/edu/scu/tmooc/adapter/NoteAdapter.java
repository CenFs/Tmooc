package cn.edu.scu.tmooc.adapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import cn.edu.scu.tmooc.NoteActivity;
import cn.edu.scu.tmooc.NoteAddActivity;
import cn.edu.scu.tmooc.NoteDetailActivity;
import cn.edu.scu.tmooc.R;
import cn.edu.scu.tmooc.entity.Note;
import cn.edu.scu.tmooc.util.DateUtil;
import cn.edu.scu.tmooc.util.MyConstant;

public class NoteAdapter extends ArrayAdapter<Note> {

	private int resourceId;
	private Context context;

	public NoteAdapter(Context context, int textViewResourceId,	List<Note> objects) {
		super(context, textViewResourceId, objects);
		this.resourceId = textViewResourceId;
		this.context = context;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// 获取当前Fruit对象
		final Note note = getItem(position);
		// 加载布局文件
		View view = null;
		ViewHolder viewHolder = null;
		if (convertView == null) {
			view = LayoutInflater.from(context).inflate(resourceId, null);
			viewHolder = new ViewHolder();
		
			viewHolder.notetitle = (TextView) view.findViewById(R.id.tv_notetitle);
			viewHolder.notetext = (TextView) view.findViewById(R.id.tv_notetext);
			viewHolder.notedate= (TextView) view.findViewById(R.id.tv_notedate);
			viewHolder.editnote = (Button) view.findViewById(R.id.btn_editnote);
			viewHolder.deletenote = (Button) view.findViewById(R.id.btn_deletenote);
			
			view.setTag(viewHolder); // 将ViewHolder存储在View中
		} else {
			view = convertView;
			viewHolder = (ViewHolder) view.getTag(); // 重新获取ViewHolder
		}
		
		// 获取TextView控件
		viewHolder.notetitle.setText(note.getNotetitle());
		viewHolder.notetext.setText(note.getNotetext());
		viewHolder.notedate.setText(DateUtil.date2Str(note.getNotedate()));
		viewHolder.editnote.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				//Toast.makeText(getContext(), "noteid="+note.getNoteid()+"", Toast.LENGTH_SHORT).show();

		    	//定义意图对象
		    	Intent intent = new Intent(context, NoteDetailActivity.class);
		    	//将传送数据封装到Intent对象中
		    	intent.putExtra("noteid", note.getNoteid()+"");
		    	intent.putExtra("notetext", note.getNotetext()+"");
		    	intent.putExtra("notetitle", note.getNotetitle()+"");
		    	intent.putExtra("userID", note.getStudentid()+"");
		    	intent.putExtra("notedate", note.getNotedate()+"");
		    	intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);  
		    	//开启新的Activity
		    	context.startActivity(intent);
			}
		});
		
		viewHolder.deletenote.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				//Toast.makeText(getContext(), "删除noteid="+note.getNoteid()+"", Toast.LENGTH_SHORT).show();
				final int noteid = note.getNoteid();
				new Thread(new Runnable() {
					public void run() {
						// 声明并初始化HttpClient对象
						HttpClient httpClient = new DefaultHttpClient();
						HttpPost httpPost = new HttpPost(MyConstant.URL + "note.do?method=deletenote");
						List<NameValuePair> params = new ArrayList<NameValuePair>();
						params.add(new BasicNameValuePair("noteid", ""+noteid));
						try {
							 UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params,"utf-8");
							httpPost.setEntity(entity);
							HttpResponse httpResponse = httpClient.execute(httpPost);
							if (httpResponse.getStatusLine().getStatusCode() == 200) {
								// 请求和响应都成功
								HttpEntity resEntity = httpResponse.getEntity();
								String response = EntityUtils.toString(resEntity,"utf-8");
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}).start();
				
				Intent intent = new Intent(context, NoteActivity.class);
		    	//将传送数据封装到Intent对象中
		    	intent.putExtra("userID", note.getStudentid()+"");
		    	intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);  
		    	//开启新的Activity
		    	context.startActivity(intent);
			}			
		});
		
		
		return view;
	}


	public static class ViewHolder {
		private TextView notetitle;
		private TextView notetext;
		private TextView notedate;
		private Button editnote;
		private Button deletenote;
	}
}
