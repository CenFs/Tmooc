package cn.edu.scu.tmooc.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import cn.edu.scu.tmooc.DataDownloadService;
import cn.edu.scu.tmooc.R;
import cn.edu.scu.tmooc.entity.Data;

public class DataAdapter extends ArrayAdapter<Data> {

	DataDownloadService ddl;
	private int resourceId;
	private Context context;

	public DataAdapter(Context context, int textViewResourceId,	List<Data> objects) {
		super(context, textViewResourceId, objects);
		this.resourceId = textViewResourceId;
		this.context = context;
	}


	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// 获取当前Fruit对象
		final Data data = getItem(position);
		// 加载布局文件
		View view = null;
		ViewHolder viewHolder = null;
		if (convertView == null) {
			view = LayoutInflater.from(context).inflate(resourceId, null);
			viewHolder = new ViewHolder();
		
			//viewHolder.courseid = (TextView) view.findViewById(R.id.tv_courseid);
			viewHolder.dataname = (TextView) view.findViewById(R.id.tv_dataname);
			viewHolder.datapath = (TextView) view.findViewById(R.id.tv_datapath);
			//viewHolder.datadate= (TextView) view.findViewById(R.id.tv_datadate);
			viewHolder.downloaddata = (Button) view.findViewById(R.id.btn_downloaddata);
			
			view.setTag(viewHolder); // 将ViewHolder存储在View中
		} else {
			view = convertView;
			viewHolder = (ViewHolder) view.getTag(); // 重新获取ViewHolder
		}
		
		// 获取TextView控件
		//viewHolder.courseid.setText(data.getCourseid()+"");
		viewHolder.dataname.setText(data.getDataname());
		viewHolder.datapath.setText(data.getDatapath());
		//viewHolder.datadate.setText(DateUtil.date2Str(data.getDatadate()));
		viewHolder.downloaddata.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				//Toast.makeText(getContext(), "dataid="+data.getDataid()+"", Toast.LENGTH_SHORT).show();

				try {
					Toast.makeText(getContext(), data.getDataname()+"下载中...", Toast.LENGTH_SHORT).show();
					ddl.getObject(data.getDatapath(),data.getDataname());
					//Toast.makeText(getContext(), data.getDataname()+".."+path, Toast.LENGTH_SHORT).show();

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		return view;
	}


	public static class ViewHolder {
		//private TextView courseid;
		private TextView dataname;
		private TextView datapath;
		//private TextView datadate;
		private Button downloaddata;
	}
}
