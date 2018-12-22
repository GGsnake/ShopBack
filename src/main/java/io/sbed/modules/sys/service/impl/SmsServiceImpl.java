package io.sbed.modules.sys.service.impl;

import io.sbed.common.utils.RedisUtils;
import io.sbed.modules.sys.service.SmsService;
import io.sbed.modules.sys.util.SmsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liujupeng on 2018/11/5.
 */
@Service("smsService")
public class SmsServiceImpl implements SmsService {
    @Autowired
    RedisUtils redisUtils;
    @Override
    public Boolean sendSms(String mobile) {
        if (mobile==null){
            return null;
        }
        int code = (int)((Math.random()*9+1)*100000);
        String content = "此次登录验证码"+code+"，验证码五分钟过期【卷皇】";
        int result = SmsUtil.sendSmsLogin(mobile, content);
        if (result==200){
            redisUtils.set("SMS:"+mobile,code,300);
            return true;
        }
        return false;
    }
}
