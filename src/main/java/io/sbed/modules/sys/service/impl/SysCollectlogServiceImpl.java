package io.sbed.modules.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import io.sbed.modules.sys.dao.SysCollectlogDao;
import io.sbed.modules.sys.entity.SysCollectlog;
import io.sbed.modules.sys.service.SysCollectlogService;

@Service("collectlogService")
public class SysCollectlogServiceImpl implements SysCollectlogService {

	@Autowired
	private SysCollectlogDao collectlogDao;
	
	@Override
	public SysCollectlog queryObject(Integer id){
		return collectlogDao.queryObject(id);
	}
	
	@Override
	public List<SysCollectlog> queryList(Map<String, Object> map){
		return collectlogDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return collectlogDao.queryTotal(map);
	}
	
	@Override
	public void save(SysCollectlog collectlog){
		collectlogDao.save(collectlog);
	}
	
	@Override
	public void update(SysCollectlog collectlog){
		collectlogDao.update(collectlog);
	}
	
	@Override
	public void delete(Integer id){
		collectlogDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		collectlogDao.deleteBatch(ids);
	}
	
}
