/**
 * Project:spring-boot
 * File:LevelonelistController.java
 * Copyright © 2003-2016 zyqhw.com All rights reserved.
 */

package com.itmayiedu.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.zyqhw.springboot.domain.Fake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.zyqhw.springboot.domain.Sample;
import com.zyqhw.springboot.mapper.SampleMapper;
import com.zyqhw.springboot.response.ResponseResult;
import com.zyqhw.springboot.response.ResultCode;
import com.zyqhw.springboot.util.Base64Utils;

/**
 * @author zhangyq
 * @date 2016年12月20日
 */
@RestController
@RequestMapping(value="/levelone")
public class SampleController {
	@Autowired
	SampleMapper sampleMapper;
	
	@RequestMapping(value="/{number}", method=RequestMethod.GET) 
    public Object getSample(@PathVariable String number) {
		if (StringUtils.isEmpty(number)) {
			return new ResponseResult(ResultCode.VALIDATE_ERROR, "tel can not be null");
		}
		
//		try {
//			number = Base64Utils.decodeFromString(number);
//		} catch (UnsupportedEncodingException e) {
//			return new ResponseResult(ResultCode.FAULT, "base64 decode error");
//		} catch (Exception e) {
//			return new ResponseResult(ResultCode.FAULT, "base64 decode error");
//		}
		
		Sample sample = sampleMapper.selectByNumber(number);
		if (sample == null) {
			return new ResponseResult(ResultCode.DATA_NOT_FOUND);
		}
		
        return new ResponseResult(ResultCode.OK, sample); 
    }
	
	@RequestMapping(value="/", method=RequestMethod.POST) 
    public Object postSample(String number) {
		if (StringUtils.isEmpty(number)) {
			return new ResponseResult(ResultCode.VALIDATE_ERROR, "tel can not be null");
		}
		
//		try {
//			number = Base64Utils.decodeFromString(number);
//		} catch (UnsupportedEncodingException e) {
//			return new ResponseResult(ResultCode.FAULT, "base64 decode error");
//		} catch (Exception e) {
//			return new ResponseResult(ResultCode.FAULT, "base64 decode error");
//		}
		
		Sample sample = sampleMapper.selectByNumber(number);
		if (sample == null) {
			return new ResponseResult(ResultCode.DATA_NOT_FOUND);
		}
		
        return new ResponseResult(ResultCode.OK, sample); 
    }
	
	@RequestMapping(value="/{number}/list", method=RequestMethod.GET) 
    public Object list(@PathVariable String number) {
		if (StringUtils.isEmpty(number)) {
			return new ResponseResult(ResultCode.VALIDATE_ERROR, "tel can not be null");
		}
		
//		try {
//			number = Base64Utils.decodeFromString(number);
//		} catch (UnsupportedEncodingException e) {
//			return new ResponseResult(ResultCode.FAULT, "base64 decode error");
//		} catch (Exception e) {
//			return new ResponseResult(ResultCode.FAULT, "base64 decode error");
//		}
		
		List<Sample> samples = sampleMapper.listByNumber(number);
		if (samples.size() == 0) {
			return new ResponseResult(ResultCode.DATA_NOT_FOUND);
		}
		
        return new ResponseResult(ResultCode.OK, samples); 
    }
	
	@RequestMapping(value="/page", method=RequestMethod.GET) 
    public Object page() {
		
		List<Sample> samples = sampleMapper.listAll();
		if (samples.size() == 0) {
			return new ResponseResult(ResultCode.DATA_NOT_FOUND);
		}
		
        return new ResponseResult(ResultCode.OK, samples); 
    }

	@RequestMapping(value="/fake", method=RequestMethod.GET)
	public Object resfulls(){
//		try {
//			number = Base64Utils.decodeFromString(number);
//		} catch (UnsupportedEncodingException e) {
//			return new ResponseResult(ResultCode.FAULT, "base64 decode error");
//		} catch (Exception e) {
//			return new ResponseResult(ResultCode.FAULT, "base64 decode error");
//		}


		List<Fake> sample = sampleMapper.listAllFake();
		if (sample == null) {
			return new ResponseResult(ResultCode.DATA_NOT_FOUND);
		}

		return new ResponseResult(ResultCode.OK, sample);
	}
}
