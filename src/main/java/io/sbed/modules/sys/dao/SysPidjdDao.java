package io.sbed.modules.sys.dao;

import io.sbed.modules.sys.model.JdPid;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysPidjdDao  {
    @Insert("insert into pidjd(pid) value(#{pid})")
	Integer addPidJd(Long pid);

}
