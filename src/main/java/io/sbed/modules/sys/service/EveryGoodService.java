package io.sbed.modules.sys.service;

import com.zyqhw.springboot.util.PageParam;
import io.sbed.modules.sys.entity.PddGood;

import java.util.List;

/**
 * Created by liujupeng on 2018/11/2.
 */
public interface EveryGoodService {

    /**
     * 拼多多查询
     */
    public List<PddGood> queryPddGoods(PageParam pageParam, Integer sort_type, String keyword);    /**
     * 拼多多查询
     */
    public void queryJdGoods(PageParam pageParam,Integer sort_type,String keyword);
}
