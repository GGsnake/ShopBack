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
import io.sbed.modules.sys.entity.SysPidpdd;
import io.sbed.modules.sys.service.SysPidpddService;
import io.sbed.common.utils.PageUtils;
import io.sbed.common.utils.Query;
import io.sbed.common.utils.Result;

/**
 * @author heguoliang
 * @Description: TODO(拼多多pid)
 * @date 2018-12-30 16:48:00
 */
@RestController
@RequestMapping("/sys/pidpdd")
public class SysPidpddController extends AbstractController{

	@Autowired
	private SysPidpddService pidpddService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys:pidpdd:list")
	public Result list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SysPidpdd> pidpddList = pidpddService.queryList(query);
		int total = pidpddService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(pidpddList, total, query.getLimit(), query.getPage());
		
		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("sys:pidpdd:info")
	public Result info(@PathVariable("id") Integer id){
		SysPidpdd pidpdd = pidpddService.queryObject(id);
		
		return Result.ok().put("pidpdd", pidpdd);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("sys:pidpdd:save")
	public Result save(@RequestBody SysPidpdd pidpdd){
		pidpddService.save(pidpdd);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("sys:pidpdd:update")
	public Result update(@RequestBody SysPidpdd pidpdd){
		pidpddService.update(pidpdd);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("sys:pidpdd:delete")
	public Result delete(@RequestBody Integer[] ids){
		pidpddService.deleteBatch(ids);
		
		return Result.ok();
	}
	
}
