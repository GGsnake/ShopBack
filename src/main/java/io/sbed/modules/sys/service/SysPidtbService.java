package io.sbed.modules.sys.service;

import io.sbed.modules.sys.entity.SysPidtb;
import java.util.List;
import java.util.Map;

/**
 * @author heguoliang
 * @Description: TODO(淘宝pid)
 * @date 2018-12-30 16:48:00
 */
public interface SysPidtbService {
	
	SysPidtb queryObject(Integer id);
	
	List<SysPidtb> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysPidtb pidtb);
	
	void update(SysPidtb pidtb);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

}
