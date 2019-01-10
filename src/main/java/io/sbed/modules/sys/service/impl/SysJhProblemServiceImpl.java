package io.sbed.modules.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import io.sbed.modules.sys.dao.SysJhProblemDao;
import io.sbed.modules.sys.entity.SysJhProblem;
import io.sbed.modules.sys.service.SysJhProblemService;

@Service("jhProblemService")
public class SysJhProblemServiceImpl implements SysJhProblemService {

	@Autowired
	private SysJhProblemDao jhProblemDao;
	
	@Override
	public SysJhProblem queryObject(Integer id){
		return jhProblemDao.queryObject(id);
	}
	
	@Override
	public List<SysJhProblem> queryList(Map<String, Object> map){
		return jhProblemDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return jhProblemDao.queryTotal(map);
	}
	
	@Override
	public void save(SysJhProblem jhProblem){
		jhProblemDao.save(jhProblem);
	}
	
	@Override
	public void update(SysJhProblem jhProblem){
		jhProblemDao.update(jhProblem);
	}
	
	@Override
	public void delete(Integer id){
		jhProblemDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		jhProblemDao.deleteBatch(ids);
	}
	
}
