package io.sbed.modules.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import io.sbed.modules.sys.dao.SysOderDao;
import io.sbed.modules.sys.entity.SysOder;
import io.sbed.modules.sys.service.SysOderService;

@Service("oderService")
public class SysOderServiceImpl implements SysOderService {

	@Autowired
	private SysOderDao oderDao;
	
	@Override
	public SysOder queryObject(Long id){
		return oderDao.queryObject(id);
	}
	
	@Override
	public List<SysOder> queryList(Map<String, Object> map){
		return oderDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return oderDao.queryTotal(map);
	}
	
	@Override
	public void save(SysOder oder){
		oderDao.save(oder);
	}
	
	@Override
	public void update(SysOder oder){
		oderDao.update(oder);
	}
	
	@Override
	public void delete(Long id){
		oderDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		oderDao.deleteBatch(ids);
	}
	
}
