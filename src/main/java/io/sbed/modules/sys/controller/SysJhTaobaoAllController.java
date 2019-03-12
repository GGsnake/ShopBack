package io.sbed.modules.sys.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.sbed.common.utils.PageUtils;
import io.sbed.common.utils.Query;
import io.sbed.common.utils.Result;
import io.sbed.modules.sys.dao.SysJhTaobaoAllDao;
import io.sbed.modules.sys.entity.SysJhTaobaoAll;
import io.sbed.modules.sys.service.SysJhTaobaoAllService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author heguoliang
 * @Description: TODO(淘宝采集表)
 * @date 2019-03-08 12:12:22
 */
@RestController
@RequestMapping("/sys/jhtaobaoall")
public class SysJhTaobaoAllController extends AbstractController {

	@Autowired
	private SysJhTaobaoAllService jhTaobaoAllService;
	@Autowired
	private SysJhTaobaoAllDao sysJhTaobaoAllDao;

	/**
	 * 列表
	 */
	@RequestMapping("/list")
//	@RequiresPermissions("sys:jhTaobaoAll:list")
	public Result list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
        query.put("opt",1);

		List<SysJhTaobaoAll> jhTaobaoAllList = jhTaobaoAllService.queryList(query);
		int total = jhTaobaoAllService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(jhTaobaoAllList, total, query.getLimit(), query.getPage());
		
		return Result.ok().put("page", pageUtil);
	}
//	/**
//	 * 列表
//	 */
//	@RequestMapping("/allList")
////	@RequiresPermissions("sys:jhTaobaoAll:list")
//	public Result alllist(@RequestParam Map<String, Object> params){
//		//查询列表数据
//        Query query = new Query(params);
//        query.put("opt",0);
//
//		List<SysJhTaobaoAll> jhTaobaoAllList = jhTaobaoAllService.queryList(query);
//		int total = jhTaobaoAllService.queryTotal(query);
//
//		PageUtils pageUtil = new PageUtils(jhTaobaoAllList, total, query.getLimit(), query.getPage());
//
//		return Result.ok().put("page", pageUtil);
//	}

	/**
	 * 列表
	 */
	@RequestMapping("/hot/{id}")
//	@RequiresPermissions("sys:jhTaobaoAll:list")
	public Result hot(@RequestParam Map<String, Object> params,@PathVariable Integer id){
		//查询列表数据
        Query query = new Query(params);

		query.put("opt",id);
		List<SysJhTaobaoAll> jhTaobaoAllList = jhTaobaoAllService.queryList(query);
		int total = jhTaobaoAllService.queryTotal(query);

		PageUtils pageUtil = new PageUtils(jhTaobaoAllList, total, query.getLimit(), query.getPage());

		return Result.ok().put("page", pageUtil);
	}

	/**
	 * 列表
	 */
	@RequestMapping("/allin")
//	@RequiresPermissions("sys:jhTaobaoAll:list")
	public Result all(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SysJhTaobaoAll> jhTaobaoAllList = sysJhTaobaoAllDao.queryListOptAll(query);
		int total = sysJhTaobaoAllDao.queryTotalOptAll(query);

		PageUtils pageUtil = new PageUtils(jhTaobaoAllList, total, query.getLimit(), query.getPage());

		return Result.ok().put("page", pageUtil);
	}

	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
//	@RequiresPermissions("sys:jhTaobaoAll:info")
	public Result info(@PathVariable("id") Integer id){
		SysJhTaobaoAll jhTaobaoAll = jhTaobaoAllService.queryObject(id);
		
		return Result.ok().put("jhTaobaoAll", jhTaobaoAll);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
//	@RequiresPermissions("sys:jhTaobaoAll:save")
	public Result save(@RequestBody SysJhTaobaoAll jhTaobaoAll){
		jhTaobaoAllService.save(jhTaobaoAll);
		
		return Result.ok();
	}
	/**
	 * 保存
	 */
	@PostMapping("/addOpt")
//	@RequiresPermissions("sys:jhTaobaoAll:save")
	public Result addOpt(@RequestBody String json){
		JSONObject jsonObject = JSONObject.parseObject(json);
		String opt = jsonObject.getString("opt");
		JSONArray ids = jsonObject.getJSONArray("ids");
		ids.forEach(temp->{
			String id=(String)temp;
			SysJhTaobaoAll bean=new SysJhTaobaoAll();
			bean.setId(Integer.valueOf(id));
			bean.setOpt(Integer.valueOf(opt));
			jhTaobaoAllService.update(bean);
		});
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("sys:jhTaobaoAll:update")
	public Result update(@RequestBody SysJhTaobaoAll jhTaobaoAll){
		jhTaobaoAllService.update(jhTaobaoAll);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
//	@RequiresPermissions("sys:jhTaobaoAll:delete")
	public Result delete(@RequestBody Integer[] ids){
		jhTaobaoAllService.deleteBatch(ids);
		
		return Result.ok();
	}
	
}
