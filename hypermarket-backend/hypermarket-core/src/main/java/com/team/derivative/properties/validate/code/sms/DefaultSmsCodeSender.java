/**
 * 
 */
package com.team.derivative.properties.validate.code.sms;

import com.team.derivative.properties.authentication.mobile.HttpUtil;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengxh
 *
 */
public class DefaultSmsCodeSender implements SmsCodeSender {

	@Override
	public void send(String mobile, String code) {

		String host = "https://chanyoo.market.alicloudapi.com";
		String path = "/sendsms";
		String method = "GET";
		String appcode = "0f14f0f493684249a485b751ff805be1";
		Map<String, String> headers = new HashMap<String, String>();
		//最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
		headers.put("Authorization", "APPCODE " + appcode);
		Map<String, String> querys = new HashMap<String, String>();
		querys.put("mobile", mobile);
		querys.put("content", "幸福商城：您的注册码：" + code + "，如非本人操作，请忽略本短信！");

		try {
			HttpResponse response = HttpUtil.doGet(host, path, method, headers, querys);
			System.out.println(response.toString());
			//获取response的body
			System.out.println(EntityUtils.toString(response.getEntity()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
