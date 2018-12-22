/**
 * Project:spring-boot
 * File:TLevelonelist.java
 * Copyright © 2003-2016 zyqhw.com All rights reserved.
 */

package com.zyqhw.springboot.domain;

import java.io.Serializable;

/**
 * @author zhangyq
 * @date 2016年12月20日
 */

public class Sample implements Serializable {
	
	private static final long serialVersionUID = -7921396908196061318L;

	private String sNumber;

	private String sDate;

	private String sType;

	public String getsNumber() {
		return sNumber;
	}

	public void setsNumber(String sNumber) {
		this.sNumber = sNumber;
	}

	public String getsDate() {
		return sDate;
	}

	public void setsDate(String sDate) {
		this.sDate = sDate;
	}

	public String getsType() {
		return sType;
	}

	public void setsType(String sType) {
		this.sType = sType;
	}

}
