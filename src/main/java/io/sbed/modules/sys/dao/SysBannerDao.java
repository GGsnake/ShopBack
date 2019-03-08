package io.sbed.modules.sys.dao;

import io.sbed.modules.sys.entity.SysJhBannerImg;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SysBannerDao {
    @Select("select * from  jh_banner_img ")
    List<SysJhBannerImg> query();
    @Select("select count(*) from  jh_banner_img ")
    Integer count();
    @Insert("insert into jh_banner_img(url) values (#{url})")
    Integer save(String url);
}
