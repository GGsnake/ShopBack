package io.sbed.modules.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import io.sbed.modules.sys.dao.SysJhCashApplyDao;
import io.sbed.modules.sys.entity.SysJhCashApply;
import io.sbed.modules.sys.service.SysJhCashApplyService;

@Service("jhCashApplyService")
public class SysJhCashApplyServiceImpl implements SysJhCashApplyService {

	@Autowired
	private SysJhCashApplyDao jhCashApplyDao;
	
	@Override
	public SysJhCashApply queryObject(Integer id){
		return jhCashApplyDao.queryObject(id);
	}
	
	@Override
	public List<SysJhCashApply> queryList(Map<String, Object> map){
		return jhCashApplyDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return jhCashApplyDao.queryTotal(map);
	}
	
	@Override
	public void save(SysJhCashApply jhCashApply){
		jhCashApplyDao.save(jhCashApply);
	}
	
	@Override
	public void update(SysJhCashApply jhCashApply){
		jhCashApplyDao.update(jhCashApply);
	}
	
	@Override
	public void delete(Integer id){
		jhCashApplyDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		jhCashApplyDao.deleteBatch(ids);
	}
	
}
