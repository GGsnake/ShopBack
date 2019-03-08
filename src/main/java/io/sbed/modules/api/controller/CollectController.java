package io.sbed.modules.api.controller;

import com.alibaba.fastjson.JSONObject;
import com.zyqhw.springboot.util.PageParam;
import io.sbed.common.utils.Result;
import io.sbed.modules.api.annotation.Login;
import io.sbed.modules.api.model.CollectBean;
import io.sbed.modules.api.utils.JwtUtils;
import io.sbed.modules.api.utils.PddSignUtil;
import io.sbed.modules.sys.entity.PddGood;
import io.sbed.modules.sys.entity.SysUser;
import io.sbed.modules.sys.entity.User;
import io.sbed.modules.sys.service.EveryGoodService;
import io.sbed.modules.sys.service.SmsService;
import io.sbed.modules.sys.service.SysUserService;
import io.sbed.modules.sys.service.UserService;
import io.sbed.modules.sys.util.HttpRequest;
import io.sbed.modules.sys.util.SmsUtil;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;

/**
 * @author ljp
 * @Description: TODO()
 * @date 2019-3-7 14:49
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class CollectController {


    @Autowired
    private SmsService smsService;



    @PostMapping("/collect")
    public Result collectStart(@RequestBody String body)
    {
        CollectBean collectBean = JSONObject.parseObject(body, CollectBean.class);

        return Result.ok();
    }


    @PostMapping("/collect/list")
    public Result collectList(@RequestBody String body)
    {
        CollectBean collectBean = JSONObject.parseObject(body, CollectBean.class);
        System.out.println(collectBean.toString());
        return Result.ok();
    }




}