package io.sbed.modules.sys.controller;

import java.util.List;
import java.util.Map;

import io.sbed.modules.sys.dto.PidJdReq;
import io.sbed.modules.sys.service.impl.EveryGoodServiceImpl;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.sbed.modules.sys.entity.SysPidjd;
import io.sbed.modules.sys.service.SysPidjdService;
import io.sbed.common.utils.PageUtils;
import io.sbed.common.utils.Query;
import io.sbed.common.utils.Result;

/**
 * @author heguoliang
 * @Description: TODO(京东pid)
 * @date 2019-01-16 10:11:39
 */
@RestController
@RequestMapping("/sys/pidjd")
public class SysPidjdController extends AbstractController{

	@Autowired
	private SysPidjdService pidjdService;

	@Autowired
	private EveryGoodServiceImpl everyGoodService;

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys:pidjd:list")
	public Result list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SysPidjd> pidjdList = pidjdService.queryList(query);
		int total = pidjdService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(pidjdList, total, query.getLimit(), query.getPage());
		
		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("sys:pidjd:info")
	public Result info(@PathVariable("id") Integer id){
		SysPidjd pidjd = pidjdService.queryObject(id);
		
		return Result.ok().put("pidjd", pidjd);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("sys:pidjd:save")
	public Result save(@RequestBody PidJdReq pidjd){
		everyGoodService.createJdPid(pidjd.getCount());

		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("sys:pidjd:update")
	public Result update(@RequestBody SysPidjd pidjd){
		pidjdService.update(pidjd);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("sys:pidjd:delete")
	public Result delete(@RequestBody Integer[] ids){
		pidjdService.deleteBatch(ids);
		
		return Result.ok();
	}
	
}
