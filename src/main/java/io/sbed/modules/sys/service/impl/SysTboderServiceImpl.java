package io.sbed.modules.sys.service.impl;

import io.sbed.modules.sys.dao.SysTboderDao;
import io.sbed.modules.sys.entity.SysTboder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.sbed.modules.sys.service.SysTboderService;

@Service("tboderService")
public class SysTboderServiceImpl implements SysTboderService {

    @Autowired
    private SysTboderDao tboderDao;

    @Override
    public SysTboder queryObject(Integer id) {

        return tboderDao.queryObject(id);
    }

    @Override
    public List<SysTboder> queryList(Map<String, Object> map) {
        return tboderDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return tboderDao.queryTotal(map);
    }

    @Override
    public void save(SysTboder tboder) {
        tboderDao.save(tboder);
    }

    @Override
    public void update(SysTboder tboder) {
        tboderDao.update(tboder);
    }

    @Override
    public void delete(Integer id) {
        tboderDao.delete(id);
    }

    @Override
    public void deleteBatch(Integer[] ids) {
        tboderDao.deleteBatch(ids);
    }

}
