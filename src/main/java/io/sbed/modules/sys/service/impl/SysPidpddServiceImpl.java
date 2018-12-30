package io.sbed.modules.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import io.sbed.modules.sys.dao.SysPidpddDao;
import io.sbed.modules.sys.entity.SysPidpdd;
import io.sbed.modules.sys.service.SysPidpddService;

@Service("pidpddService")
public class SysPidpddServiceImpl implements SysPidpddService {

	@Autowired
	private SysPidpddDao pidpddDao;
	
	@Override
	public SysPidpdd queryObject(Integer id){
		return pidpddDao.queryObject(id);
	}
	
	@Override
	public List<SysPidpdd> queryList(Map<String, Object> map){
		return pidpddDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return pidpddDao.queryTotal(map);
	}
	
	@Override
	public void save(SysPidpdd pidpdd){
		pidpddDao.save(pidpdd);
	}
	
	@Override
	public void update(SysPidpdd pidpdd){
		pidpddDao.update(pidpdd);
	}
	
	@Override
	public void delete(Integer id){
		pidpddDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		pidpddDao.deleteBatch(ids);
	}
	
}
