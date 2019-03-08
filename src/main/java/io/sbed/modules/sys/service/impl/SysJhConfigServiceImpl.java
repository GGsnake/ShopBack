package io.sbed.modules.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import io.sbed.modules.sys.dao.SysJhConfigDao;
import io.sbed.modules.sys.entity.SysJhConfig;
import io.sbed.modules.sys.service.SysJhConfigService;

@Service("jhConfigService")
public class SysJhConfigServiceImpl implements SysJhConfigService {

	@Autowired
	private SysJhConfigDao jhConfigDao;
	
	@Override
	public SysJhConfig queryObject(Long id){
		return jhConfigDao.queryObject(id);
	}
	
	@Override
	public List<SysJhConfig> queryList(Map<String, Object> map){
		return jhConfigDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return jhConfigDao.queryTotal(map);
	}
	
	@Override
	public void save(SysJhConfig jhConfig){
		jhConfigDao.save(jhConfig);
	}
	
	@Override
	public void update(SysJhConfig jhConfig){
		jhConfigDao.update(jhConfig);
	}
	
	@Override
	public void delete(Long id){
		jhConfigDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		jhConfigDao.deleteBatch(ids);
	}
	
}
