package io.sbed.modules.sys.service;

import io.sbed.modules.sys.entity.SysUserinfo;
import java.util.List;
import java.util.Map;

/**
 * @author heguoliang
 * @Description: TODO(商城用户表)
 * @date 2018-12-30 16:48:00
 */
public interface SysUserinfoService {
	
	SysUserinfo queryObject(Long id);
	
	List<SysUserinfo> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysUserinfo userinfo);
	
	void update(SysUserinfo userinfo);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);

}
