package io.sbed.modules.sys.service;

import io.sbed.modules.sys.entity.SysJhTaobaoAll;

import java.util.List;
import java.util.Map;

/**
 * @author heguoliang
 * @Description: TODO(淘宝采集表)
 * @date 2019-03-08 12:12:22
 */
public interface SysJhTaobaoAllService {
	
	SysJhTaobaoAll queryObject(Integer id);
	
	List<SysJhTaobaoAll> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysJhTaobaoAll jhTaobaoAll);


	void update(SysJhTaobaoAll jhTaobaoAll);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

}
