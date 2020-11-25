/**
 * 
 */
package com.team.derivative.properties.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author zhengxh
 *
 */
public interface ValidateCodeGenerator {

	ValidateCode generate(ServletWebRequest request);
	
}
