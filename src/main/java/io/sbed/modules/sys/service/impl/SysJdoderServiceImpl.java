package io.sbed.modules.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import io.sbed.modules.sys.dao.SysJdoderDao;
import io.sbed.modules.sys.entity.SysJdoder;
import io.sbed.modules.sys.service.SysJdoderService;

@Service("jdoderService")
public class SysJdoderServiceImpl implements SysJdoderService {

	@Autowired
	private SysJdoderDao jdoderDao;
	
	@Override
	public SysJdoder queryObject(Integer id){
		return jdoderDao.queryObject(id);
	}
	
	@Override
	public List<SysJdoder> queryList(Map<String, Object> map){
		return jdoderDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return jdoderDao.queryTotal(map);
	}
	
	@Override
	public void save(SysJdoder jdoder){
		jdoderDao.save(jdoder);
	}
	
	@Override
	public void update(SysJdoder jdoder){
		jdoderDao.update(jdoder);
	}
	
	@Override
	public void delete(Integer id){
		jdoderDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		jdoderDao.deleteBatch(ids);
	}
	
}
