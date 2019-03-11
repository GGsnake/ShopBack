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
import io.sbed.modules.sys.entity.SysJdoder;
import io.sbed.modules.sys.service.SysJdoderService;
import io.sbed.common.utils.PageUtils;
import io.sbed.common.utils.Query;
import io.sbed.common.utils.Result;

/**
 * @author heguoliang
 * @Description: TODO(京东订单表)
 * @date 2019-02-23 16:19:01
 */
@RestController
@RequestMapping("/sys/jdoder")
public class SysJdoderController extends AbstractController{

	@Autowired
	private SysJdoderService jdoderService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys:jdoder:list")
	public Result list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SysJdoder> jdoderList = jdoderService.queryList(query);
		int total = jdoderService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(jdoderList, total, query.getLimit(), query.getPage());
		
		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("sys:jdoder:info")
	public Result info(@PathVariable("id") Integer id){
		SysJdoder jdoder = jdoderService.queryObject(id);
		
		return Result.ok().put("jdoder", jdoder);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("sys:jdoder:save")
	public Result save(@RequestBody SysJdoder jdoder){
		jdoderService.save(jdoder);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("sys:jdoder:update")
	public Result update(@RequestBody SysJdoder jdoder){
		jdoderService.update(jdoder);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("sys:jdoder:delete")
	public Result delete(@RequestBody Integer[] ids){
		jdoderService.deleteBatch(ids);
		
		return Result.ok();
	}
	
}
