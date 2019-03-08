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
import io.sbed.modules.sys.entity.SysJhConfig;
import io.sbed.modules.sys.service.SysJhConfigService;
import io.sbed.common.utils.PageUtils;
import io.sbed.common.utils.Query;
import io.sbed.common.utils.Result;

/**
 * @author heguoliang
 * @Description: TODO()
 * @date 2019-03-07 09:37:51
 */
@RestController
@RequestMapping("/sys/jhconfig")
public class SysJhConfigController extends AbstractController{

	@Autowired
	private SysJhConfigService jhConfigService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys:jhConfig:list")
	public Result list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SysJhConfig> jhConfigList = jhConfigService.queryList(query);
		int total = jhConfigService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(jhConfigList, total, query.getLimit(), query.getPage());
		
		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("sys:jhConfig:info")
	public Result info(@PathVariable("id") Long id){
		SysJhConfig jhConfig = jhConfigService.queryObject(id);
		
		return Result.ok().put("jhConfig", jhConfig);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("sys:jhConfig:save")
	public Result save(@RequestBody SysJhConfig jhConfig){
		jhConfigService.save(jhConfig);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("sys:jhConfig:update")
	public Result update(@RequestBody SysJhConfig jhConfig){
		jhConfigService.update(jhConfig);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("sys:jhConfig:delete")
	public Result delete(@RequestBody Long[] ids){
		jhConfigService.deleteBatch(ids);
		
		return Result.ok();
	}
	
}
