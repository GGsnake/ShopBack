package io.sbed.modules.sys.controller;

import com.alibaba.fastjson.JSONObject;
import com.taobao.api.ApiException;
import io.sbed.common.utils.RedisUtils;
import io.sbed.common.utils.Result;
import io.sbed.modules.sys.dao.SettingDao;
import io.sbed.modules.sys.model.CollectBean;
import io.sbed.modules.sys.service.CollectService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ljp
 * @Description: TODO()
 * @date 2019-3-7 14:49
 */
@Log
@RestController
@RequestMapping("/sys/config/api")
@CrossOrigin(origins = "*")
public class CollectController {
    @Autowired
    private CollectService collectService;
    @Autowired
    private SettingDao settingDao;

    @Autowired
    private RedisUtils redisUtils;

    @PostMapping("/collect/tb")
    public Result collectListTb(@RequestBody String body) throws ApiException {
//        Config config = settingDao.querySetting("now");
        boolean tbcollect = redisUtils.exists("tbcollect");
        if (tbcollect) {
            return Result.ok("采集器正在运行中 请稍后");
        }
        CollectBean collectBean = JSONObject.parseObject(body, CollectBean.class);
        log.warning("淘宝开始采集");
//        config.setConfigValue("1");
//        settingDao.update(config);
            redisUtils.set("tbcollect","a");
        collectService.collectTaobaoHot(collectBean);
        return Result.ok("已开始采集 请前往总分类查看新数据");
    }

    @PostMapping("/collect/jd")
    public Result collectListJd(@RequestBody String body) throws ApiException {
        boolean tbcollect = redisUtils.exists("jdcollect");
        if (tbcollect) {
            return Result.ok("采集器正在运行中 请稍后");
        }
        CollectBean collectBean = JSONObject.parseObject(body, CollectBean.class);
        log.warning("京东开始采集");
        redisUtils.set("jdcollect","s");
        collectService.collectJD(collectBean);
        return Result.ok("已开始采集 请前往总分类查看新数据");
    }

    @PostMapping("/collect/pdd")
    public Result collectListPdd(@RequestBody String body) throws ApiException {
        boolean tbcollect = redisUtils.exists("pddcollect");
        if (tbcollect) {
            return Result.ok("采集器正在运行中 请稍后");
        }
        CollectBean collectBean = JSONObject.parseObject(body, CollectBean.class);
        log.warning("拼多多开始");
        redisUtils.set("pddcollect","s");
        collectService.collectPDD(collectBean);
        return Result.ok("已开始采集 请前往总分类查看新数据");
    }


}