package com.zyqhw.springboot.util;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author maozk
 *
 */
public class JqGridPager implements Pager {

	public PageParam encodeParam(HttpServletRequest request) {
		String pageNoString = request.getParameter("page");
		String pageSizeString = request.getParameter("rows");
		Integer pageNo = null;
		Integer pageSize = null;
		try {
			pageNo = Integer.parseInt(pageNoString);
		} catch (Exception e) {
			pageNo = 1;
		}
		try {
			pageSize = Integer.parseInt(pageSizeString);
		} catch (Exception e) {
			pageSize = 10;
		}
		return new PageParam(pageNo, pageSize);
	}

	public Object decodeResult(PageResult result) {
		Map<String, Object> jqResult = new HashMap<String,Object>();
		jqResult.put("pageNum", result.getPageNo());
		jqResult.put("total", result.getRecordCount());
		jqResult.put("pages", result.getPageCount());
		jqResult.put("list", result.getRows());
		return jqResult;
	}
	
	public PageParam getPageParam(Integer pageNo, Integer pageSize){
		return new PageParam(pageNo, pageSize);
		
	}

}
