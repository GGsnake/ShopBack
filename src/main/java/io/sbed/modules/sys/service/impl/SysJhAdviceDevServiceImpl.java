package io.sbed.modules.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import io.sbed.modules.sys.dao.SysJhAdviceDevDao;
import io.sbed.modules.sys.entity.SysJhAdviceDev;
import io.sbed.modules.sys.service.SysJhAdviceDevService;

@Service("jhAdviceDevService")
public class SysJhAdviceDevServiceImpl implements SysJhAdviceDevService {

	@Autowired
	private SysJhAdviceDevDao jhAdviceDevDao;
	
	@Override
	public SysJhAdviceDev queryObject(Integer id){
		return jhAdviceDevDao.queryObject(id);
	}
	
	@Override
	public List<SysJhAdviceDev> queryList(Map<String, Object> map){
		return jhAdviceDevDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return jhAdviceDevDao.queryTotal(map);
	}
	
	@Override
	public void save(SysJhAdviceDev jhAdviceDev){
		jhAdviceDevDao.save(jhAdviceDev);
	}
	
	@Override
	public void update(SysJhAdviceDev jhAdviceDev){
		jhAdviceDevDao.update(jhAdviceDev);
	}
	
	@Override
	public void delete(Integer id){
		jhAdviceDevDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		jhAdviceDevDao.deleteBatch(ids);
	}
	
}
