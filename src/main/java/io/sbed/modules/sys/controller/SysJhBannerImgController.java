package io.sbed.modules.sys.controller;

import java.util.List;
import java.util.Map;

import io.sbed.modules.sys.dao.SysBannerDao;
import io.sbed.modules.sys.entity.SysJhBannerImg;
import io.sbed.modules.sys.service.impl.SysJhBannerImgServiceImpl;
import io.sbed.modules.sys.util.ImgUploadUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.sbed.common.utils.PageUtils;
import io.sbed.common.utils.Query;
import io.sbed.common.utils.Result;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author heguoliang
 * @Description: TODO(轮播图)
 * @date 2019-02-22 11:54:29
 */
@RestController
@RequestMapping("/sys/jhbannerimg")
public class SysJhBannerImgController extends AbstractController{
	private static final String QNY_URL="http://qny.quanhuangmaoyi.com/";
	@Autowired
	private SysBannerDao sysBannerDao;
	@Autowired
	private SysJhBannerImgServiceImpl sysJhBannerImgService;
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys:jhBannerImg:list")
	public Result list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<SysJhBannerImg> jhBannerImgList = sysJhBannerImgService.queryList(query);
		int total = sysBannerDao.count();
		PageUtils pageUtil = new PageUtils(jhBannerImgList, total, query.getLimit(), query.getPage());
		return Result.ok().put("page", pageUtil);
	}

	@RequestMapping("/save")
	@RequiresPermissions("sys:jhBannerImg:save")
	public Result saveimg(@RequestParam("file") MultipartFile myfile){
		/*indexBannerService.save(indexBanner);*/
		long size = myfile.getSize();
		if(size <= 0) {
			return Result.error("请上传图片");
		}
		try {
			String fileName=myfile.getOriginalFilename();
			String suffix="."+fileName.substring(fileName.lastIndexOf(".")+1);
			String result= ImgUploadUtils.upload(myfile.getBytes(), "banner/", suffix);
			if("1".equals(result)){//上传失败
				return Result.error("新增失败");
			}else{
				String img=QNY_URL+result;
				Integer save = sysBannerDao.save(img);
				if (save==1){
					return Result.ok();
				}
				return Result.error("新增失败");
			}
		} catch (Exception e) {
			return Result.error("新增失败");
		}

	}
//
//	/**
//	 * 修改
//	 */
//	@RequestMapping("/update")
//	@RequiresPermissions("sys:jhBannerImg:update")
//	public Result update(@RequestBody SysJhBannerImg jhBannerImg){
//		jhBannerImgService.update(jhBannerImg);
//
//		return Result.ok();
//	}
//
//	/**
//	 * 删除
//	 */
//	@RequestMapping("/delete")
//	@RequiresPermissions("sys:jhBannerImg:delete")
//	public Result delete(@RequestBody Integer[] ids){
//		jhBannerImgService.deleteBatch(ids);
//
//		return Result.ok();
//	}
//
}
