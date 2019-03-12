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
import io.sbed.modules.sys.entity.SysCollectlog;
import io.sbed.modules.sys.service.SysCollectlogService;
import io.sbed.common.utils.PageUtils;
import io.sbed.common.utils.Query;
import io.sbed.common.utils.Result;

/**
 * @author heguoliang
 * @Description: TODO(收集)
 * @date 2019-03-11 18:42:43
 */
@RestController
@RequestMapping("/sys/collectlog")
public class SysCollectlogController extends AbstractController{

	@Autowired
	private SysCollectlogService collectlogService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys:collectlog:list")
	public Result list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SysCollectlog> collectlogList = collectlogService.queryList(query);
		int total = collectlogService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(collectlogList, total, query.getLimit(), query.getPage());
		
		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("sys:collectlog:info")
	public Result info(@PathVariable("id") Integer id){
		SysCollectlog collectlog = collectlogService.queryObject(id);
		
		return Result.ok().put("collectlog", collectlog);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("sys:collectlog:save")
	public Result save(@RequestBody SysCollectlog collectlog){
		collectlogService.save(collectlog);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("sys:collectlog:update")
	public Result update(@RequestBody SysCollectlog collectlog){
		collectlogService.update(collectlog);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("sys:collectlog:delete")
	public Result delete(@RequestBody Integer[] ids){
		collectlogService.deleteBatch(ids);
		
		return Result.ok();
	}
	
}
