package io.sbed.modules.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import io.sbed.modules.sys.dao.SysPidjdDao;
import io.sbed.modules.sys.entity.SysPidjd;
import io.sbed.modules.sys.service.SysPidjdService;

@Service("pidjdService")
public class SysPidjdServiceImpl implements SysPidjdService {

	@Autowired
	private SysPidjdDao pidjdDao;
	
	@Override
	public SysPidjd queryObject(Integer id){
		return pidjdDao.queryObject(id);
	}
	
	@Override
	public List<SysPidjd> queryList(Map<String, Object> map){
		return pidjdDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return pidjdDao.queryTotal(map);
	}
	
	@Override
	public void save(SysPidjd pidjd){
		pidjdDao.save(pidjd);
	}
	
	@Override
	public void update(SysPidjd pidjd){
		pidjdDao.update(pidjd);
	}
	
	@Override
	public void delete(Integer id){
		pidjdDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		pidjdDao.deleteBatch(ids);
	}
	
}
