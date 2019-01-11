package io.sbed.modules.sys.service;

import io.sbed.modules.sys.entity.SysJhAdviceOder;
import java.util.List;
import java.util.Map;

/**
 * @author heguoliang
 * @Description: TODO(订单通知表)
 * @date 2019-01-11 16:28:45
 */
public interface SysJhAdviceOderService {
	
	SysJhAdviceOder queryObject(Integer id);
	
	List<SysJhAdviceOder> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysJhAdviceOder jhAdviceOder);
	
	void update(SysJhAdviceOder jhAdviceOder);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

}
