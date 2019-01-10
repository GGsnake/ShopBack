package io.sbed.modules.sys.service;

import io.sbed.modules.sys.entity.SysJhVideoTutorial;
import java.util.List;
import java.util.Map;

/**
 * @author heguoliang
 * @Description: TODO(视频教程)
 * @date 2019-01-09 16:28:58
 */
public interface SysJhVideoTutorialService {
	
	SysJhVideoTutorial queryObject(Integer id);
	
	List<SysJhVideoTutorial> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysJhVideoTutorial jhVideoTutorial);
	
	void update(SysJhVideoTutorial jhVideoTutorial);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

}
