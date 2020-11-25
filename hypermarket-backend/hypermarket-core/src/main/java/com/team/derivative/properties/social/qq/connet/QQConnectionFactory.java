/**
 * 
 */
package com.team.derivative.properties.social.qq.connet;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import com.team.derivative.properties.social.qq.api.QQ;

/**
 * @author zhengxh
 *
 */
public class QQConnectionFactory extends OAuth2ConnectionFactory<QQ> {

	public QQConnectionFactory(String providerId, String appId, String appSecret) {
		super(providerId, new QQServiceProvider(appId, appSecret), new QQAdapter());
	}

}
