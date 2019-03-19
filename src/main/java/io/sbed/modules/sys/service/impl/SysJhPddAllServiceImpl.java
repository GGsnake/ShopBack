package io.sbed.modules.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import io.sbed.modules.sys.dao.SysJhPddAllDao;
import io.sbed.modules.sys.entity.SysJhPddAll;
import io.sbed.modules.sys.service.SysJhPddAllService;

@Service("jhPddAllService")
public class SysJhPddAllServiceImpl implements SysJhPddAllService {

	@Autowired
	private SysJhPddAllDao jhPddAllDao;
	
	@Override
	public SysJhPddAll queryObject(Integer id){
		return jhPddAllDao.queryObject(id);
	}
	
	@Override
	public List<SysJhPddAll> queryList(Map<String, Object> map){
		return jhPddAllDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return jhPddAllDao.queryTotal(map);
	}
	
	@Override
	public void save(SysJhPddAll jhPddAll){
		jhPddAllDao.save(jhPddAll);
	}
	
	@Override
	public void update(SysJhPddAll jhPddAll){
		jhPddAllDao.update(jhPddAll);
	}
	
	@Override
	public void delete(Integer id){
		jhPddAllDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		jhPddAllDao.deleteBatch(ids);
	}
	
}
