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
import io.sbed.modules.sys.entity.SysTboder;
import io.sbed.modules.sys.service.SysTboderService;
import io.sbed.common.utils.PageUtils;
import io.sbed.common.utils.Query;
import io.sbed.common.utils.Result;

/**
 * @author heguoliang
 * @Description: TODO(淘宝订单表)
 * @date 2018-12-20 10:12:57
 */
@RestController
@RequestMapping("/sys/tboder")
public class SysTboderController extends AbstractController{

	@Autowired
	private SysTboderService tboderService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys:tboder:list")
	public Result list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SysTboder> tboderList = tboderService.queryList(query);
		int total = tboderService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(tboderList, total, query.getLimit(), query.getPage());
		
		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("sys:tboder:info")
	public Result info(@PathVariable("id") Integer id){
		SysTboder tboder = tboderService.queryObject(id);
		
		return Result.ok().put("tboder", tboder);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("sys:tboder:save")
	public Result save(@RequestBody SysTboder tboder){
		tboderService.save(tboder);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("sys:tboder:update")
	public Result update(@RequestBody SysTboder tboder){
		tboderService.update(tboder);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("sys:tboder:delete")
	public Result delete(@RequestBody Integer[] ids){
		tboderService.deleteBatch(ids);
		
		return Result.ok();
	}
	
}
