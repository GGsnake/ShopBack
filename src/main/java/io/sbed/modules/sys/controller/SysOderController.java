package io.sbed.modules.sys.controller;

import java.util.List;
import java.util.Map;

import io.sbed.modules.sys.dao.SysOderDao;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.sbed.modules.sys.entity.SysOder;
import io.sbed.modules.sys.service.SysOderService;
import io.sbed.common.utils.PageUtils;
import io.sbed.common.utils.Query;
import io.sbed.common.utils.Result;

/**
 * @author heguoliang
 * @Description: TODO(拼多多订单表)
 * @date 2018-12-30 17:05:00
 */
@RestController
@RequestMapping("/sys/oder")
public class SysOderController extends AbstractController{

	@Autowired
	private SysOderService oderService;
	@Autowired
	private SysOderDao sysOderDao;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys:oder:list")
	public Result list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SysOder> oderList = oderService.queryList(query);
		int total = oderService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(oderList, total, query.getLimit(), query.getPage());
		
		return Result.ok().put("page", pageUtil);
	}
	/**
	 * 列表
	 */
	@RequestMapping("/list1")
	@RequiresPermissions("sys:oder:list")
	public Result lists(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<SysOder> oderList = sysOderDao.queryListFor(query);
		int total = oderService.queryTotal(query);
		PageUtils pageUtil = new PageUtils(oderList, total, query.getLimit(), query.getPage());

		return Result.ok().put("page", pageUtil);
	}

	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("sys:oder:info")
	public Result info(@PathVariable("id") Long id){
		SysOder oder = oderService.queryObject(id);
		
		return Result.ok().put("oder", oder);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("sys:oder:save")
	public Result save(@RequestBody SysOder oder){
		oderService.save(oder);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("sys:oder:update")
	public Result update(@RequestBody SysOder oder){
		oderService.update(oder);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("sys:oder:delete")
	public Result delete(@RequestBody Long[] ids){
		oderService.deleteBatch(ids);
		
		return Result.ok();
	}
	
}
