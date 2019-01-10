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
import io.sbed.modules.sys.entity.SysJhAdviceDev;
import io.sbed.modules.sys.service.SysJhAdviceDevService;
import io.sbed.common.utils.PageUtils;
import io.sbed.common.utils.Query;
import io.sbed.common.utils.Result;

/**
 * @author heguoliang
 * @Description: TODO(官方订单通知表)
 * @date 2019-01-08 12:08:36
 */
@RestController
@RequestMapping("/sys/jhadvicedev")
public class SysJhAdviceDevController extends AbstractController{

	@Autowired
	private SysJhAdviceDevService jhAdviceDevService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys:jhAdviceDev:list")
	public Result list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SysJhAdviceDev> jhAdviceDevList = jhAdviceDevService.queryList(query);
		int total = jhAdviceDevService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(jhAdviceDevList, total, query.getLimit(), query.getPage());
		
		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("sys:jhAdviceDev:info")
	public Result info(@PathVariable("id") Integer id){
		SysJhAdviceDev jhAdviceDev = jhAdviceDevService.queryObject(id);
		
		return Result.ok().put("jhAdviceDev", jhAdviceDev);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("sys:jhAdviceDev:save")
	public Result save(@RequestBody SysJhAdviceDev jhAdviceDev){
		jhAdviceDevService.save(jhAdviceDev);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("sys:jhAdviceDev:update")
	public Result update(@RequestBody SysJhAdviceDev jhAdviceDev){
		jhAdviceDevService.update(jhAdviceDev);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("sys:jhAdviceDev:delete")
	public Result delete(@RequestBody Integer[] ids){
		jhAdviceDevService.deleteBatch(ids);
		
		return Result.ok();
	}
	
}
