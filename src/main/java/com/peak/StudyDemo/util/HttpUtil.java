package com.peak.StudyDemo.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;

import com.alibaba.fastjson.JSONObject;

/**
 * 请求数据通用类
 * @author peak
 */
public class HttpUtil implements Serializable{


	/**
	 * 维持session
	 */
	public static String sessionId = "";

	/** 
	 * 发起https请求并获取结果 
	 * @param requestUrl 请求地址 
	 * @param requestMethod 请求方式（GET、POST） 
	 * @param outputStr 提交的数据 
	 * @param keepSession 是否使用session
	 * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值) 
	 */  
	public static JSONObject HttpRequest(String request , String RequestMethod , String output ,boolean keepSession){
		@SuppressWarnings("unused")
		JSONObject jsonObject = null;
		StringBuffer buffer = new StringBuffer();
		try {
			//建立连接
			URL url = new URL(request);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setUseCaches(false);
			connection.setRequestMethod(RequestMethod);

			//第二次运行的时候，把上次读取的session的值设置上
			connection.addRequestProperty("Cookie", sessionId);

			System.out.println("提交请求："+request+" 数据: "+output);
			if(output!=null){
				OutputStream out = connection.getOutputStream();
				out.write(output.getBytes("UTF-8"));
				out.close();
			}
			//流处理
			InputStream input = connection.getInputStream();
			InputStreamReader inputReader = new InputStreamReader(input,"UTF-8");
			BufferedReader reader = new BufferedReader(inputReader);
			String line;
			while((line=reader.readLine())!=null){
				buffer.append(line);
			}


			//第一次运行的时候，记录下来session的值
			if(!keepSession){ //
				String session_value = connection.getHeaderField("Set-Cookie");
				if(session_value != null){
					String[] sessionIds = session_value.split(";");
					//保存session信息
					if(sessionIds.length > 0){
						sessionId = sessionIds[0];
					}
				}
			}


			//关闭连接、释放资源
			reader.close();
			inputReader.close();
			input.close();
			input = null;
			connection.disconnect();
			System.err.println(buffer.toString());
			//jsonObject = JSONObject.fromObject(buffer.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("返回结果："+jsonObject);
		return jsonObject;
	} 


	public static String URLEncoder(String str){
		String result = str ;
		try {
			result = java.net.URLEncoder.encode(result,"UTF-8");	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 数据提交与请求通用方法
	 * @param RequestURL 请求地址
	 * @param RequestMt 请求方式
	 * @param outstr 提交json数据
	 * @param keepSession 是否使用session
	 * */
	public static boolean PostMessage(String RequestURL ,String RequestMt , String outstr,boolean keepSession){
		boolean result = false;
		JSONObject jsonobject = HttpUtil.HttpRequest(RequestURL, RequestMt, outstr, keepSession);
		if (null != jsonobject) {  
			result = jsonobject.getBoolean("success");  
			String error = String.format("请求结果 success:{%s} message:{%s}", jsonobject.getBoolean("success"), jsonobject.getString("message"));  
			System.out.println(error); 
		}
		return result;
	}




	/**
	 * input 转  byte
	 */
	public static byte[] input2byte(InputStream inStream)  
			throws IOException {  
		ByteArrayOutputStream swapStream = new ByteArrayOutputStream();  
		byte[] buff = new byte[100];  
		int rc = 0;  
		while ((rc = inStream.read(buff, 0, 100)) > 0) {  
			swapStream.write(buff, 0, rc);  
		}  
		byte[] in2b = swapStream.toByteArray();  
		return in2b;  
	}  




}