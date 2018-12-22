package com.zyqhw.springboot.util;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author maozk
 *
 */
public interface Pager {
	
	PageParam encodeParam(HttpServletRequest request);
	
	Object decodeResult(PageResult result);
	
	PageParam getPageParam(Integer pageNo, Integer pageSize);
	
}
