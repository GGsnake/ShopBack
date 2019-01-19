package io.sbed.modules.sys.service;

import io.sbed.modules.sys.entity.SysPidjd;
import java.util.List;
import java.util.Map;

/**
 * @author heguoliang
 * @Description: TODO(京东pid)
 * @date 2019-01-16 10:11:39
 */
public interface SysPidjdService {
	
	SysPidjd queryObject(Integer id);
	
	List<SysPidjd> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysPidjd pidjd);
	
	void update(SysPidjd pidjd);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

}
