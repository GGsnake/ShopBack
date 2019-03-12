package io.sbed.modules.sys.dao;

import io.sbed.modules.sys.entity.SysJhTaobaoAll;
import io.sbed.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SysJhTaobaoAllDao extends BaseDao<SysJhTaobaoAll> {

    int queryTotalOpt(Map<String, Object> map);
    int queryTotalOptAll(Map<String, Object> map);



    List<SysJhTaobaoAll> queryListOpt(Map<String, Object> map);
    List<SysJhTaobaoAll> queryListOptAll(Map<String, Object> map);
}
