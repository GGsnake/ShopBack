package io.sbed.modules.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import io.sbed.modules.sys.dao.SysJhVideoTutorialDao;
import io.sbed.modules.sys.entity.SysJhVideoTutorial;
import io.sbed.modules.sys.service.SysJhVideoTutorialService;

@Service("jhVideoTutorialService")
public class SysJhVideoTutorialServiceImpl implements SysJhVideoTutorialService {

	@Autowired
	private SysJhVideoTutorialDao jhVideoTutorialDao;
	
	@Override
	public SysJhVideoTutorial queryObject(Integer id){
		return jhVideoTutorialDao.queryObject(id);
	}
	
	@Override
	public List<SysJhVideoTutorial> queryList(Map<String, Object> map){
		return jhVideoTutorialDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return jhVideoTutorialDao.queryTotal(map);
	}
	
	@Override
	public void save(SysJhVideoTutorial jhVideoTutorial){
		jhVideoTutorialDao.save(jhVideoTutorial);
	}
	
	@Override
	public void update(SysJhVideoTutorial jhVideoTutorial){
		jhVideoTutorialDao.update(jhVideoTutorial);
	}
	
	@Override
	public void delete(Integer id){
		jhVideoTutorialDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		jhVideoTutorialDao.deleteBatch(ids);
	}
	
}
