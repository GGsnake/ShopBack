package io.sbed.modules.sys.service.impl;

import io.sbed.modules.sys.entity.SysUserinfo;
import io.sbed.modules.sys.service.SysUserinfoService;
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

    @Autowired
    private SysUserinfoService sysUserinfoService;

    @Override
    public SysJhCashApply queryObject(Integer id) {
        return jhCashApplyDao.queryObject(id);
    }

    @Override
    public List<SysJhCashApply> queryList(Map<String, Object> map) {
        List<SysJhCashApply> array = jhCashApplyDao.queryList(map);
        if (array==null){
            return null;
        }
        array.forEach(data->{
            Integer id = data.getUserid();
            SysUserinfo sysUser = sysUserinfoService.queryObject(id.longValue());
            if (sysUser!=null){
                data.setUsername(sysUser.getUsername());
            }
        });
        return array;
    }

    @Override
    public List<SysJhCashApply> queryAgentList(Map<String, Object> map) {
        List<SysJhCashApply> array = jhCashApplyDao.queryAgentList(map);
        if (array==null){
            return null;
        }
        array.forEach(data->{
            Integer id = data.getUserid();
            SysUserinfo sysUser = sysUserinfoService.queryObject(id.longValue());
            if (sysUser!=null){
                data.setUsername(sysUser.getUsername());
            }
        });
        return array;
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return jhCashApplyDao.queryTotal(map);
    }

    @Override
    public int queryAgentTotal(Map<String, Object> map) {
        return jhCashApplyDao.queryAgentTotal(map);
    }

    @Override
    public void save(SysJhCashApply jhCashApply) {
        jhCashApplyDao.save(jhCashApply);
    }

    @Override
    public void update(SysJhCashApply jhCashApply) {
        jhCashApplyDao.update(jhCashApply);
    }

    @Override
    public void delete(Integer id) {
        jhCashApplyDao.delete(id);
    }

    @Override
    public void deleteBatch(Integer[] ids) {
        jhCashApplyDao.deleteBatch(ids);
    }

}
