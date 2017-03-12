package cn.edu.scu.tmooc.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpUtils {

	/**
	 * 
	 * @param path
	 *            鏈嶅姟绔彂甯僯son鐨勫湴鍧�
	 * @param encode
	 *            鎸囧畾鐨勭紪鐮佹牸寮�(utf-8)
	 * @return
	 */
	public static String sendPostMethod(String path, String encode) {
		String result = "";

		HttpClient client = new DefaultHttpClient();

		try {
			// post鏂瑰紡璇锋眰
			HttpPost post = new HttpPost(path);
			// 鑾峰彇鏈嶅姟鍣ㄧ鐨勫搷搴斿璞�
			HttpResponse response = client.execute(post);
			// 鍒ゆ柇璇锋眰鏄惁鎴愬姛
			if (response.getStatusLine().getStatusCode() == 200) {
				// 鑾峰彇鏈嶅姟鍣ㄧ殑鍝嶅簲鐨勪俊鎭�
				HttpEntity httpEntity = response.getEntity();

				result = EntityUtils.toString(httpEntity, encode);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			client.getConnectionManager().shutdown();
		}

		return result;
	}

	/**
	 * 鍙戦�佽姹傚苟甯﹀弬鏁�
	 * @param path
	 * @param params
	 * @param encode
	 * @return
	 */
	public static String sendPostMethod(String path,
			Map<String, Object> params, String encode) {

		HttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(path);

		String result = "";
		List<BasicNameValuePair> parameters = new ArrayList<BasicNameValuePair>();

		/*
		 * NameValuePair浠ｈ〃涓�涓狧EADER锛孡ist<NameValuePair>瀛樺偍鍏ㄩ儴鐨勫ご瀛楁
		 * UrlEncodedFormEntity绫讳技浜嶶RLEncoder璇彞杩涜URL缂栫爜 HttpPost绫讳技浜嶩TTP鐨凱OST璇锋眰
		 * client.execute()绫讳技浜庡彂鍑鸿姹傦紝骞惰繑鍥濺esponse
		 */
		try {
			if (params != null && !params.isEmpty()) {
				for (Map.Entry<String, Object> entry : params.entrySet()) {
					String name = entry.getKey();
					String value = entry.getValue().toString();
					BasicNameValuePair valuePair = new BasicNameValuePair(name,
							value);
					parameters.add(valuePair);

				}
			}
			// 绾枃鏈〃鍗曪紝涓嶅寘鍚枃浠�
			// 璁剧疆瀛楃闆�
			UrlEncodedFormEntity encodedFormEntity = new UrlEncodedFormEntity(
					parameters, encode);
			httpPost.setEntity(encodedFormEntity);
			HttpResponse httpResponse = httpClient.execute(httpPost);
			if (httpResponse.getStatusLine().getStatusCode() == 200) {
				result = EntityUtils.toString(httpResponse.getEntity(), encode);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			httpClient.getConnectionManager().shutdown();
		}

		return result;
	}

	
	/**
	 * 鑾峰彇鍥剧墖
	 * @param path
	 * @return
	 */
	public static byte[] getImageView(String path){
		byte[] data = null;
		HttpClient httpClient = new DefaultHttpClient();
		try {
			HttpPost post = new HttpPost(path);
			HttpResponse response = httpClient.execute(post);
			if (response.getStatusLine().getStatusCode() == 200) {
				data = EntityUtils.toByteArray(response.getEntity());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			httpClient.getConnectionManager().shutdown();
		}
		return data;
	}
}
