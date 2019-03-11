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
import io.sbed.modules.sys.entity.SysJhCashApply;
import io.sbed.modules.sys.service.SysJhCashApplyService;
import io.sbed.common.utils.PageUtils;
import io.sbed.common.utils.Query;
import io.sbed.common.utils.Result;

/**
 * @author heguoliang
 * @Description: TODO(提现申请表)
 * @date 2019-01-09 10:57:38
 */
@RestController
@RequestMapping("/sys/jhcashapply")
public class SysJhCashApplyController extends AbstractController{

	@Autowired
	private SysJhCashApplyService jhCashApplyService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys:jhCashApply:list")
	public Result list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SysJhCashApply> jhCashApplyList = jhCashApplyService.queryList(query);
		int total = jhCashApplyService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(jhCashApplyList, total, query.getLimit(), query.getPage());
		
		return Result.ok().put("page", pageUtil);
	}
	/**
	 * 列表
	 */
	@RequestMapping("/agentlist")
	@RequiresPermissions("sys:jhCashApply:list")
	public Result agentlist(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SysJhCashApply> jhCashApplyList = jhCashApplyService.queryAgentList(query);
		int total = jhCashApplyService.queryAgentTotal(query);

		PageUtils pageUtil = new PageUtils(jhCashApplyList, total, query.getLimit(), query.getPage());

		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("sys:jhCashApply:info")
	public Result info(@PathVariable("id") Integer id){
		SysJhCashApply jhCashApply = jhCashApplyService.queryObject(id);
		
		return Result.ok().put("jhCashApply", jhCashApply);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("sys:jhCashApply:save")
	public Result save(@RequestBody SysJhCashApply jhCashApply){
		jhCashApplyService.save(jhCashApply);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("sys:jhCashApply:update")
	public Result update(@RequestBody SysJhCashApply jhCashApply){
		jhCashApplyService.update(jhCashApply);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("sys:jhCashApply:delete")
	public Result delete(@RequestBody Integer[] ids){
		jhCashApplyService.deleteBatch(ids);
		
		return Result.ok();
	}
	
}
