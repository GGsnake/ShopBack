package io.sbed.modules.sys.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jd.open.api.sdk.DefaultJdClient;
import com.jd.open.api.sdk.JdClient;
import com.jd.open.api.sdk.JdException;
import com.pdd.pop.sdk.common.util.JsonUtil;
import com.pdd.pop.sdk.http.PopClient;
import com.pdd.pop.sdk.http.PopHttpClient;
import com.pdd.pop.sdk.http.api.request.PddDdkGoodsPidGenerateRequest;
import com.pdd.pop.sdk.http.api.response.PddDdkGoodsPidGenerateResponse;
import com.zyqhw.springboot.util.GetDayUtils;
import com.zyqhw.springboot.util.PageParam;
import io.sbed.common.utils.RandomUtils;
import io.sbed.modules.api.utils.PddSignUtil;
import io.sbed.modules.sys.dao.SysPidjdDao;
import io.sbed.modules.sys.entity.Goods_list;
import io.sbed.modules.sys.entity.PddGood;
import io.sbed.modules.sys.service.EveryGoodService;
import io.sbed.modules.sys.util.HttpRequest;
import io.sbed.modules.sys.util.NetUtils;
import jd.union.open.position.create.request.PositionReq;
import jd.union.open.position.create.request.UnionOpenPositionCreateRequest;
import jd.union.open.position.create.response.UnionOpenPositionCreateResponse;
import jd.union.open.user.pid.get.request.PidReq;
import jd.union.open.user.pid.get.request.UnionOpenUserPidGetRequest;
import jd.union.open.user.pid.get.response.UnionOpenUserPidGetResponse;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * Created by liujupeng on 2018/11/2.
 */
@Log
@Service("everyGoodService")
public class EveryGoodServiceImpl implements EveryGoodService {
    static final String REFRESH_TOKEN = "75412af6-b87e-4279-81fd-0507c52dfb26";
    static final String TIME = "1541039628602";
    static final String ACCESS_TOKEN = "ed69acd6-dbc7-4fc5-a830-135e63d19692";
    static final String MyappKey = "D4236C4D973B80F70F8B8929E2C226CB";
    static final String MyappSecret = "2d0d4a0563e543dab280774a8b946db3";
    static final String URL = "https://api.jd.com/routerjson";

    static final String CLIENTID = "bbc1737d63e44e278dbffa9e96a7eca3";
    static final String SECRET = "5e1a03eb561bac0c63c5efc8c1472119fc3ad405";

    @Value("${pdd_pro.pdd-key}")
    private String PDD_KEY;
    @Value("${pdd_pro.pdd-secret}")
    private String PDD_SECRET;
    @Value("${pdd_pro.pdd-access_token}")
    private String PDD_ACCESS_TOKEN;
    @Value("${pdd_pro.pdd-router-url}")
    private String PDD_URL;
    @Autowired
    RestTemplate restTemplate;

    /**
     * @param pageParam
     */
    @Override
    public List<PddGood> queryPddGoods(PageParam pageParam, Integer sort_type, String keyword) {
        String type = "pdd.ddk.goods.search";

        String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
        //生成sign
        String sign = SECRET + "client_id" + CLIENTID + "data_typeJSONpage" + pageParam.getPageNo() + "page_size" + pageParam.getPageSize() + "sort_type" + sort_type + "timestamp"
                + timestamp + "type" + type + "with_coupontrue" + SECRET;
        String s = PddSignUtil.pddSign(sign);
        SortedMap<String, String> mapsign = new TreeMap<>();
        mapsign.put("client_id", CLIENTID);
        mapsign.put("type", type);
        mapsign.put("timestamp", timestamp);
        mapsign.put("data_type", "JSON");
        mapsign.put("sign", s.toUpperCase());
        mapsign.put("sort_type", String.valueOf(sort_type));
        mapsign.put("page", String.valueOf(pageParam.getPageNo()));
        mapsign.put("page_size", String.valueOf(pageParam.getPageSize()));
        mapsign.put("with_coupon", "true");
        String res = null;
        try {
            res = HttpRequest.sendPost("https://gw-api.pinduoduo.com/api/router", mapsign);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONArray goods_list = JSON.parseObject(res).getJSONObject("goods_search_response").getJSONArray("goods_list");
        List<Goods_list> goodsize = JSONObject.parseArray(goods_list.toJSONString(), Goods_list.class);
        List<PddGood> pddsize = new ArrayList<>();
        for (Goods_list goodsList : goodsize) {
            PddGood pd = new PddGood();
            pd.setGoods_id(goodsList.getGoods_id());
            pd.setCoupon_discount(goodsList.getCoupon_discount());
            pd.setMall_name(goodsList.getMall_name());
            pd.setCreate_at(goodsList.getCreate_at());
            pd.setGoods_name(goodsList.getGoods_name());
            pd.setGoods_thumbnail_url(goodsList.getGoods_thumbnail_url());
            pd.setPromotion_rate(goodsList.getPromotion_rate());
            pd.setSold_quantity(goodsList.getSold_quantity());
            pddsize.add(pd);
        }
        return pddsize;
    }

    @Override
    public void queryJdGoods(PageParam pageParam, Integer sort_type, String keyword) {

    }

    @Autowired
    private SysPidjdDao sysPidjdDao;

    @Override
    public JSONObject createJdPid(Integer count) {
        final String URL = "http://jdapi.apptimes.cn/";

//        String SERVER_URL = "https://router.jd.com/api";
//        String appKey = "1b2eadd4ad604021a9e48aa5726c503b";
//        String appSecret = "909a02d9f2e845578f6333a3a13ea5cd";
//        String accessToken = "";
//        JdClient client = new DefaultJdClient(SERVER_URL, accessToken, appKey, appSecret);
        String jdurl = URL + "addpid?";
        JSONObject temp = new JSONObject();
        Map<String, String> urlSign = new HashMap<>();
        JSONObject da = new JSONObject();
        List<Long> pidList = new ArrayList();
        StringBuilder pid = new StringBuilder();

        for (int i = 1; i < 50; i++) {
            pid.append(RandomUtils.randomSixNum() + ",");
        }
        urlSign.put("pidname", pid.substring(0, pid.length() - 1));
        urlSign.put("unionid", "1001347399");
        urlSign.put("siteid", "1695433914");
        urlSign.put("type", "2");
        urlSign.put("authkey", "ece3b6ab1c8b87a7234801d44a165894785e41d9bc5500e23b2d8e614afb4a03c89bc245270b7245");
        String linkStringByGet = null;
        try {
            linkStringByGet = NetUtils.createLinkStringByGet(urlSign);
            JSONObject data;
            String res = restTemplate.getForObject(jdurl + linkStringByGet, String.class);
            data = JSON.parseObject(res);
            Map data1 = data.getJSONObject("data").getObject("resultList", JSONObject.class);
            data1.forEach((k, v) -> {
                String s = v.toString();
                pidList.add(Long.valueOf(s));
            });
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        pidList.forEach(item->{
            Integer var =  sysPidjdDao.addPidJd(item);
            if (var == 0) {
                log.warning("pid插入到数据库失败 PID===" + item);
            }
        });
//            UnionOpenUserPidGetRequest unionOpenUserPidGetRequest = new UnionOpenUserPidGetRequest();
//            PidReq pidReq = new PidReq();
//            pidReq.setUnionId();
//            pidReq.setChildUnionId(1615700699l);
//            pidReq.setPromotionType(1);
//            unionOpenUserPidGetRequest.setPidReq(pidReq);
//            try {
//                UnionOpenUserPidGetResponse response = client.execute(unionOpenUserPidGetRequest);
//
//            } catch (JdException e) {
//                e.printStackTrace();
//            }


//            UnionOpenPositionCreateRequest request = new UnionOpenPositionCreateRequest();
//            PositionReq positionReq = new PositionReq();
//            positionReq.setSpaceNameList(new String[]{"lxtest7a", "lxtest8a", "lxtest9a"});
//            positionReq.setUnionId(1001142862l);
//            positionReq.setType(4);
//            positionReq.setUnionType(1);
//            positionReq.setSiteId(1615700699l);
//            positionReq.setKey("ece3b6ab1c8b87a7c8865dfe7ac1999750ff2bd682777ce215713a3922b0e6a3d6c05372abf1a06c");
//
//            request.setPositionReq(positionReq);
//            try {
//                UnionOpenPositionCreateResponse response = client.execute(request);
//                pidList.add(response.getData().getResultList());
//            } catch (JdException e) {
//                e.printStackTrace();
//            }
//        }
//
//        for (int i = 0; i < pidList.size(); i++) {
//            sysPidjdDao.addPidJd(1l);
//        }

//        da.put("data", response.getData());
//        return da;

        return null;
    }

    @Override
    public JSONObject createTbPid(Integer count) {
        return null;
    }


    @Override
    public JSONObject createPddPid(Integer count) {
        List<String> pid = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            pid.add(""+RandomUtils.randomSixNum());
        }
        PopClient client = new PopHttpClient(PDD_KEY, PDD_SECRET);

        PddDdkGoodsPidGenerateRequest request = new PddDdkGoodsPidGenerateRequest();
        request.setNumber(Long.valueOf(pid.size()));
        request.setPIdNameList(pid);

        PddDdkGoodsPidGenerateResponse response = null;
        try {
            response = client.syncInvoke(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<PddDdkGoodsPidGenerateResponse.PIdListItem> pIdList = response.getPIdGenerateResponse().getPIdList();
        if (pIdList == null || pIdList.size() == 0) {
            return null;
        }

        pIdList.forEach(item->{
            Integer var =  sysPidjdDao.addPidPdd(item.getPId());
            if (var == 0) {
                log.warning("pid插入到数据库失败 PID===" +item.getPId());
            }
        });
        return null;
    }

//    @Override
//    public void queryJdGoods(PageParam pageParam, Integer sort_type, String keyword) {
//        //创建请求
//        JdClient client=new DefaultJdClient(URL,ACCESS_TOKEN,MyappKey,MyappSecret);
//        UnionSearchGoodsParamQueryRequest request=new UnionSearchGoodsParamQueryRequest();
//        request.setPageIndex(1);
//        request.setPageSize(5);
//        try {
//            UnionSearchGoodsParamQueryResponse response=client.execute(request);
//        } catch (JdException e) {
//            e.printStackTrace();
//        }
//    }


}
