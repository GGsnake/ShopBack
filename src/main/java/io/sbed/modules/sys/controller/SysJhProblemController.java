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
import io.sbed.modules.sys.entity.SysJhProblem;
import io.sbed.modules.sys.service.SysJhProblemService;
import io.sbed.common.utils.PageUtils;
import io.sbed.common.utils.Query;
import io.sbed.common.utils.Result;

/**
 * @author heguoliang
 * @Description: TODO(常见问题)
 * @date 2019-01-09 16:28:57
 */
@RestController
@RequestMapping("/sys/jhproblem")
public class SysJhProblemController extends AbstractController{

	@Autowired
	private SysJhProblemService jhProblemService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys:jhProblem:list")
	public Result list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SysJhProblem> jhProblemList = jhProblemService.queryList(query);
		int total = jhProblemService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(jhProblemList, total, query.getLimit(), query.getPage());
		
		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("sys:jhProblem:info")
	public Result info(@PathVariable("id") Integer id){
		SysJhProblem jhProblem = jhProblemService.queryObject(id);
		
		return Result.ok().put("jhProblem", jhProblem);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("sys:jhProblem:save")
	public Result save(@RequestBody SysJhProblem jhProblem){
		jhProblemService.save(jhProblem);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("sys:jhProblem:update")
	public Result update(@RequestBody SysJhProblem jhProblem){
		jhProblemService.update(jhProblem);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("sys:jhProblem:delete")
	public Result delete(@RequestBody Integer[] ids){
		jhProblemService.deleteBatch(ids);
		
		return Result.ok();
	}
	
}
