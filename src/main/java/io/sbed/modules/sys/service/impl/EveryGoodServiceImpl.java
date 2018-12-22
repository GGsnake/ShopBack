package io.sbed.modules.sys.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zyqhw.springboot.util.PageParam;
import io.sbed.modules.api.utils.PddSignUtil;
import io.sbed.modules.sys.entity.Goods_list;
import io.sbed.modules.sys.entity.PddGood;
import io.sbed.modules.sys.service.EveryGoodService;
import io.sbed.modules.sys.util.HttpRequest;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by liujupeng on 2018/11/2.
 */
@Service("everyGoodService")
public class EveryGoodServiceImpl  implements EveryGoodService {
    static  final  String REFRESH_TOKEN="75412af6-b87e-4279-81fd-0507c52dfb26";
    static  final  String TIME="1541039628602";
    static  final  String ACCESS_TOKEN="ed69acd6-dbc7-4fc5-a830-135e63d19692";
    static  final  String MyappKey="D4236C4D973B80F70F8B8929E2C226CB";
    static  final  String MyappSecret="2d0d4a0563e543dab280774a8b946db3";
    static  final  String URL="https://api.jd.com/routerjson";

    static  final  String CLIENTID="bbc1737d63e44e278dbffa9e96a7eca3";
    static  final  String SECRET="5e1a03eb561bac0c63c5efc8c1472119fc3ad405";
    /**
     *
     * @param pageParam
     */
    @Override
    public List<PddGood> queryPddGoods(PageParam pageParam, Integer sort_type, String keyword) {
        String type="pdd.ddk.goods.search";

        String timestamp = String.valueOf(System.currentTimeMillis()/1000);
        //生成sign
        String sign=SECRET+"client_id"+CLIENTID+"data_typeJSONpage"+pageParam.getPageNo()+"page_size"+pageParam.getPageSize()+"sort_type"+sort_type+"timestamp"
                +timestamp+"type"+type+"with_coupontrue"+SECRET;
        String  s= PddSignUtil.pddSign(sign);
        SortedMap<String,String> mapsign=new TreeMap<>();
        mapsign.put("client_id",CLIENTID);
        mapsign.put("type",type);
        mapsign.put("timestamp",timestamp);
        mapsign.put("data_type","JSON");
        mapsign.put("sign",s.toUpperCase());
        mapsign.put("sort_type", String.valueOf(sort_type));
        mapsign.put("page", String.valueOf(pageParam.getPageNo()));
        mapsign.put("page_size", String.valueOf(pageParam.getPageSize()));
        mapsign.put("with_coupon","true");
        String res = null;
        try {
            res = HttpRequest.sendPost("https://gw-api.pinduoduo.com/api/router", mapsign);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONArray goods_list = JSON.parseObject(res).getJSONObject("goods_search_response").getJSONArray("goods_list");
        List<Goods_list> goodsize = JSONObject.parseArray(goods_list.toJSONString(), Goods_list.class);
        List<PddGood> pddsize=new ArrayList<>();
        for (Goods_list goodsList:goodsize)
        {
            PddGood pd=new PddGood();
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
