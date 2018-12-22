/**
 * Project:spring-boot
 * File:ResultCode.java
 * Copyright © 2003-2016 zyqhw.com All rights reserved.
 */

package com.zyqhw.springboot.response;

/**
 * @author zhangyq
 * @date 2016年12月20日
 */

public enum ResultCode {
	FAULT(0, "occur error"),
	OK(1, "success"), 
	VALIDATE_ERROR(2, "validate error"), 
	DATA_NOT_FOUND(3, "data not found");
	
	private final int code;
	
	private final String msg;
	
	private ResultCode(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

}
