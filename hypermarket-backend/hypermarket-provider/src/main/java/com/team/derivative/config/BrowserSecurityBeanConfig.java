/**
 * 
 */
package com.team.derivative.config;

import com.team.derivative.session.ExpiredSessionStrategy;
import com.team.derivative.session.SessionInvalidStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import properties.properties.SecurityProperties;


/**
 * @author zhengxh
 *
 */
@Configuration
public class BrowserSecurityBeanConfig {

	@Autowired
	private SecurityProperties securityProperties;
	
	@Bean
	@ConditionalOnMissingBean(org.springframework.security.web.session.InvalidSessionStrategy.class)
	public org.springframework.security.web.session.InvalidSessionStrategy invalidSessionStrategy(){
		return new SessionInvalidStrategy(securityProperties.getBrowser().getSession().getSessionInvalidUrl());
	}
	
	@Bean
	@ConditionalOnMissingBean(SessionInformationExpiredStrategy.class)
	public SessionInformationExpiredStrategy sessionInformationExpiredStrategy(){
		return new ExpiredSessionStrategy(securityProperties.getBrowser().getSession().getSessionInvalidUrl());
	}
	
}
