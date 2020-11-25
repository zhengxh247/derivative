/**
 * 
 */
package com.team.derivative.properties.validate.code.sms;

/**
 * @author zhengxh
 *
 */
public interface SmsCodeSender {
	
	void send(String mobile, String code);

}
