package io.sbed.modules.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import io.sbed.modules.sys.dao.SysPidtbDao;
import io.sbed.modules.sys.entity.SysPidtb;
import io.sbed.modules.sys.service.SysPidtbService;

@Service("pidtbService")
public class SysPidtbServiceImpl implements SysPidtbService {

	@Autowired
	private SysPidtbDao pidtbDao;
	
	@Override
	public SysPidtb queryObject(Integer id){
		return pidtbDao.queryObject(id);
	}
	
	@Override
	public List<SysPidtb> queryList(Map<String, Object> map){
		return pidtbDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return pidtbDao.queryTotal(map);
	}
	
	@Override
	public void save(SysPidtb pidtb){
		pidtbDao.save(pidtb);
	}
	
	@Override
	public void update(SysPidtb pidtb){
		pidtbDao.update(pidtb);
	}
	
	@Override
	public void delete(Integer id){
		pidtbDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		pidtbDao.deleteBatch(ids);
	}
	
}
