package io.sbed.modules.sys.service;

import com.taobao.api.ApiException;
import io.sbed.modules.sys.model.CollectBean;

public interface CollectService {
    /**
     * 淘宝采集
     * @param collectBean
     * @throws ApiException
     */
    void collectTaobao(CollectBean collectBean) throws ApiException;
    /**
     * 淘宝采集家居
     * @param collectBean
     * @throws ApiException
     */
    void collectTaobaoHome(CollectBean collectBean) throws ApiException;
    /**
     * 淘宝采集爆款
     * @param collectBean
     * @throws ApiException
     */
    void collectTaobaoHot(CollectBean collectBean) throws ApiException;
    /**
     * 淘宝采集9.9包邮
     * @param collectBean
     * @throws ApiException
     */
    void collectTaobaoNine(CollectBean collectBean) throws ApiException;
    /**
     * 淘宝采集9.9包邮
     * @param collectBean
     * @throws ApiException
     */
    void collectJD(CollectBean collectBean) throws ApiException;
}
