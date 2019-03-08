package io.sbed.modules.sys.service;

import io.sbed.modules.sys.entity.SysJhBannerImg;
import java.util.List;
import java.util.Map;

/**
 * @author heguoliang
 * @Description: TODO(轮播图)
 * @date 2019-02-22 11:54:29
 */
public interface SysJhBannerImgService {
	
	SysJhBannerImg queryObject(Integer id);
	
	List<SysJhBannerImg> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysJhBannerImg jhBannerImg);
	
	void update(SysJhBannerImg jhBannerImg);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

}
