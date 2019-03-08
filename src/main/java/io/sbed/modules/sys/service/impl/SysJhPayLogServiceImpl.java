package io.sbed.modules.sys.service.impl;

import io.sbed.modules.sys.entity.SysUser;
import io.sbed.modules.sys.entity.SysUserinfo;
import io.sbed.modules.sys.service.SysUserService;
import io.sbed.modules.sys.service.SysUserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import io.sbed.modules.sys.dao.SysJhPayLogDao;
import io.sbed.modules.sys.entity.SysJhPayLog;
import io.sbed.modules.sys.service.SysJhPayLogService;

@Service("jhPayLogService")
public class SysJhPayLogServiceImpl implements SysJhPayLogService {

	@Autowired
	private SysJhPayLogDao jhPayLogDao;
	@Autowired
	private SysUserinfoService sysUserService;
	
	@Override
	public SysJhPayLog queryObject(Integer id)
	{
		return jhPayLogDao.queryObject(id);


	}
	
	@Override
	public List<SysJhPayLog> queryList(Map<String, Object> map)
	{
		List<SysJhPayLog> array = jhPayLogDao.queryList(map);
		if (array==null){
			return null;
		}
		array.forEach(data->{
			Integer id = data.getUserid();
			SysUserinfo sysUser = sysUserService.queryObject(id.longValue());
			if (sysUser!=null){
				data.setUsername(sysUser.getUsername());
			}
			else {
				data.setUsername("无用户名");
			}

		});
		return array;
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return jhPayLogDao.queryTotal(map);
	}
	
	@Override
	public void save(SysJhPayLog jhPayLog){
		jhPayLogDao.save(jhPayLog);
	}
	
	@Override
	public void update(SysJhPayLog jhPayLog){
		jhPayLogDao.update(jhPayLog);
	}
	
	@Override
	public void delete(Integer id){
		jhPayLogDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		jhPayLogDao.deleteBatch(ids);
	}
	
}
