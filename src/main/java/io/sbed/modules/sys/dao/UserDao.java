package io.sbed.modules.sys.dao;

import io.sbed.modules.sys.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by liujupeng on 2018/11/5.
 */
@Mapper
public interface UserDao {

    User selectByName(@Param("userPhone")String userPhone);
    User queryUser(@Param("user") User user);
    Integer createUser(@Param("user") User user);
    User selectByPhone(@Param("userPhone") String userPhone);

}
