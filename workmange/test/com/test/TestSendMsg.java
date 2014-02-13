package com.test;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

import weibo4j.http.HttpClient;
import weibo4j.http.Response;
import weibo4j.model.PostParameter;
import weibo4j.model.Status;
import weibo4j.model.WeiboException;

public class TestSendMsg {

	public static void main(String[] args) throws HttpException, IOException, WeiboException {
		HttpClient client = new HttpClient();
		client.setToken("2.00BZtcuB9hdppDfe5e2f03953BGpGE");
		Response res = client.post("https://api.weibo.com/2/statuses/update.json", new PostParameter[]{
				new PostParameter("status", "测试一下xxxx @蒼白_2013")
		});
		System.out.println(new Status(res));
	}

}
