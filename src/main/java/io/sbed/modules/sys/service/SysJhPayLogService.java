package io.sbed.modules.sys.service;

import io.sbed.modules.sys.entity.SysJhPayLog;
import java.util.List;
import java.util.Map;

/**
 * @author heguoliang
 * @Description: TODO(付款记录)
 * @date 2019-03-04 20:36:08
 */
public interface SysJhPayLogService {
	
	SysJhPayLog queryObject(Integer id);
	
	List<SysJhPayLog> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysJhPayLog jhPayLog);
	
	void update(SysJhPayLog jhPayLog);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

}
