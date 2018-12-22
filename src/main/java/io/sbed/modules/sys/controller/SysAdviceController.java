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
import io.sbed.modules.sys.entity.SysAdvice;
import io.sbed.modules.sys.service.SysAdviceService;
import io.sbed.common.utils.PageUtils;
import io.sbed.common.utils.Query;
import io.sbed.common.utils.Result;

/**
 * @author heguoliang
 * @Description: TODO(通知表)
 * @date 2018-12-22 18:05:59
 */
@RestController
@RequestMapping("/sys/advice")
public class SysAdviceController extends AbstractController{

	@Autowired
	private SysAdviceService adviceService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys:advice:list")
	public Result list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SysAdvice> adviceList = adviceService.queryList(query);
		int total = adviceService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(adviceList, total, query.getLimit(), query.getPage());
		
		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("sys:advice:info")
	public Result info(@PathVariable("id") Integer id){
		SysAdvice advice = adviceService.queryObject(id);
		
		return Result.ok().put("advice", advice);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("sys:advice:save")
	public Result save(@RequestBody SysAdvice advice){
		adviceService.save(advice);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("sys:advice:update")
	public Result update(@RequestBody SysAdvice advice){
		adviceService.update(advice);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("sys:advice:delete")
	public Result delete(@RequestBody Integer[] ids){
		adviceService.deleteBatch(ids);
		
		return Result.ok();
	}
	
}
