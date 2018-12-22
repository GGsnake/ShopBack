package com;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.sbed.modules.api.utils.PddSignUtil;
import io.sbed.modules.sys.util.HttpRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.util.DigestUtils;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by liujupeng on 2018/11/1.
 */
//@SpringBootApplication
public class StartApplication extends SpringBootServletInitializer{
    static  final  String CLIENTID="bbc1737d63e44e278dbffa9e96a7eca3";

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        String type="pdd.ddk.goods.search";
        String algo=null;
        String timestamp = String.valueOf(System.currentTimeMillis()/1000);
        //生成sign
        String sign="5e1a03eb561bac0c63c5efc8c1472119fc3ad405client_idbbc1737d63e44e278dbffa9e96a7eca3data_typeJSONsort_type0timestamp"
                +timestamp+"typepdd.ddk.goods.searchwith_coupontrue5e1a03eb561bac0c63c5efc8c1472119fc3ad405";
        String  s= PddSignUtil.pddSign(sign);
        SortedMap<String,String> mapsign=new TreeMap<>();
        mapsign.put("client_id",CLIENTID);
        mapsign.put("type",type);
        mapsign.put("timestamp",timestamp);
        mapsign.put("data_type","JSON");
        mapsign.put("sign",s.toUpperCase());
        mapsign.put("sort_type","0");
        mapsign.put("with_coupon","true");
        String res = HttpRequest.sendPost("https://gw-api.pinduoduo.com/api/router", mapsign);
        JSONObject jsonObject = JSON.parseObject(res);

        JSONArray goods_search_response = jsonObject.getJSONArray("goods_search_response");
        System.out.println(goods_search_response);

//        SpringApplication.run(StartApplication.class, args);
    }


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(StartApplication.class);
    }
}
