package io.sbed.modules.sys.service;

import io.sbed.modules.sys.entity.User;

/**
 * Created by liujupeng on 2018/11/5.
 */
public interface UserService {
    String userLogin(User user);
    Boolean createUser(User user);
    User queryUserByPhone(User user);

}
