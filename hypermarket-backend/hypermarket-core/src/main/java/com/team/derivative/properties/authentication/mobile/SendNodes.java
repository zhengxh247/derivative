package com.team.derivative.properties.authentication.mobile;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.team.derivative.properties.validate.code.sms.SmsCodeSender;

/**
 * 阿里短信接口
 */

public class SendNodes implements SmsCodeSender {

    @Override
    public void send(String mobile, String code) {

        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI5tNJH2myQiwSNoTE6gqn", "HIInYzZIY8GcrhoEFe37RZhVS6TOMc");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("PhoneNumbers", mobile);
//      短信签名，如【阿里云】，须申请，使用申请成功的签名
        request.putQueryParameter("SignName", "幸福商城");
//      短信模板，须申请，使用申请成功的短信模板的模版CODE
        request.putQueryParameter("TemplateCode", "SMS_206550736");
//      申请的短信模板中的变量code的值，如验证码，字符串格式必须为"{code:123051}"，否则报错，123051由代码生成
        request.putQueryParameter("TemplateParam", "{code:" + code + "}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

}