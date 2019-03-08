package io.sbed.modules.sys.controller;

import java.util.List;
import java.util.Map;

import io.sbed.modules.sys.util.ImgUploadUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.sbed.modules.sys.entity.SysJhAdviceOder;
import io.sbed.modules.sys.service.SysJhAdviceOderService;
import io.sbed.common.utils.PageUtils;
import io.sbed.common.utils.Query;
import io.sbed.common.utils.Result;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author heguoliang
 * @Description: TODO(订单通知表)
 * @date 2019-01-11 16:28:45
 */
@RestController
@RequestMapping("/sys/jhadviceoder")
public class SysJhAdviceOderController extends AbstractController{

	@Autowired
	private SysJhAdviceOderService jhAdviceOderService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys:jhAdviceOder:list")
	public Result list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SysJhAdviceOder> jhAdviceOderList = jhAdviceOderService.queryList(query);
		int total = jhAdviceOderService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(jhAdviceOderList, total, query.getLimit(), query.getPage());
		
		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("sys:jhAdviceOder:info")
	public Result info(@PathVariable("id") Integer id){
		SysJhAdviceOder jhAdviceOder = jhAdviceOderService.queryObject(id);
		
		return Result.ok().put("jhAdviceOder", jhAdviceOder);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("sys:jhAdviceOder:save")
	public Result save(@RequestBody SysJhAdviceOder jhAdviceOder){
		jhAdviceOderService.save(jhAdviceOder);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("sys:jhAdviceOder:update")
	public Result update(@RequestBody SysJhAdviceOder jhAdviceOder){
		jhAdviceOderService.update(jhAdviceOder);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("sys:jhAdviceOder:delete")
	public Result delete(@RequestBody Integer[] ids){
		jhAdviceOderService.deleteBatch(ids);
		
		return Result.ok();
	}



}
