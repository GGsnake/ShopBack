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
import io.sbed.modules.sys.entity.SysUserinfo;
import io.sbed.modules.sys.service.SysUserinfoService;
import io.sbed.common.utils.PageUtils;
import io.sbed.common.utils.Query;
import io.sbed.common.utils.Result;

/**
 * @author heguoliang
 * @Description: TODO(商城用户表)
 * @date 2018-12-30 16:48:00
 */
@RestController
@RequestMapping("/sys/userinfo")
public class SysUserinfoController extends AbstractController{

	@Autowired
	private SysUserinfoService userinfoService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys:userinfo:list")
	public Result list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SysUserinfo> userinfoList = userinfoService.queryList(query);
		int total = userinfoService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(userinfoList, total, query.getLimit(), query.getPage());
		
		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("sys:userinfo:info")
	public Result info(@PathVariable("id") Long id){
		SysUserinfo userinfo = userinfoService.queryObject(id);
		
		return Result.ok().put("userinfo", userinfo);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("sys:userinfo:save")
	public Result save(@RequestBody SysUserinfo userinfo){
		userinfoService.save(userinfo);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("sys:userinfo:update")
	public Result update(@RequestBody SysUserinfo userinfo){
		userinfoService.update(userinfo);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("sys:userinfo:delete")
	public Result delete(@RequestBody Long[] ids){
		userinfoService.deleteBatch(ids);
		
		return Result.ok();
	}
	
}
