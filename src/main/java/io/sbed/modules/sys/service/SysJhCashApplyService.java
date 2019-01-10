package io.sbed.modules.sys.service;

import io.sbed.modules.sys.entity.SysJhCashApply;
import java.util.List;
import java.util.Map;

/**
 * @author heguoliang
 * @Description: TODO(提现申请表)
 * @date 2019-01-09 10:57:38
 */
public interface SysJhCashApplyService {
	
	SysJhCashApply queryObject(Integer id);
	
	List<SysJhCashApply> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysJhCashApply jhCashApply);
	
	void update(SysJhCashApply jhCashApply);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

}
