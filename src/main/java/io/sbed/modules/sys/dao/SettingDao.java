package io.sbed.modules.sys.dao;

import io.sbed.modules.sys.entity.SysConfig;
import io.sbed.modules.sys.model.Config;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface SettingDao{
    //轮播图
    @Select("select url from jh_banner_img order by id desc limit 3")
    List<String> queryBanner();

    /**
     * 配置查找
     * @return
     */
    @Select("select * from jh_config where ConfigNo=#{no}")
    Config querySetting(String no); /**
     * 配置查找
     * @return
     */
    List<Config> queryListSetting(Map<String,Object> map);

    /**
     * 根据key，更新value
     */
    int update(Config config);
    /**
     * 根据key，更新value
     */
    int save(Config config);
    /**
     * 根据key，更新value
     */
    @Select("select count(*) from jh_config ")
    int count();

}
