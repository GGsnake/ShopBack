package io.sbed.modules.sys.controller;

import java.util.List;
import java.util.Map;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.sbed.modules.sys.entity.SysJhPayLog;
import io.sbed.modules.sys.service.SysJhPayLogService;
import io.sbed.common.utils.PageUtils;
import io.sbed.common.utils.Query;
import io.sbed.common.utils.Result;

/**
 * @author heguoliang
 * @Description: TODO(付款记录)
 * @date 2019-03-04 20:36:08
 */
@RestController
@RequestMapping("/sys/jhpaylog")
public class SysJhPayLogController extends AbstractController{

	@Autowired
	private SysJhPayLogService jhPayLogService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys:jhPayLog:list")
	public Result list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SysJhPayLog> jhPayLogList = jhPayLogService.queryList(query);
		int total = jhPayLogService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(jhPayLogList, total, query.getLimit(), query.getPage());
		
		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("sys:jhPayLog:info")
	public Result info(@PathVariable("id") Integer id){
		SysJhPayLog jhPayLog = jhPayLogService.queryObject(id);
		
		return Result.ok().put("jhPayLog", jhPayLog);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("sys:jhPayLog:save")
	public Result save(@RequestBody SysJhPayLog jhPayLog){
		jhPayLogService.save(jhPayLog);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("sys:jhPayLog:update")
	public Result update(@RequestBody SysJhPayLog jhPayLog){
		jhPayLogService.update(jhPayLog);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("sys:jhPayLog:delete")
	public Result delete(@RequestBody Integer[] ids){
		jhPayLogService.deleteBatch(ids);
		
		return Result.ok();
	}
	
}
