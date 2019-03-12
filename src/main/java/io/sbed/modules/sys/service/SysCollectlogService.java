package io.sbed.modules.sys.service;

import io.sbed.modules.sys.entity.SysCollectlog;
import java.util.List;
import java.util.Map;

/**
 * @author heguoliang
 * @Description: TODO(收集)
 * @date 2019-03-11 18:42:43
 */
public interface SysCollectlogService {
	
	SysCollectlog queryObject(Integer id);
	
	List<SysCollectlog> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysCollectlog collectlog);
	
	void update(SysCollectlog collectlog);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

}
