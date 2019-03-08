package io.sbed.modules.sys.dao;

import io.sbed.modules.sys.entity.SysUserinfo;
import io.sbed.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SysUserinfoDao extends BaseDao<SysUserinfo> {

    int queryTotalAgent(Map<String, Object> map);


    List<SysUserinfo> queryAgentList(Map<String, Object> map);


}
