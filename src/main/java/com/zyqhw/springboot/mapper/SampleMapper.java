/**
 * Project:spring-boot
 * File:LeveloneMapper.java
 * Copyright © 2003-2016 zyqhw.com All rights reserved.
 */

package com.zyqhw.springboot.mapper;

import java.util.List;

import com.zyqhw.springboot.domain.Fake;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import com.zyqhw.springboot.domain.Sample;

/**
 * @author zhangyq
 * @date 2016年12月20日
 */
@Mapper
@CacheConfig(cacheNames = "baseCache")
public interface SampleMapper {
	
	@Select("select * from sample where s_number = #{number} limit 1")
	@Results({
		@Result(property="sNumber",column="s_number"),
		@Result(property="sDate",column="s_date"),
		@Result(property="sType",column="s_type")
		})
	@Cacheable
	Sample selectByNumber(String number);
	
	@Select("select * from sample where s_number = #{number}")
	@Results({
		@Result(property="sNumber",column="s_number"),
		@Result(property="sDate",column="s_date"),
		@Result(property="sType",column="s_type")
		})
	//@ResultType(List.class)
	@Cacheable
	List<Sample> listByNumber(String number);
	
	@Select("select * from sample")
	@Results({
		@Result(property="sNumber",column="s_number"),
		@Result(property="sDate",column="s_date"),
		@Result(property="sType",column="s_type")
		})
	//@ResultType(List.class)
	List<Sample> listAll();

	@Select("select * from fake")
		//@ResultType(List.class)
	List<Fake> listAllFake();
}
