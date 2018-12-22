/**
 * Project:spring-boot
 * File:ResponseResult.java
 * Copyright © 2003-2016 zyqhw.com All rights reserved.
 */

package com.zyqhw.springboot.response;


/**
 * @author zhangyq
 * @date 2016年12月20日
 */

public class ResponseResult {
	
	public ResponseResult(ResultCode code) {
		this.code = code.getCode();
		this.msg = code.getMsg();
	}
	
	public ResponseResult(ResultCode code, String msg) {
		this.code = code.getCode();
		this.msg = msg;
	}
	
	public ResponseResult(ResultCode code, Object obj) {
		this.code = code.getCode();
		this.msg = code.getMsg();
		this.result = obj;
	}
	
	public ResponseResult(ResultCode code, String msg, Object obj) {
		this.code = code.getCode();
		this.msg = msg;
		this.result = obj;
	}
	
	private int code;
	
	private String msg;
	
	private Object result;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

}
