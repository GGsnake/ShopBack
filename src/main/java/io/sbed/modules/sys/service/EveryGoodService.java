package io.sbed.modules.sys.service;

import com.alibaba.fastjson.JSONObject;
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

    /**
     * 创建京东推广位
     * @param count
     * @return
     */
    public JSONObject createJdPid(Integer count);
    /**
     * 创建淘宝推广位
     * @param count
     * @return
     */
    public JSONObject createTbPid(Integer count);
    /**
     * 创建拼多多推广位
     * @param count
     * @return
     */
    public JSONObject createPddPid(Integer count);
}
