package io.sbed.modules.api.service.impl;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkDgMaterialOptionalRequest;
import com.taobao.api.response.TbkDgMaterialOptionalResponse;
import io.sbed.modules.api.model.CollectBean;
import io.sbed.modules.api.service.CollectService;
import io.sbed.modules.sys.dao.SettingDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectServiceImpl implements CollectService {
    @Autowired
    private SettingDao settingDao;

    @Override
    public void collectTaobao(CollectBean collectBean) throws ApiException {
        String TAOBAOURL = settingDao.querySetting("TAOBAOURL").getConfigValue();
        String APPKEY = settingDao.querySetting("TAOBAOAPPKEY").getConfigValue();
        String SECRET = settingDao.querySetting("TAOBAOSECRET").getConfigValue();
        Long TaoBaoAdzoneId = Long.valueOf(settingDao.querySetting("TAOBAOAdzoneId").getConfigValue());
        Integer SleepCollect = Integer.valueOf(settingDao.querySetting("SleepCollect").getConfigValue());
        Long TaoBaoForSum = Long.valueOf(settingDao.querySetting("TaoBaoForSum").getConfigValue());
        Integer couponAmout=0;
        Integer commissionAmout=0;
        Integer sVolume=0;
        String amount = collectBean.getAmount();
        String commission = collectBean.getCommission();
        String coupon = collectBean.getCoupon();
        String salesVolume = collectBean.getSalesVolume();
        String tianMou = collectBean.getTianMou();
        String price = collectBean.getPrice();
        String price_max = collectBean.getPrice_max();
        TaobaoClient client = new DefaultTaobaoClient(TAOBAOURL, APPKEY, SECRET);
        TbkDgMaterialOptionalRequest request = new TbkDgMaterialOptionalRequest();
        request.setPageSize(100l);
        request.setPageNo(1l);
        if (price!=null&&price_max!=null){
            request.setStartPrice(Long.valueOf(price));
            request.setEndPrice(Long.valueOf(price_max));
        }
        if (tianMou!=null){
            request.setIsTmall(Integer.valueOf(tianMou)==1?false:true);
        }
        if (coupon!=null){
            request.setHasCoupon(Integer.valueOf(coupon)==1?false:true);
        }
        if (amount!=null){
            couponAmout= Integer.valueOf(amount);
        }
        if (commission!=null){
            commissionAmout= Integer.valueOf(commission);
        }
        if (salesVolume!=null){
            sVolume= Integer.valueOf(salesVolume);
        }

        request.setAdzoneId(TaoBaoAdzoneId);
        request.setHasCoupon(true);
        request.setIsTmall(true);
        request.setCat("16,15,14,13,12,11,10,9,8,7");
//            request.setCat("8,20,21,30,14,50012164,29,5,16,50002766");
        TbkDgMaterialOptionalResponse rsp = null;
        rsp = client.execute(request);
        Long count=rsp.getTotalResults()/100;
        Long start=0l;
        if (count<TaoBaoForSum){
            start=count+1;
        }
        else {
            start=TaoBaoForSum;
        }
        rsp=null;
        for (long i = 1; i < start; i++) {
            try {
                Thread.sleep(SleepCollect);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            request.setPageNo(i);
            try {

                rsp = client.execute(request);
                List<TbkDgMaterialOptionalResponse.MapData> resultList = rsp.getResultList();
                Integer finalCouponAmout = couponAmout;
                Integer finalCommissionAmout = commissionAmout;
                Integer finalSVolume = sVolume;
                resultList.forEach(mapData -> {
                    String couponInfo = mapData.getCouponInfo();
                    int star = mapData.getCouponInfo().indexOf(20943);//参数为字符的ascii码
                    couponInfo = mapData.getCouponInfo().substring(star + 1, couponInfo.length() - 1);
                    Integer couple = Integer.parseInt(couponInfo);
                    Double commiss = commissonAritTaobao(mapData.getZkFinalPrice(), mapData.getCommissionRate(), couple).doubleValue() / 10;
                    if (mapData.getVolume() > finalSVolume && commiss > finalCommissionAmout && couple > finalCouponAmout) {
                        Map<String, Object> h = new HashMap<>();
                        h.put("pictUrl", mapData.getPictUrl());
                        h.put("shopTitle", mapData.getShopTitle());
                        h.put("title", mapData.getTitle());
                        h.put("commissionRate", commiss);
                        long comssion = new BigDecimal(mapData.getCommissionRate()).longValue();
                        h.put("comssion", comssion);
                        h.put("coupon", couple);
                        h.put("zkFinalPrice", new BigDecimal(mapData.getZkFinalPrice()).doubleValue());
                        h.put("volume", mapData.getVolume().intValue());
                        h.put("numIid", mapData.getNumIid());
                        h.put("istamll", mapData.getUserType());
//                        sysJhTaobaoHotDao.save(h);

                    }
                });
            } catch (Exception e) {

            }
        }
    }

    public static BigDecimal commissonAritTaobao(String zk, String rate, Integer copuon) {
        BigDecimal var0 = new BigDecimal(zk);
        BigDecimal var1 = new BigDecimal(copuon);
        BigDecimal divide = var0.subtract(var1);
        long rate1 = new BigDecimal(rate).longValue();
        Double var4 = rate1 / 1000d;
        Double var5 = divide.doubleValue() * var4;
        return new BigDecimal(var5).setScale(2, BigDecimal.ROUND_DOWN);
    }

}
