package io.sbed.modules.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import io.sbed.modules.sys.dao.SysJhBannerImgDao;
import io.sbed.modules.sys.entity.SysJhBannerImg;
import io.sbed.modules.sys.service.SysJhBannerImgService;

@Service("jhBannerImgService")
public class SysJhBannerImgServiceImpl implements SysJhBannerImgService {

	@Autowired
	private SysJhBannerImgDao jhBannerImgDao;
	
	@Override
	public SysJhBannerImg queryObject(Integer id){
		return jhBannerImgDao.queryObject(id);
	}
	
	@Override
	public List<SysJhBannerImg> queryList(Map<String, Object> map){
		return jhBannerImgDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return jhBannerImgDao.queryTotal(map);
	}
	
	@Override
	public void save(SysJhBannerImg jhBannerImg){
		jhBannerImgDao.save(jhBannerImg);
	}
	
	@Override
	public void update(SysJhBannerImg jhBannerImg){
		jhBannerImgDao.update(jhBannerImg);
	}
	
	@Override
	public void delete(Integer id){
		jhBannerImgDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		jhBannerImgDao.deleteBatch(ids);
	}
	
}
