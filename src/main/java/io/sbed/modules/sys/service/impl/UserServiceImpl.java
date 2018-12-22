package io.sbed.modules.sys.service.impl;

import com.alibaba.fastjson.JSONObject;
import io.sbed.common.utils.RedisUtils;
import io.sbed.modules.sys.dao.UserDao;
import io.sbed.modules.sys.entity.User;
import io.sbed.modules.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.UUID;
import java.util.logging.Logger;

/**
 * Created by liujupeng on 2018/11/5.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

        @Autowired
        UserDao userMapper;
        private String REDIS_PRIFEX="token:";
        private Long EXPRESS_TIME=36000l;
        @Autowired
        private RedisUtils redisUtils;

        public String userLogin(User user) {
            if (user==null||user.getUserPhone()==null||user.getLoginPwd()==null){
                return "请填写";
            }
            User loginUser =  userMapper.selectByPhone(user.getUserPhone());
            if (loginUser==null){
                return "用户不存在";
            }
            if (!DigestUtils.md5DigestAsHex(user.getLoginPwd().getBytes()).equals(loginUser.getLoginPwd())){
                return null;
            }
            String token= String.valueOf(UUID.randomUUID());
            loginUser.setLoginPwd("");
            redisUtils.set(REDIS_PRIFEX+token, JSONObject.toJSON(loginUser),EXPRESS_TIME);

            return token;
        }


    @Override
    public Boolean createUser(User user) {
        if (user.getUserPhone()==null||user.getLoginSecret()==null||user.getLoginPwd()==null){
            return false;
        }
        String code = redisUtils.get("SMS:"+user.getUserPhone());
        if (code==null||!user.getLoginSecret().equals(code)){
            return false;
        }
        if (user.getPayPwd()!=null){
            //TODO 插入邀请码
        }
        String loginPwd= DigestUtils.md5DigestAsHex(user.getLoginPwd().getBytes());
        user.setLoginPwd(loginPwd);
        Integer loginUser =  userMapper.createUser(user);
        if (loginUser==0){
            return false;
        }

        return true;
    }

    @Override
    public User queryUserByPhone(User user) {
        if (user.getUserPhone()==null){
            return null;
        }
        User info= userMapper.selectByPhone(user.getUserPhone());
        if (info==null){
            return null;
        }
        return info;
    }
}
