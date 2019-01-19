package io.sbed.modules.sys.dao;

import io.sbed.modules.sys.entity.SysPidjd;
import io.sbed.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysPidjdDao extends BaseDao<SysPidjd> {
    @Insert("insert ignore jh_pid_jd(pid) value(#{pid})")
    Integer addPidJd(Long pid);

    @Insert("insert ignore jh_pid_pdd(pid) value(#{pid})")
    Integer addPidPdd(String pid);

    @Insert("insert into jh_pid_tb(pid) value(#{pid})")
    Integer addPidTb(Long pid);

}
