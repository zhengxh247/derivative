/**
 * 
 */
package com.team.derivative.properties.properties;

/**
 * @author zhengxh
 *
 */
public class BrowserProperties {
	
	private SessionProperties session = new SessionProperties();
	
	private LoginResponseType loginType = LoginResponseType.JSON;
	
	private int rememberMeSeconds = 3600;

	public LoginResponseType getLoginType() {
		return loginType;
	}

	public void setLoginType(LoginResponseType loginType) {
		this.loginType = loginType;
	}

	public int getRememberMeSeconds() {
		return rememberMeSeconds;
	}

	public void setRememberMeSeconds(int rememberMeSeconds) {
		this.rememberMeSeconds = rememberMeSeconds;
	}

	public SessionProperties getSession() {
		return session;
	}

	public void setSession(SessionProperties session) {
		this.session = session;
	}
	
}
