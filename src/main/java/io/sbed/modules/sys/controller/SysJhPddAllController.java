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
import io.sbed.modules.sys.entity.SysJhPddAll;
import io.sbed.modules.sys.service.SysJhPddAllService;
import io.sbed.common.utils.PageUtils;
import io.sbed.common.utils.Query;
import io.sbed.common.utils.Result;

/**
 * @author heguoliang
 * @Description: TODO(拼多多采集表)
 * @date 2019-03-13 09:29:12
 */
@RestController
@RequestMapping("/sys/jhpddall")
public class SysJhPddAllController extends AbstractController{

	@Autowired
	private SysJhPddAllService jhPddAllService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys:jhPddAll:list")
	public Result list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SysJhPddAll> jhPddAllList = jhPddAllService.queryList(query);
		int total = jhPddAllService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(jhPddAllList, total, query.getLimit(), query.getPage());
		
		return Result.ok().put("page", pageUtil);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("sys:jhPddAll:info")
	public Result info(@PathVariable("id") Integer id){
		SysJhPddAll jhPddAll = jhPddAllService.queryObject(id);
		
		return Result.ok().put("jhPddAll", jhPddAll);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("sys:jhPddAll:save")
	public Result save(@RequestBody SysJhPddAll jhPddAll){
		jhPddAllService.save(jhPddAll);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("sys:jhPddAll:update")
	public Result update(@RequestBody SysJhPddAll jhPddAll){
		jhPddAllService.update(jhPddAll);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("sys:jhPddAll:delete")
	public Result delete(@RequestBody Integer[] ids){
		jhPddAllService.deleteBatch(ids);
		
		return Result.ok();
	}
	
}
