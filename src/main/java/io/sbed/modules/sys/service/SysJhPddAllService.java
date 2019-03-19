package io.sbed.modules.sys.service;

import io.sbed.modules.sys.entity.SysJhPddAll;
import java.util.List;
import java.util.Map;

/**
 * @author heguoliang
 * @Description: TODO(拼多多采集表)
 * @date 2019-03-13 09:29:12
 */
public interface SysJhPddAllService {
	
	SysJhPddAll queryObject(Integer id);
	
	List<SysJhPddAll> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysJhPddAll jhPddAll);
	
	void update(SysJhPddAll jhPddAll);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

}
