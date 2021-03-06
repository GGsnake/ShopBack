package io.sbed.modules.sys.controller;

import java.util.List;
import java.util.Map;

import io.sbed.modules.sys.dto.PidJdReq;
import io.sbed.modules.sys.service.EveryGoodService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.sbed.modules.sys.entity.SysPidtb;
import io.sbed.modules.sys.service.SysPidtbService;
import io.sbed.common.utils.PageUtils;
import io.sbed.common.utils.Query;
import io.sbed.common.utils.Result;

/**
 * @author heguoliang
 * @Description: TODO(淘宝pid)
 * @date 2018-12-30 16:48:00
 */
@RestController
@RequestMapping("/sys/pidtb")
public class SysPidtbController extends AbstractController{

	@Autowired
	private SysPidtbService pidtbService;
	@Autowired
	private EveryGoodService everyGoodService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys:pidtb:list")
	public Result list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SysPidtb> pidtbList = pidtbService.queryList(query);
		int total = pidtbService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(pidtbList, total, query.getLimit(), query.getPage());
		
		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("sys:pidtb:info")
	public Result info(@PathVariable("id") Integer id){
		SysPidtb pidtb = pidtbService.queryObject(id);
		
		return Result.ok().put("pidtb", pidtb);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("sys:pidtb:save")
	public Result save(@RequestBody PidJdReq pidJdReq){
		everyGoodService.createJdPid(pidJdReq.getCount());
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("sys:pidtb:update")
	public Result update(@RequestBody SysPidtb pidtb){
		pidtbService.update(pidtb);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("sys:pidtb:delete")
	public Result delete(@RequestBody Integer[] ids){
		pidtbService.deleteBatch(ids);
		
		return Result.ok();
	}
	
}
