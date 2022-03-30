package com.retrocicla.felipeazs.security;

import com.retrocicla.felipeazs.SpringApplicationContext;

public class SecurityConstants {
	
	public static final long EXPIRATION_TIME = 864000000;// 10 dias
	public static final long PASSWORD_RESET_EXPIRATION_TIME = 1000*60*60; //1 hora
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	public static final String SIGN_UP_URL = "/clientes";
	public static final String VERIFICATION_EMAIL_URL = "/clientes/email-verification";
	public static final String PASSWORD_RESET_REQUEST_URL = "/clientes/password-reset-request";
	public static final String PASSWORD_RESET_URL = "/clientes/password-reset";
	
	public static final String CREATE_PRODUCT_URL = "/productos";
	public static final String GET_PRODUCTS_URL = "/productos";
	
	public static String getTokenSecret() {
		AppProperties appProperties = (AppProperties) SpringApplicationContext.getBean("appProperties");
		
		return appProperties.getTokenSecret();
	}
}
