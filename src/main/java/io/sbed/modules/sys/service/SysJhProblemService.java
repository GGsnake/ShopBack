package io.sbed.modules.sys.service;

import io.sbed.modules.sys.entity.SysJhProblem;
import java.util.List;
import java.util.Map;

/**
 * @author heguoliang
 * @Description: TODO(常见问题)
 * @date 2019-01-09 16:28:57
 */
public interface SysJhProblemService {
	
	SysJhProblem queryObject(Integer id);
	
	List<SysJhProblem> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysJhProblem jhProblem);
	
	void update(SysJhProblem jhProblem);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

}
