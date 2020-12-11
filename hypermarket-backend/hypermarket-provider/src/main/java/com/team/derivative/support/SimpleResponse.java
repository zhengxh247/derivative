/**
 * 
 */
package com.team.derivative.support;

/**
 * @author zhengxh
 */
public class SimpleResponse {
	
	public SimpleResponse(Object message){
		this.message = message;
	}
	
	private Object message;

	public Object getMessage() {
		return message;
	}

	public void setMessage(Object message) {
		this.message = message;
	}

}
