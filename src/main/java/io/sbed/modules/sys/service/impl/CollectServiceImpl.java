package io.sbed.modules.sys.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkDgMaterialOptionalRequest;
import com.taobao.api.response.TbkDgMaterialOptionalResponse;
import io.sbed.common.utils.RedisUtils;
import io.sbed.modules.sys.entity.SysCollectlog;
import io.sbed.modules.sys.model.CollectBean;
import io.sbed.modules.sys.model.Config;
import io.sbed.modules.sys.service.CollectService;
import io.sbed.modules.sys.dao.SettingDao;
import io.sbed.modules.sys.dao.SysJhTaobaoAllDao;
import io.sbed.modules.sys.util.net.NetUtils;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.*;

@Log
@Service("collectService")
public class CollectServiceImpl implements CollectService {
    @Autowired
    private SettingDao settingDao;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private SysJhTaobaoAllDao sysJhTaobaoAllDao;
    @Autowired
    private SysCollectlogServiceImpl sysCollectlogService;


    @Async
    public Boolean collectTaobao(CollectBean collectBean) {
        String TAOBAOURL = settingDao.querySetting("TAOBAOURL").getConfigValue();
        String APPKEY = settingDao.querySetting("TAOBAOAPPKEY").getConfigValue();
        String SECRET = settingDao.querySetting("TAOBAOSECRET").getConfigValue();
        //淘宝推广位ID 必填
        Long TaoBaoAdzoneId = Long.valueOf(settingDao.querySetting("TAOBAOAdzoneId").getConfigValue());
        //单次请求休息时间
        Integer SleepCollect = Integer.valueOf(settingDao.querySetting("SleepCollect").getConfigValue());

        //优惠卷金额
        Integer couponAmout = 0;
        //优惠卷金额
        Integer amount = collectBean.getAmount();
        //佣金金额
        Double commissionAmout = 0d;
        //佣金金额
        Double commission = collectBean.getCommission();
        //销量
        Integer sVolume = 0;
        Integer salesVolume = collectBean.getSalesVolume();
        //采集入哪个模块 null为0
        Integer opts = 0;
        //采集计数器
        Integer collectCountMax = collectBean.getCollectCount();
        //价格下限
        Double price = collectBean.getPrice();
        //价格上限
        Double price_max = collectBean.getPrice_max();
        Config config1 = settingDao.querySetting("now");
        TaobaoClient client = new DefaultTaobaoClient(TAOBAOURL, APPKEY, SECRET);
        TbkDgMaterialOptionalRequest request = new TbkDgMaterialOptionalRequest();
        TbkDgMaterialOptionalResponse rsp = null;
        request.setPageSize(100l);
        request.setCat("8,7,5,16,15,14,13,12,11,10");
        request.setCat("8,20,21,30,14,50012164,29,5,16,50002766");

        request.setHasCoupon(true);
        request.setAdzoneId(TaoBaoAdzoneId);
        request.setPageNo(1l);

        if (collectBean.getOpt() != null) {
            opts = collectBean.getOpt();
        }
        if (price != null && price_max != null) {
            request.setStartPrice(price.longValue());
            request.setEndPrice(price_max.longValue());
        }
        if (amount != null) {
            couponAmout = amount;
        }
        if (commission != null) {
            commissionAmout = commission;
        }
        if (salesVolume != null) {
            sVolume = salesVolume;
        }
        SysCollectlog sysCollectlog = new SysCollectlog();
        List<Long> collectCount = new ArrayList<>();


        for (long i = 1; i < collectBean.getTimeout() * 2; i++) {
            if (collectCountMax <= collectCount.size() + 1) {
                config1.setConfigValue("0");
                settingDao.update(config1);
                sysCollectlog.setSum(collectCount.size());
                sysCollectlogService.save(sysCollectlog);
                break;
            }
            try {
                Thread.sleep(SleepCollect);
            } catch (InterruptedException e) {
                config1.setConfigValue("0");
                settingDao.update(config1);
                sysCollectlog.setSum(collectCount.size());
                sysCollectlogService.save(sysCollectlog);
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
                long finalI = i;
                resultList.forEach(mapData -> {
                    String couponInfo = mapData.getCouponInfo();
                    int star = mapData.getCouponInfo().indexOf(20943);//参数为字符的ascii码
                    //切割获得优惠卷价格
                    couponInfo = mapData.getCouponInfo().substring(star + 1, couponInfo.length() - 1);
                    Integer couple = Integer.parseInt(couponInfo);
                    //计算佣金
                    Double commiss = commissonAritTaobao(mapData.getZkFinalPrice(), mapData.getCommissionRate(), couple).doubleValue() / 10;
                    //计算折后价
                    double zkfinal = new BigDecimal(mapData.getZkFinalPrice()).doubleValue();
                    if (mapData.getVolume() > finalSVolume && commiss > finalCommissionAmout && couple > finalCouponAmout) {
                        Map<String, Object> stringObjectMap = savaTaoBaoBean(mapData);
                        stringObjectMap.put("couponprice", zkfinal - couple);
                        stringObjectMap.put("coupon", couple);
                        stringObjectMap.put("zkfinalprice", zkfinal);
                        stringObjectMap.put("opt", finalOpts);
                        stringObjectMap.put("commission", commiss);
                        Integer save = sysJhTaobaoAllDao.save(stringObjectMap);
                        if (save == 1) {
                            collectCount.add(finalI);

                        }
                    }
                });
//                request.setCat("8,20,21,30,14,50012164,29,5,16,50002766");
//                rsp = client.execute(request);
//                List<TbkDgMaterialOptionalResponse.MapData> resultList1 = rsp.getResultList();
//                resultList1.forEach(mapData -> {
//                    collectCount.add(20000l + finalI);
//                    String couponInfo = mapData.getCouponInfo();
//                    int star = mapData.getCouponInfo().indexOf(20943);//参数为字符的ascii码
//                    couponInfo = mapData.getCouponInfo().substring(star + 1, couponInfo.length() - 1);
//                    Integer couple = Integer.parseInt(couponInfo);
//                    Double commiss = commissonAritTaobao(mapData.getZkFinalPrice(), mapData.getCommissionRate(), couple).doubleValue() / 10;
//                    double zkfinal = new BigDecimal(mapData.getZkFinalPrice()).doubleValue();
//                    if (mapData.getVolume() > finalSVolume && commiss > finalCommissionAmout && couple > finalCouponAmout) {
//                        Map<String, Object> stringObjectMap = savaTaoBaoBean(mapData);
//                        stringObjectMap.put("couponprice", zkfinal - couple);
//                        stringObjectMap.put("coupon", couple);
//                        stringObjectMap.put("zkfinalprice", zkfinal);
//                        stringObjectMap.put("opt", finalOpts);
//                        stringObjectMap.put("commission", commiss);
//                        sysJhTaobaoAllDao.save(stringObjectMap);
//                    }
//                });
            } catch (Exception e) {

//                sysCollectlog.setSum(collectCount.size());
//                sysCollectlogService.save(sysCollectlog);
//                redisUtils.delete("tbcollect");

//                log.warning(e.getMessage());
            }
        }
        return null;
    }

    @Override
    public void collectTaobaoHome(CollectBean collectBean) throws ApiException {

    }

    @Async
    public void collectTaobaoHot(CollectBean collectBean) {
        String hdkAppKey = settingDao.querySetting("HDKAppKey").getConfigValue();
        String CollectPage = settingDao.querySetting("CollectPage").getConfigValue();
        JSONArray dataArray;
        Integer nav = 3;
        Integer back = Integer.valueOf(CollectPage);
//        Integer back = 1000;
        Integer min_id = null;
        Integer add = 0;
        //采集入哪个模块 null为0
        Integer opts = 0;
        if (collectBean.getOpt() != null) {
            opts = collectBean.getOpt();
        }
        while (true) {
            StringBuilder reqData = new StringBuilder();
            reqData.append("http://v2.api.haodanku.com/itemlist/");
            reqData.append("apikey/" + hdkAppKey + "/");
            reqData.append("nav/" + 5+ "/");
            reqData.append("price_min/" + collectBean.getPrice() + "/");
            reqData.append("price_max/" + collectBean.getPrice_max() + "/");
            reqData.append("sale_min/" + collectBean.getSalesVolume() + "/");
            reqData.append("coupon_min/" + collectBean.getAmount() + "/");
            reqData.append("tkmoney_min/" + collectBean.getCommission() + "/");
            reqData.append("back/" + back + "/");
//            reqData.append("activity_type/" + back + "/");
            reqData.append("sort/" + 0 + "/");
            reqData.append("item_type/" + 1 + "");
            if (min_id != null) {
                reqData.append("/min_id/" + min_id);
            }
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                redisUtils.delete("tbcollect");
                e.printStackTrace();
                log.warning("采集错误 线程休息异常----时间==" + new Date());
                break;
            }
            try {
                String res = restTemplate.getForObject(reqData.toString(), String.class);
                JSONObject allData = JSON.parseObject(res);
                if (!allData.getString("msg").equals("SUCCESS")) {
                    redisUtils.delete("tbcollect");
                    break;
                }
                dataArray = allData.getJSONArray("data");
                min_id = allData.getInteger("min_id");
                if (dataArray == null || dataArray.size() == 0) {
                    redisUtils.delete("tbcollect");
                    SysCollectlog sysCollectlog = new SysCollectlog();
                    sysCollectlog.setSum(add);
                    sysCollectlogService.save(sysCollectlog);
                    redisUtils.delete("tbcollect");
                    log.warning("采集完毕 本次采集" + add + "条数据-----时间==" + new Date());
                    break;
                }
                for (int i = 0; i < dataArray.size(); i++) {
                    JSONObject jdJson = (JSONObject) dataArray.get(i);
                    Integer saleCount = jdJson.getInteger("itemsale");
                    Integer cat = jdJson.getInteger("fqcat");
                    Double tkrates = jdJson.getDouble("tkrates");
                    Double itemendprice = jdJson.getDouble("itemendprice");
                    Double discount = jdJson.getDouble("couponmoney");
                    Double tkmoney = jdJson.getDouble("tkmoney");
                    Double itemprice = jdJson.getDouble("itemprice");

                    String itemshorttitle = jdJson.getString("itemshorttitle");
                    String itempic = jdJson.getString("itempic");
                    String isTamll = jdJson.getString("shoptype");
                    String shopname = jdJson.getString("shopname");
                    Integer istamll = isTamll.equals("B") ? 1 : 0;

                    Map<String, Object> h = new HashMap<>();
                    h.put("zkfinalprice", itemprice);
                    h.put("coupon", discount);
                    h.put("picturl", itempic);
                    h.put("shoptitle", shopname);
                    h.put("title", itemshorttitle);
                    h.put("commissionrate", tkrates);
                    h.put("opt", opts);
                    h.put("commission", tkmoney);
                    h.put("cat", cat);
                    h.put("istamll", istamll);
                    h.put("volume", saleCount);
                    h.put("numiid", jdJson.getLong("itemid"));
                    h.put("couponprice", itemendprice);
                    Integer save = sysJhTaobaoAllDao.save(h);
                    if (save == 1) {
                        add++;

                    }

                }
                if (dataArray.size() != back) {
                    SysCollectlog sysCollectlog = new SysCollectlog();
                    sysCollectlog.setSum(add);
                    sysCollectlogService.save(sysCollectlog);
                    redisUtils.delete("tbcollect");
                    log.warning("采集完毕 本次采集" + add + "条数据-----时间==" + new Date());
                    break;
                }
            } catch (Exception e) {
                SysCollectlog sysCollectlog = new SysCollectlog();
                sysCollectlog.setSum(add);
                sysCollectlogService.save(sysCollectlog);
                redisUtils.delete("tbcollect");
                log.warning("采集异常 本次采集" + add + "条数据-----时间==" + new Date());
                log.warning(e.getMessage());
                break;
            }


        }
//        SysCollectlog sysCollectlog = new SysCollectlog();
//        sysCollectlog.setSum(add);
//        sysCollectlogService.save(sysCollectlog);
//        redisUtils.delete("tbcollect");
//        log.warning("采集完毕 本次采集" + add + "条数据-----时间==" + new Date());

    }


    @Override
    public void collectTaobaoNine(CollectBean collectBean) throws ApiException {

    }

    @Async
    @Override
    public void collectJD(CollectBean collectBean) {
        String jdUrl = settingDao.querySetting("MiaoJdUrl").getConfigValue();
        String appkey = settingDao.querySetting("MiaoAppKey").getConfigValue();
        Long TaoBaoForSum = Long.valueOf(settingDao.querySetting("TaoBaoForSum").getConfigValue());
        Integer cid = collectBean.getOpt();
        Double commissionSelet = collectBean.getCommission();
        Integer salesVolume = collectBean.getSalesVolume();
        Integer collectCountMax = collectBean.getCollectCount();
        List<Long> collectCount = new ArrayList<>();
        SysCollectlog sysCollectlog = new SysCollectlog();
        Double price1 = collectBean.getPrice();
        Integer amount = collectBean.getAmount();
        Double price_max = collectBean.getPrice_max();
        for (long j = 1; j < TaoBaoForSum; j++) {
            if (collectCountMax <= collectCount.size()) {
                sysCollectlog.setSum(collectCount.size());
                sysCollectlogService.save(sysCollectlog);
                redisUtils.delete("jdcollect");
                break;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                redisUtils.delete("jdcollect");

                e.printStackTrace();

            }

            JSONArray dataArray;
            String jdurl = jdUrl + "/getjdunionitems?";
            Map<String, String> urlSign = new HashMap<>();
            urlSign.put("apkey", appkey);
            urlSign.put("cid1", cid.toString());
            urlSign.put("pageSize", String.valueOf(30));
            urlSign.put("pageIndex", String.valueOf(j));
            if (price1 != null && price_max != null) {
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
            try {

                String res = restTemplate.getForObject(jdurl + linkStringByGet, String.class);
                JSONObject allData = JSON.parseObject(res).getJSONObject("data");
                dataArray = allData.getJSONArray("lists");
                for (int i = 0; i < dataArray.size(); i++) {
                    JSONObject jdJson = (JSONObject) dataArray.get(i);
                    Integer saleCount = jdJson.getInteger("inOrderCount30Days");
                    if (salesVolume != null && salesVolume > saleCount) {
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
                    if (commissionSelet != null && commissionSelet > commission.doubleValue()) {
                        continue;
                    }

                    BigDecimal priceall = new BigDecimal(price);
                    JSONObject couponList = (JSONObject) coupon.get(0);
                    BigDecimal discount = new BigDecimal(couponList.getInteger("discount"));
                    if (amount != null && amount > discount.intValue()) {
                        continue;
                    }

                    BigDecimal subtract = priceall.subtract(discount);
                    collectCount.add(Long.valueOf(i));
                    Map<String, Object> h = new HashMap<>();
                    h.put("zkFinalPrice", subtract.doubleValue());
                    h.put("coupon", discount.doubleValue());
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
            } catch (Exception e) {
                sysCollectlog.setSum(collectCount.size());
                sysCollectlogService.save(sysCollectlog);
                redisUtils.delete("jdcollect");
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
