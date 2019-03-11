package io.sbed.modules.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import io.sbed.modules.sys.dao.SysJhJdGoodDao;
import io.sbed.modules.sys.entity.SysJhJdGood;
import io.sbed.modules.sys.service.SysJhJdGoodService;

@Service("jhJdGoodService")
public class SysJhJdGoodServiceImpl implements SysJhJdGoodService {

	@Autowired
	private SysJhJdGoodDao jhJdGoodDao;
	
	@Override
	public SysJhJdGood queryObject(Integer id){
		return jhJdGoodDao.queryObject(id);
	}
	
	@Override
	public List<SysJhJdGood> queryList(Map<String, Object> map){
		return jhJdGoodDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return jhJdGoodDao.queryTotal(map);
	}
	
	@Override
	public void save(SysJhJdGood jhJdGood){
		jhJdGoodDao.save(jhJdGood);
	}
	
	@Override
	public void update(SysJhJdGood jhJdGood){
		jhJdGoodDao.update(jhJdGood);
	}
	
	@Override
	public void delete(Integer id){
		jhJdGoodDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		jhJdGoodDao.deleteBatch(ids);
	}
	
}
