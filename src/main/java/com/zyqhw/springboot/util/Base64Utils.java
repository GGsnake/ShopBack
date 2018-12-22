/**
 * Project:spring-boot
 * File:Base64Util.java
 * Copyright © 2003-2016 zyqhw.com All rights reserved.
 */

package com.zyqhw.springboot.util;

import java.io.UnsupportedEncodingException;

/**
 * @author zhangyq
 * @date 2016年12月21日
 */

public class Base64Utils {
	
	private static String CHARSET_UTF_8 = "utf-8";
	
	public static String decodeFromString(String base64Str) throws UnsupportedEncodingException {
		return new String(org.springframework.util.Base64Utils.decodeFromString(base64Str), CHARSET_UTF_8);
	}
	
	public static String encodeToString(String str) throws UnsupportedEncodingException {
		return org.springframework.util.Base64Utils.encodeToString(str.getBytes(CHARSET_UTF_8));
	}
	
}
