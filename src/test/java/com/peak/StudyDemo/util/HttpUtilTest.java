package com.peak.StudyDemo.util;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;

public class HttpUtilTest {

	@Test
	public void fun1(){

		String postData = "username=%s&password=%s";
		postData = String.format(postData, "bigdata-sp", "Welcome2sohu!");
		HttpUtil.HttpRequest("http://localhost:8081/huiyan/a/login?__sid="
				+ HttpUtil.sessionId.replace("JSESSIONID=", "") + "&__cookie=true", "POST", postData, false);
		postData = "key=%s&oldValue=%s&nowValue=%s&percent=%f&message=%s&group=%d&error=%s";
		postData = String.format(postData, "key", 1L, 1L, 0.2, "message", 0, "error");
		HttpUtil.HttpRequest("http://localhost:8081/huiyan/a/logview/warning?__sid="
				+ HttpUtil.sessionId.replace("JSESSIONID=", "") + "&__cookie=true", "POST", postData, true);

	}

	@Test
	public void fun2(){

		String address = "http://localhost:8081/huiyan";

		//登录
		String postData = "username=%s&password=%s";
		postData = String.format(postData, "bigdata-sp", "Welcome2sohu!");
		HttpUtil.HttpRequest(address+"/a/login?__sid="+ HttpUtil.sessionId.replace("JSESSIONID=", "") + "&__cookie=true", "POST", postData, false);
		//请求
		postData = "queryUser=%s&queryParam=%s&queryDateScope=%s&queryId=%s&result=%b&duration=%s&queryTime=%d";
		postData = String.format(postData,"4f4db17325d148b39eae1f4dfc5db579","467177,467196_test","test","213dfddd2d5c489b8f5f7fbb6ddad59b",true,"test",1490672690141L);
		HttpUtil.HttpRequest(address+"/a/offlineQuery/notifyResult?__sid="+ HttpUtil.sessionId.replace("JSESSIONID=", "") + "&__cookie=true", "POST", postData, true);

	}




}
