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
import io.sbed.modules.sys.entity.SysJhVideoTutorial;
import io.sbed.modules.sys.service.SysJhVideoTutorialService;
import io.sbed.common.utils.PageUtils;
import io.sbed.common.utils.Query;
import io.sbed.common.utils.Result;

/**
 * @author heguoliang
 * @Description: TODO(视频教程)
 * @date 2019-01-09 16:28:58
 */
@RestController
@RequestMapping("/sys/jhvideotutorial")
public class SysJhVideoTutorialController extends AbstractController{

	@Autowired
	private SysJhVideoTutorialService jhVideoTutorialService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys:jhVideoTutorial:list")
	public Result list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SysJhVideoTutorial> jhVideoTutorialList = jhVideoTutorialService.queryList(query);
		int total = jhVideoTutorialService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(jhVideoTutorialList, total, query.getLimit(), query.getPage());
		
		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("sys:jhVideoTutorial:info")
	public Result info(@PathVariable("id") Integer id){
		SysJhVideoTutorial jhVideoTutorial = jhVideoTutorialService.queryObject(id);
		
		return Result.ok().put("jhVideoTutorial", jhVideoTutorial);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("sys:jhVideoTutorial:save")
	public Result save(@RequestBody SysJhVideoTutorial jhVideoTutorial){
		jhVideoTutorialService.save(jhVideoTutorial);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("sys:jhVideoTutorial:update")
	public Result update(@RequestBody SysJhVideoTutorial jhVideoTutorial){
		jhVideoTutorialService.update(jhVideoTutorial);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("sys:jhVideoTutorial:delete")
	public Result delete(@RequestBody Integer[] ids){
		jhVideoTutorialService.deleteBatch(ids);
		
		return Result.ok();
	}
	
}
