package io.sbed.modules.sys.service;

import io.sbed.modules.sys.entity.SysJhConfig;
import java.util.List;
import java.util.Map;

/**
 * @author heguoliang
 * @Description: TODO()
 * @date 2019-03-07 09:37:51
 */
public interface SysJhConfigService {
	
	SysJhConfig queryObject(Long id);
	
	List<SysJhConfig> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysJhConfig jhConfig);
	
	void update(SysJhConfig jhConfig);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);

}
