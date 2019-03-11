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
import io.sbed.modules.sys.entity.SysJhJdGood;
import io.sbed.modules.sys.service.SysJhJdGoodService;
import io.sbed.common.utils.PageUtils;
import io.sbed.common.utils.Query;
import io.sbed.common.utils.Result;

/**
 * @author heguoliang
 * @Description: TODO(淘宝采集表2)
 * @date 2019-03-09 13:54:37
 */
@RestController
@RequestMapping("/sys/jhjdgood")
public class SysJhJdGoodController extends AbstractController{

	@Autowired
	private SysJhJdGoodService jhJdGoodService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
//	@RequiresPermissions("sys:jhJdGood:list")
	public Result list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SysJhJdGood> jhJdGoodList = jhJdGoodService.queryList(query);
		int total = jhJdGoodService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(jhJdGoodList, total, query.getLimit(), query.getPage());
		
		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
//	@RequiresPermissions("sys:jhJdGood:info")
	public Result info(@PathVariable("id") Integer id){
		SysJhJdGood jhJdGood = jhJdGoodService.queryObject(id);
		
		return Result.ok().put("jhJdGood", jhJdGood);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("sys:jhJdGood:save")
	public Result save(@RequestBody SysJhJdGood jhJdGood){
		jhJdGoodService.save(jhJdGood);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody SysJhJdGood jhJdGood){
		jhJdGoodService.update(jhJdGood);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public Result delete(@RequestBody Integer[] ids){
		jhJdGoodService.deleteBatch(ids);
		
		return Result.ok();
	}
	
}
