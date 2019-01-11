package io.sbed.modules.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import io.sbed.modules.sys.dao.SysJhAdviceOderDao;
import io.sbed.modules.sys.entity.SysJhAdviceOder;
import io.sbed.modules.sys.service.SysJhAdviceOderService;

@Service("jhAdviceOderService")
public class SysJhAdviceOderServiceImpl implements SysJhAdviceOderService {

	@Autowired
	private SysJhAdviceOderDao jhAdviceOderDao;
	
	@Override
	public SysJhAdviceOder queryObject(Integer id){
		return jhAdviceOderDao.queryObject(id);
	}
	
	@Override
	public List<SysJhAdviceOder> queryList(Map<String, Object> map){
		return jhAdviceOderDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return jhAdviceOderDao.queryTotal(map);
	}
	
	@Override
	public void save(SysJhAdviceOder jhAdviceOder){
		jhAdviceOderDao.save(jhAdviceOder);
	}
	
	@Override
	public void update(SysJhAdviceOder jhAdviceOder){
		jhAdviceOderDao.update(jhAdviceOder);
	}
	
	@Override
	public void delete(Integer id){
		jhAdviceOderDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		jhAdviceOderDao.deleteBatch(ids);
	}
	
}
