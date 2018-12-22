package io.sbed.modules.api.controller;

import com.zyqhw.springboot.util.PageParam;
import io.sbed.modules.api.annotation.Login;
import io.sbed.modules.api.utils.JwtUtils;
import io.sbed.modules.api.utils.PddSignUtil;
import io.sbed.modules.sys.entity.PddGood;
import io.sbed.modules.sys.entity.SysUser;
import io.sbed.modules.sys.entity.User;
import io.sbed.modules.sys.service.EveryGoodService;
import io.sbed.modules.sys.service.SmsService;
import io.sbed.modules.sys.service.SysUserService;
import io.sbed.common.utils.Result;

import io.sbed.modules.sys.service.UserService;
import io.sbed.modules.sys.util.HttpRequest;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;

/**
 * @author heguoliang
 * @Description: TODO()
 * @date 2017-9-27 14:49
 */
@RestController
@RequestMapping("/api")
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);
    static final String REFRESH_TOKEN = "75412af6-b87e-4279-81fd-0507c52dfb26";
    static final String TIME = "1541039628602";
    static final String ACCESS_TOKEN = "ed69acd6-dbc7-4fc5-a830-135e63d19692";
    static final String MyappKey = "D4236C4D973B80F70F8B8929E2C226CB";
    static final String MyappSecret = "2d0d4a0563e543dab280774a8b946db3";
    static final String URL = "https://api.jd.com/routerjson";

    static final String CLIENTID = "bbc1737d63e44e278dbffa9e96a7eca3";
    static final String SECRET = "5e1a03eb561bac0c63c5efc8c1472119fc3ad405";
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private SmsService smsService;

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private UserService userService;

    @Autowired
    private EveryGoodService everyGoodService;

    @GetMapping("/login")
    public Result login(String username, String password) {
        //用户信息
        SysUser user = sysUserService.queryByUserName(username);

        //账号不存在
        if (user == null) {
            return Result.error("账号不存在");
        }


        //密码错误
        if (!user.getPassword().equals(new Sha256Hash(password, user.getSalt()).toHex())) {
            return Result.error("密码不正确");
        }
        //生成token
        String token = jwtUtils.generateToken(user.getId());
        Map<String, Object> map = new HashMap<>();
        map.put("userId", user.getId());
        map.put("token", token);
        map.put("expire", jwtUtils.getExpire());

        Result r = Result.ok().put(map);
        return r;
    }

    @Login
    @GetMapping("/test")
    public Result test() {
        return Result.ok();
    }

    @GetMapping("/ces")
    public String getOrderSearchResponse() throws IOException {
        String type = "pdd.ddk.goods.search";
        String algo = null;
        String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
        //生成sign
        String sign = "5e1a03eb561bac0c63c5efc8c1472119fc3ad405client_idbbc1737d63e44e278dbffa9e96a7eca3data_typeJSONsort_type0timestamp"
                + timestamp + "typepdd.ddk.goods.searchwith_coupontrue5e1a03eb561bac0c63c5efc8c1472119fc3ad405";
        String s = PddSignUtil.pddSign(sign);
        SortedMap<String, String> mapsign = new TreeMap<>();
        mapsign.put("client_id", CLIENTID);
        mapsign.put("type", type);
        mapsign.put("timestamp", timestamp);
        mapsign.put("data_type", "JSON");
        mapsign.put("sign", s.toUpperCase());
        mapsign.put("sort_type", "0");
        mapsign.put("with_coupon", "true");
        String res = HttpRequest.sendPost("https://gw-api.pinduoduo.com/api/router", mapsign);

        return res;
//


    }

    @PostMapping("/pddGoodList")
    public List<PddGood> pddGoodList(@RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
                                     @RequestParam(value = "pagesize", defaultValue = "10", required = false) Integer pagesize,
                                     @RequestParam(value = "sort", defaultValue = "0", required = false) Integer sort,
                                     @RequestParam(value = "keyword", defaultValue = "", required = false) String keyword)
    {
        PageParam pageParam = new PageParam();
        pageParam.setPageNo(page);
        pageParam.setPageSize(pagesize);
        List<PddGood> pddGoods = everyGoodService.queryPddGoods(pageParam, sort, keyword);
        return pddGoods;

    }
//
//    @GetMapping("/jdGoodList")
//    public UnionSearchGoodsParamQueryResponse jdGoodList() throws JdException {
////        创建请求
//        everyGoodService.queryJdGoods(null,null,null);
//        return null;
////
//
//
//    }

    @PostMapping("/login")
    public Result logintos(@RequestParam(value = "mobile") String mobile,
                        @RequestParam(value = "pwd") String pwd)  {
//        创建请求
        User user=new User();
        user.setLoginName(mobile);
        user.setLoginPwd(pwd);
        String token = userService.userLogin(user);
        if (token==null){
            return Result.error("");
        }
        return Result.ok(token);
//


    }

    @PostMapping(value = "/sendSMS")
    public Result sendSMS(@RequestParam(value = "mobile") String mobile){
        User user=new User();
        user.setUserPhone(mobile);
        User info = userService.queryUserByPhone(user);
        if (info!=null){
            return Result.error("该手机号已经注册");
        }
        Boolean flag = smsService.sendSms(mobile);
        if (flag){
            return Result.ok("短信发送成功");
        }
//        JSONObject jsonObject = SmsUtil.sendLoginSmsVcode("13692939345");
        return Result.error("短信发送间隔太快，请稍后");
    }



}