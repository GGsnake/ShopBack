package io.sbed.modules.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import io.sbed.modules.sys.dao.SysUserinfoDao;
import io.sbed.modules.sys.entity.SysUserinfo;
import io.sbed.modules.sys.service.SysUserinfoService;

@Service("userinfoService")
public class SysUserinfoServiceImpl implements SysUserinfoService {

	@Autowired
	private SysUserinfoDao userinfoDao;
	
	@Override
	public SysUserinfo queryObject(Long id){
		return userinfoDao.queryObject(id);
	}
	
	@Override
	public List<SysUserinfo> queryList(Map<String, Object> map){
		return userinfoDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return userinfoDao.queryTotal(map);
	}
	
	@Override
	public void save(SysUserinfo userinfo){
		userinfoDao.save(userinfo);
	}
	
	@Override
	public void update(SysUserinfo userinfo){
		userinfoDao.update(userinfo);
	}
	
	@Override
	public void delete(Long id){
		userinfoDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		userinfoDao.deleteBatch(ids);
	}
	
}
