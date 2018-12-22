package io.sbed.modules.sys.service;

import io.sbed.modules.sys.entity.SysTboder;

import java.util.List;
import java.util.Map;

/**
 * @author heguoliang
 * @Description: TODO(淘宝订单表)
 * @date 2018-12-20 10:12:57
 */
public interface SysTboderService {
	
	SysTboder queryObject(Integer id);
	
	List<SysTboder> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysTboder tboder);
	
	void update(SysTboder tboder);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

}
