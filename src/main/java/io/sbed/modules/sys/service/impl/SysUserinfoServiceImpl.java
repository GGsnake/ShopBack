package io.sbed.modules.sys.service.impl;

import io.sbed.modules.sys.dto.SysUserinfoDto;
import io.sbed.modules.sys.emum.Switch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
	public List<SysUserinfoDto> queryList(Map<String, Object> map){
		List<SysUserinfo> var = userinfoDao.queryList(map);
		List<SysUserinfoDto> var1 = new ArrayList<>();
		for(int i=0;i<var.size();i++){
			SysUserinfoDto temp=new SysUserinfoDto();
			temp.setCreatetime(var.get(i).getCreatetime());
			temp.setId(var.get(i).getId());
			temp.setUsersex(Switch.getGrend(var.get(i).getUsersex()));
			temp.setJdpid(var.get(i).getJdpid());
			temp.setPddpid(var.get(i).getPddpid());
			temp.setTbpid(var.get(i).getTbpid());
			temp.setLoginname(var.get(i).getLoginname());
			temp.setStatus(Switch.getStatus(var.get(i).getStatus()));
			temp.setRoleid(Switch.getRole(var.get(i).getRoleid()));
			temp.setWxopenid(var.get(i).getWxopenid());
			temp.setUpdatetime(var.get(i).getUpdatetime());
			temp.setScore(var.get(i).getScore()+"%");
			temp.setUsername(var.get(i).getUsername());
			temp.setLoginpwd(var.get(i).getLoginpwd());
			temp.setUsertotalscore(var.get(i).getUsertotalscore());
			temp.setUserscore(var.get(i).getUserscore());
			temp.setUserphone(var.get(i).getUserphone());
			temp.setUserphoto(var.get(i).getUserphoto());
			temp.setLoginsecret(var.get(i).getLoginsecret());
			var1.add(temp);

		}
		return var1;
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
