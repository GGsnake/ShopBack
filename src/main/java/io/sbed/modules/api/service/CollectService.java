package io.sbed.modules.api.service;

import com.taobao.api.ApiException;
import io.sbed.modules.api.model.CollectBean;

public interface CollectService {
    void collectTaobao(CollectBean collectBean) throws ApiException;
}
