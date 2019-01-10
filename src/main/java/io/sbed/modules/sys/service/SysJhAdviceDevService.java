package io.sbed.modules.sys.service;

import io.sbed.modules.sys.entity.SysJhAdviceDev;
import java.util.List;
import java.util.Map;

/**
 * @author heguoliang
 * @Description: TODO(官方订单通知表)
 * @date 2019-01-08 12:08:36
 */
public interface SysJhAdviceDevService {
	
	SysJhAdviceDev queryObject(Integer id);
	
	List<SysJhAdviceDev> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysJhAdviceDev jhAdviceDev);
	
	void update(SysJhAdviceDev jhAdviceDev);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

}
