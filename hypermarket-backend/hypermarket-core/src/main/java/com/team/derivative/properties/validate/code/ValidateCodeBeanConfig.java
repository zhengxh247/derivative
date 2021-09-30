/**
 * 
 */
package com.team.derivative.properties.validate.code;

import com.team.derivative.properties.authentication.mobile.SendNodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.team.derivative.properties.properties.SecurityProperties;
import com.team.derivative.properties.validate.code.image.ImageCodeGenerator;
import com.team.derivative.properties.validate.code.sms.DefaultSmsCodeSender;
import com.team.derivative.properties.validate.code.sms.SmsCodeSender;

/**
 * @author zhengxh
 *
 */
@Configuration
public class ValidateCodeBeanConfig {
	
	@Autowired
	private SecurityProperties securityProperties;
	
	@Bean
	@ConditionalOnMissingBean(name = "imageValidateCodeGenerator")
	public ValidateCodeGenerator imageValidateCodeGenerator() {
		ImageCodeGenerator codeGenerator = new ImageCodeGenerator();
		codeGenerator.setSecurityProperties(securityProperties);
		return codeGenerator;
	}
	
//	@Bean
//	@ConditionalOnMissingBean(SmsCodeSender.class)
//	public SmsCodeSender smsCodeSender() {
//		return new DefaultSmsCodeSender();
//	}

	@Bean
	@ConditionalOnMissingBean(SmsCodeSender.class)
	public SmsCodeSender smsCodeSender() {
		return new SendNodes();
	}
}
