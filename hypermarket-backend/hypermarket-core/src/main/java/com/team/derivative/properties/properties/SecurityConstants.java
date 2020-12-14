/**
 * 
 */
package com.team.derivative.properties.properties;

/**
 * @author zhengxh
 *
 */
public interface SecurityConstants {
	
	/**
	 * 默认的处理验证码的url前缀
	 */
	public static final String DEFAULT_VALIDATE_CODE_URL_PREFIX = "/code";
	/**
	 * 当请求需要身份认证时，默认跳转的url
	 * 
	 * @see
	 */
	public static final String DEFAULT_UNAUTHENTICATION_URL = "http://49.232.11.36:83/";
	/**
	 * 默认的用户名密码登录请求处理url
	 */
	public static final String DEFAULT_LOGIN_PROCESSING_URL_FORM = "/authentication/login";
	/**
	 * 默认的手机验证码登录请求处理url
	 */
	public static final String DEFAULT_LOGIN_PROCESSING_URL_MOBILE = "/authentication/mobile";
	/**
	 * 默认的手注册请求处理url
	 */
	public static final String DEFAULT_LOGIN_PROCESSING_URL_REGISTER= "/user/register";
	/**
	 * 商品展示的url
	 */
	public static final String DEFAULT_GOODS_DISPLAY= "/goods/*";
	/**
	 * swagger的url
	 */
	public static final String SWAGGER_INDEX_HTML= "/swagger-ui.html";
	public static final String SWAGGER_V2= "/v2/**";
	public static final String SWAGGER_RESOURCE= "/swagger-resources/**";

	/**
	 * 验证图片验证码时，http请求中默认的携带图片验证码信息的参数的名称
	 */
	public static final String DEFAULT_PARAMETER_NAME_CODE_IMAGE = "imageCode";
	/**
	 * 验证短信验证码时，http请求中默认的携带短信验证码信息的参数的名称
	 */
	public static final String DEFAULT_PARAMETER_NAME_CODE_SMS = "smsCode";
	/**
	 * 发送短信验证码 或 验证短信验证码时，传递手机号的参数的名称
	 */
	public static final String DEFAULT_PARAMETER_NAME_MOBILE = "mobile";
	/**
	 * session失效默认的跳转地址
	 */
	public static final String DEFAULT_SESSION_INVALID_URL = "/session/invalid";

}
