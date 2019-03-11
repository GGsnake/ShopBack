package io.sbed.modules.sys.service.impl;

import io.sbed.modules.sys.dao.SysJhTaobaoAllDao;
import io.sbed.modules.sys.entity.SysJhTaobaoAll;
import io.sbed.modules.sys.service.SysJhTaobaoAllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("jhTaobaoAllService")
public class SysJhTaobaoAllServiceImpl implements SysJhTaobaoAllService {

	@Autowired
	private SysJhTaobaoAllDao jhTaobaoAllDao;
	
	@Override
	public SysJhTaobaoAll queryObject(Integer id){
		return jhTaobaoAllDao.queryObject(id);
	}
	
	@Override
	public List<SysJhTaobaoAll> queryList(Map<String, Object> map){
		return jhTaobaoAllDao.queryListOpt(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return jhTaobaoAllDao.queryTotalOpt(map);
	}
	
	@Override
	public void save(SysJhTaobaoAll jhTaobaoAll){
		jhTaobaoAllDao.save(jhTaobaoAll);
	}
	
	@Override
	public void update(SysJhTaobaoAll jhTaobaoAll){
		jhTaobaoAllDao.update(jhTaobaoAll);
	}
	
	@Override
	public void delete(Integer id){
		jhTaobaoAllDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		jhTaobaoAllDao.deleteBatch(ids);
	}
	
}
