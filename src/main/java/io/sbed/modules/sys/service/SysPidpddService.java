package io.sbed.modules.sys.service;

import io.sbed.modules.sys.entity.SysPidpdd;
import java.util.List;
import java.util.Map;

/**
 * @author heguoliang
 * @Description: TODO(拼多多pid)
 * @date 2018-12-30 16:48:00
 */
public interface SysPidpddService {
	
	SysPidpdd queryObject(Integer id);
	
	List<SysPidpdd> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysPidpdd pidpdd);
	
	void update(SysPidpdd pidpdd);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

}
