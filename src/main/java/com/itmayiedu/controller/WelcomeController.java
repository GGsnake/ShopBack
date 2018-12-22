/**
 * Project:spring-boot
 * File:WelcomeController.java
 * Copyright © 2003-2016 zyqhw.com All rights reserved.
 */

package com.itmayiedu.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhangyq
 * @date 2016年12月21日
 */
@Controller
@RequestMapping("/")
public class WelcomeController {
	@Value("${application.message:Hello World}")
	private String message = "Hello World";

	@GetMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("time", new Date());
		model.put("message", this.message);
		return "welcome";
	}
}
