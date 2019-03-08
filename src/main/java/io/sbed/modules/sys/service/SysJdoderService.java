package io.sbed.modules.sys.service;

import io.sbed.modules.sys.entity.SysJdoder;
import java.util.List;
import java.util.Map;

/**
 * @author heguoliang
 * @Description: TODO(京东订单表)
 * @date 2019-02-23 16:19:01
 */
public interface SysJdoderService {
	
	SysJdoder queryObject(Integer id);
	
	List<SysJdoder> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysJdoder jdoder);
	
	void update(SysJdoder jdoder);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

}
