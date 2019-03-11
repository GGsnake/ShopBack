package io.sbed.modules.sys.controller;

import com.alibaba.fastjson.JSONObject;
import com.taobao.api.ApiException;
import io.sbed.common.utils.Result;
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

    @PostMapping("/collect/tb")
    public Result collectList(@RequestBody String body) throws ApiException {
        CollectBean collectBean = JSONObject.parseObject(body, CollectBean.class);
        log.warning("淘宝开始采集");
        collectService.collectTaobao(collectBean);
        return Result.ok("已开始采集 请前往总分类查看新数据");
    }

    @PostMapping("/collect/jd")
    public Result collectListjd(@RequestBody String body) throws ApiException {
        CollectBean collectBean = JSONObject.parseObject(body, CollectBean.class);
        log.warning("京东开始采集");
        collectService.collectJD(collectBean);
        return Result.ok("已开始采集 请前往总分类查看新数据");
    }




}