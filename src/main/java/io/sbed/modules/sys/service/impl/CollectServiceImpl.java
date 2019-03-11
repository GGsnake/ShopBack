package io.sbed.modules.sys.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkDgMaterialOptionalRequest;
import com.taobao.api.response.TbkDgMaterialOptionalResponse;
import io.sbed.modules.sys.model.CollectBean;
import io.sbed.modules.sys.service.CollectService;
import io.sbed.modules.sys.dao.SettingDao;
import io.sbed.modules.sys.dao.SysJhTaobaoAllDao;
import io.sbed.modules.sys.util.net.NetUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("collectService")
public class CollectServiceImpl implements CollectService {
    @Autowired
    private SettingDao settingDao;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private SysJhTaobaoAllDao sysJhTaobaoAllDao;

    @Async
    public void collectTaobao(CollectBean collectBean) throws ApiException {
        String TAOBAOURL = settingDao.querySetting("TAOBAOURL").getConfigValue();
        String APPKEY = settingDao.querySetting("TAOBAOAPPKEY").getConfigValue();
        String SECRET = settingDao.querySetting("TAOBAOSECRET").getConfigValue();
        Long TaoBaoAdzoneId = Long.valueOf(settingDao.querySetting("TAOBAOAdzoneId").getConfigValue());
        Integer SleepCollect = Integer.valueOf(settingDao.querySetting("SleepCollect").getConfigValue());
        Long TaoBaoForSum = Long.valueOf(settingDao.querySetting("TaoBaoForSum").getConfigValue());
        Integer couponAmout = 0;
        Double commissionAmout = 0d;
        Integer sVolume = 0;
        //券额
        Integer amount = collectBean.getAmount();
        //佣金
        Double commission = collectBean.getCommission();
//        String coupon = collectBean.getCoupon();
        Integer salesVolume = collectBean.getSalesVolume();
//        Integer tianMou = collectBean.getTianMou();
        Integer opts = 0;

        Double price = collectBean.getPrice();
        Double price_max = collectBean.getPrice_max();
        TaobaoClient client = new DefaultTaobaoClient(TAOBAOURL, APPKEY, SECRET);
        TbkDgMaterialOptionalRequest request = new TbkDgMaterialOptionalRequest();
        request.setPageSize(100l);
        request.setHasCoupon(true);
        request.setPageNo(1l);
        if (collectBean.getOpt() != null) {
            opts = collectBean.getOpt();
        }
        if (price != null && price_max != null) {
            request.setStartPrice(price.longValue());
            request.setEndPrice(price_max.longValue());
        }
//        i f (tianMou!=null){
//            request.setIsTmall(Integer.valueOf(tianMou)==1?false:true);
//        }
//        if (coupon!=null){
//            request.setHasCoupon(Integer.valueOf(coupon)==1?false:true);
//        }
        if (amount != null) {
            couponAmout = amount;
        }
        if (commission != null) {
            commissionAmout = commission;
        }
        if (salesVolume != null) {
            sVolume = salesVolume;
        }
        request.setAdzoneId(TaoBaoAdzoneId);
        request.setHasCoupon(true);
//        request.setIsTmall(false);
        request.setCat("8,7,5,16,15,14,13,12,11,10");
        TbkDgMaterialOptionalResponse rsp = null;
        rsp = client.execute(request);
        Long count = rsp.getTotalResults() / 100;
        Long start = 1020l;
        start = TaoBaoForSum;
        rsp = null;
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
                Double finalCommissionAmout = commissionAmout;
                Integer finalSVolume = sVolume;
                Integer finalOpts = opts;
                resultList.forEach(mapData -> {
                    String couponInfo = mapData.getCouponInfo();
                    int star = mapData.getCouponInfo().indexOf(20943);//参数为字符的ascii码
                    couponInfo = mapData.getCouponInfo().substring(star + 1, couponInfo.length() - 1);
                    Integer couple = Integer.parseInt(couponInfo);
                    Double commiss = commissonAritTaobao(mapData.getZkFinalPrice(), mapData.getCommissionRate(), couple).doubleValue() / 10;
                    double zkfinal = new BigDecimal(mapData.getZkFinalPrice()).doubleValue();
                    if (mapData.getVolume() > finalSVolume && commiss > finalCommissionAmout && couple > finalCouponAmout) {
                        Map<String, Object> stringObjectMap = savaTaoBaoBean(mapData);
                        stringObjectMap.put("couponprice", zkfinal - couple);
                        stringObjectMap.put("coupon", couple);
                        stringObjectMap.put("zkfinalprice", zkfinal);
                        stringObjectMap.put("opt", finalOpts);
                        stringObjectMap.put("commission", commiss);
                        sysJhTaobaoAllDao.save(stringObjectMap);
                    }
                });
                request.setCat("8,20,21,30,14,50012164,29,5,16,50002766");
                rsp = client.execute(request);
                List<TbkDgMaterialOptionalResponse.MapData> resultList1 = rsp.getResultList();
                resultList1.forEach(mapData -> {
                    String couponInfo = mapData.getCouponInfo();
                    int star = mapData.getCouponInfo().indexOf(20943);//参数为字符的ascii码
                    couponInfo = mapData.getCouponInfo().substring(star + 1, couponInfo.length() - 1);
                    Integer couple = Integer.parseInt(couponInfo);
                    Double commiss = commissonAritTaobao(mapData.getZkFinalPrice(), mapData.getCommissionRate(), couple).doubleValue() / 10;
                    double zkfinal = new BigDecimal(mapData.getZkFinalPrice()).doubleValue();
                    if (mapData.getVolume() > finalSVolume && commiss > finalCommissionAmout && couple > finalCouponAmout) {
                        Map<String, Object> stringObjectMap = savaTaoBaoBean(mapData);
                        stringObjectMap.put("couponprice", zkfinal - couple);
                        stringObjectMap.put("coupon", couple);
                        stringObjectMap.put("zkfinalprice", zkfinal);
                        stringObjectMap.put("opt", finalOpts);
                        stringObjectMap.put("commission", commiss);
                        sysJhTaobaoAllDao.save(stringObjectMap);
                    }
                });
            } catch (Exception e) {

            }
        }
    }

    @Override
    public void collectTaobaoHome(CollectBean collectBean) throws ApiException {

    }

    @Override
    public void collectTaobaoHot(CollectBean collectBean) throws ApiException {

    }

    @Override
    public void collectTaobaoNine(CollectBean collectBean) throws ApiException {

    }
    @Async
    @Override
    public void collectJD(CollectBean collectBean)  {
        String jdUrl = settingDao.querySetting("MiaoJdUrl").getConfigValue();
        String appkey = settingDao.querySetting("MiaoAppKey").getConfigValue();
        Long TaoBaoForSum = Long.valueOf(settingDao.querySetting("TaoBaoForSum").getConfigValue());
        Integer cid = collectBean.getOpt();
        Double commissionSelet = collectBean.getCommission();
        Integer salesVolume = collectBean.getSalesVolume();
        Double price1 = collectBean.getPrice();
        Integer amount = collectBean.getAmount();
        Double price_max = collectBean.getPrice_max();
        for (long j = 1; j < TaoBaoForSum; j++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            JSONArray dataArray;
            String jdurl = jdUrl+"/getjdunionitems?";
            Map<String, String> urlSign = new HashMap<>();
            urlSign.put("apkey", appkey);
            urlSign.put("cid1", cid.toString());
            urlSign.put("pageSize", String.valueOf(30));
            urlSign.put("pageIndex", String.valueOf(j));
            if (price1!= null &&price_max!= null) {
                urlSign.put("pricefrom", price1.toString());
                urlSign.put("priceto", price_max.toString());
            }
            urlSign.put("isCoupon", "1");
            String linkStringByGet = null;
            try {
                linkStringByGet = NetUtils.createLinkStringByGet(urlSign);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            String res = restTemplate.getForObject(jdurl + linkStringByGet, String.class);
            JSONObject allData = JSON.parseObject(res).getJSONObject("data");
            dataArray = allData.getJSONArray("lists");
            for (int i = 0; i < dataArray.size(); i++) {
                JSONObject jdJson = (JSONObject) dataArray.get(i);
                Integer saleCount = jdJson.getInteger("inOrderCount30Days");
                if (salesVolume!=null&&salesVolume>saleCount){
                    continue;
                }

                //单价2*
                Double price = jdJson.getJSONObject("priceInfo").getDouble("price");
                JSONArray coupon = jdJson.getJSONObject("couponInfo").getJSONArray("couponList");
                JSONObject img = (JSONObject) jdJson.getJSONObject("imageInfo").getJSONArray("imageList").get(0);
                //佣金金额
                Double commissionA = jdJson.getJSONObject("commissionInfo").getDouble("commission");
                //佣金比例
                Double comsA = jdJson.getJSONObject("commissionInfo").getDouble("commissionShare");
                //佣金比例
                BigDecimal coms = new BigDecimal(comsA);

                //佣金金额
                BigDecimal commission = new BigDecimal(commissionA);
                if (commissionSelet!=null&&commissionSelet>commission.doubleValue()){
                    continue;
                }

                BigDecimal priceall = new BigDecimal(price);
                JSONObject couponList = (JSONObject) coupon.get(0);
                BigDecimal discount = new BigDecimal(couponList.getInteger("discount"));
                if (amount!=null&&amount>discount.intValue()){
                    continue;
                }

                BigDecimal subtract = priceall.subtract(discount);

                Map<String, Object> h = new HashMap<>();
                h.put("zkFinalPrice", subtract.doubleValue());
                h.put("coupon", discount.doubleValue());
//                if (coupon != null && coupon.size() != 0) {
//                    JSONObject couponList = (JSONObject) coupon.get(0);
//                    BigDecimal discount = new BigDecimal(couponList.getInteger("discount"));
//                    BigDecimal subtract = priceall.subtract(discount);
//                    h.put("zkFinalPrice", subtract.doubleValue());
//                    h.put("coupon", discount.doubleValue());
//                } else {
//                    h.put("zkFinalPrice", price);
//                    h.put("coupon", 0);
//                }
                h.put("jdurl", "http://" + jdJson.getString("materialUrl"));
                h.put("pictUrl", img.getString("url"));
                h.put("shopTitle", jdJson.getJSONObject("shopInfo").getString("shopName"));
                h.put("title", jdJson.getString("skuName"));
                h.put("commissionRate", coms.doubleValue());
                h.put("comssion", commission.doubleValue());
                h.put("cid", cid);
                h.put("volume", saleCount);
                h.put("numIid", jdJson.getLong("skuId"));
                sysJhTaobaoAllDao.saveJd(h);
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

    public static Map<String, Object> savaTaoBaoBean(TbkDgMaterialOptionalResponse.MapData mapData) {
        Map<String, Object> h = new HashMap<>();
        h.put("picturl", mapData.getPictUrl());
        h.put("shoptitle", mapData.getShopTitle());
        h.put("title", mapData.getTitle());
        h.put("volume", mapData.getVolume().intValue());
        h.put("numiid", mapData.getNumIid());
        h.put("istamll", mapData.getUserType());
        long comssion = new BigDecimal(mapData.getCommissionRate()).longValue();
        h.put("cat", mapData.getLevelOneCategoryId());
        h.put("commissionrate", comssion);
        return h;
    }

}
