package io.sbed.modules.sys.controller;

import com.alibaba.fastjson.JSONArray;
import io.sbed.common.utils.PageUtils;
import io.sbed.common.utils.Query;
import io.sbed.common.utils.Result;
import io.sbed.modules.sys.dao.SysDaygoodsDao;
import io.sbed.modules.sys.entity.SysDayGoodDto;
import io.sbed.modules.sys.entity.SysDaygoods;
import io.sbed.modules.sys.service.SysJhVideoTutorialService;
import io.sbed.modules.sys.util.ImgUploadUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author heguoliang
 * @Description: TODO(视频教程)
 * @date 2019-01-09 16:28:58
 */
@RestController
@RequestMapping("/sys/friend")
public class SysJhFriendContrller extends AbstractController {

    @Autowired
    private SysDaygoodsDao daygoodsDao;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:friend:list")
    public Result list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<SysDaygoods> sysDaygoods = daygoodsDao.queryListFirend(query);
        Integer count = daygoodsDao.countFirend();
        JSONArray data = new JSONArray();
        if (count == null || count == 0) {
            PageUtils pageUtil = new PageUtils(null, 0, query.getLimit(), query.getPage());
            return Result.ok().put("page", pageUtil);
        }
        for (SysDaygoods sy : sysDaygoods) {
            SysDayGoodDto dto = new SysDayGoodDto();
            BeanUtils.copyProperties(sy, dto);
            List<String> images = daygoodsDao.getImagesFriend(sy.getId());
            dto.setContent_Images(images);
            data.add(dto);
        }
        PageUtils pageUtil = new PageUtils(data, count, query.getLimit(), query.getPage());

        return Result.ok().put("page", pageUtil);

    }

    //
//	/**
//	 * 信息
//	 */
//	@RequestMapping("/info/{id}")
//	@RequiresPermissions("sys:jhVideoTutorial:info")
//	public Result info(@PathVariable("id") Integer id){
//		SysJhVideoTutorial jhVideoTutorial = jhVideoTutorialService.queryObject(id);
//
//		return Result.ok().put("jhVideoTutorial", jhVideoTutorial);
//	}
//
    private static final String QNY_URL = "http://qny.quanhuangmaoyi.com/";

    /**
     * 保存
     */
    @RequestMapping("/save")
    public Result save(HttpServletRequest request, @RequestParam("file") MultipartFile[] myfile, SysDaygoods sysDaygoods) {
        if (myfile.length == 0) {
            return Result.error("请上传图片");
        }
        if (sysDaygoods == null || sysDaygoods.getContent() == null || sysDaygoods.getTitile() == null) {
            return Result.error("请填写标题或者内容");
        }
        Map<String, Object> map = new HashMap<>();
        map.put("titile", sysDaygoods.getTitile());
        map.put("content", sysDaygoods.getContent());
        map.put("image", "http://www.quanhuangmaoyi.com/quan.jpg");
        Integer flag = daygoodsDao.saveFirend(map);
        if (flag == 0) {
            return Result.error("创建失败请重试");
        }
        SysDaygoods tempGoods = daygoodsDao.queryIdFriend(sysDaygoods.getContent());
        if (tempGoods==null){
            return Result.error("创建失败请重试");
        }

        //判断file数组不能为空并且长度大于0
        if (myfile != null && myfile.length > 0) {
            //循环获取file数组中得文件
            for (int i = 0; i < myfile.length; i++) {
                MultipartFile file = myfile[i];
                try {
                    String fileName = file.getOriginalFilename();
                    String suffix = "." + fileName.substring(fileName.lastIndexOf(".") + 1);
                    String result = ImgUploadUtils.upload(file.getBytes(), "banner/", suffix);
                    if ("1".equals(result)) {//上传失败
                        continue;
                    } else {
                        String img = QNY_URL + result;
                        Map<String, Object> imgMap = new HashMap<>();
                        imgMap.put("image", img);
                        imgMap.put("day", tempGoods.getId());
                        daygoodsDao.saveFirendImg(imgMap);

                        continue;
                    }
                } catch (Exception e) {
                    return Result.error("新增失败");
                }

            }
        }
        return Result.ok("添加成功");
    }
//
//	/**
//	 * 修改
//	 */
//	@RequestMapping("/update")
//	@RequiresPermissions("sys:jhVideoTutorial:update")
//	public Result update(@RequestBody SysJhVideoTutorial jhVideoTutorial){
//		jhVideoTutorialService.update(jhVideoTutorial);
//
//		return Result.ok();
//	}
//
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("sys:friend:delete")
	public Result delete(@RequestBody Integer[] ids){
		daygoodsDao.deleteBatchFirend(ids);
		return Result.ok();
	}

}
