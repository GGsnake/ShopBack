package io.sbed.modules.sys.dao;

import io.sbed.modules.sys.dao.BaseDao;
import io.sbed.modules.sys.entity.SysOder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SysOderDao extends BaseDao<SysOder> {
    List<SysOder> queryListFor(Map<String, Object> map);
}
