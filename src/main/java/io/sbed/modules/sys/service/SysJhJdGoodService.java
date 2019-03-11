package io.sbed.modules.sys.service;

import io.sbed.modules.sys.entity.SysJhJdGood;
import java.util.List;
import java.util.Map;

/**
 * @author heguoliang
 * @Description: TODO(淘宝采集表2)
 * @date 2019-03-09 13:54:37
 */
public interface SysJhJdGoodService {
	
	SysJhJdGood queryObject(Integer id);
	
	List<SysJhJdGood> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysJhJdGood jhJdGood);
	
	void update(SysJhJdGood jhJdGood);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

}
