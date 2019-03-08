package io.sbed.modules.sys.dao;

import io.sbed.modules.sys.entity.SysJhCashApply;
import io.sbed.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SysJhCashApplyDao extends BaseDao<SysJhCashApply> {
    int queryAgentTotal(Map<String, Object> map);

    List<SysJhCashApply> queryAgentList(Map<String, Object> map);
}
