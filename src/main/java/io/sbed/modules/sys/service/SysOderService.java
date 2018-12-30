package io.sbed.modules.sys.service;

import io.sbed.modules.sys.entity.SysOder;
import java.util.List;
import java.util.Map;

/**
 * @author heguoliang
 * @Description: TODO(拼多多订单表)
 * @date 2018-12-30 17:05:00
 */
public interface SysOderService {
	
	SysOder queryObject(Long id);
	
	List<SysOder> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysOder oder);
	
	void update(SysOder oder);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);

}
