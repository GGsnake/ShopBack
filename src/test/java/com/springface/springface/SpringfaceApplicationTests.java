package com.springface.springface;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pdd.pop.sdk.common.util.JsonUtil;
import com.pdd.pop.sdk.http.PopClient;
import com.pdd.pop.sdk.http.PopHttpClient;
import com.pdd.pop.sdk.http.api.request.PddDdkGoodsPidQueryRequest;
import com.pdd.pop.sdk.http.api.response.PddDdkGoodsPidQueryResponse;
import io.sbed.SbedApplication;
import io.sbed.common.utils.RandomUtils;
import io.sbed.modules.sys.dao.SysPidjdDao;
import io.sbed.modules.sys.entity.User;
import io.sbed.modules.sys.service.UserService;
import io.sbed.modules.sys.util.NetUtils;
import org.apache.shiro.config.Ini;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SbedApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringfaceApplicationTests {
	@Autowired
	UserService userService;

    @Autowired
    RestTemplate restTemplate;
	@Autowired
    SysPidjdDao sysPidjdDao;
	@Test
	public void contextLoads() {
        PopClient client = new PopHttpClient("bbc1737d63e44e278dbffa9e96a7eca3", "5e1a03eb561bac0c63c5efc8c1472119fc3ad405");
//        int i=3;
//        while (i>0){
            PddDdkGoodsPidQueryRequest request = new PddDdkGoodsPidQueryRequest();
            request.setPage((int) 2L);
            request.setPageSize((int) 30L);

            PddDdkGoodsPidQueryResponse response = null;
            try {
                response = client.syncInvoke(request);
            } catch (Exception e) {
                e.printStackTrace();
            }
            List<PddDdkGoodsPidQueryResponse.PIdListItem> pIdList = response.getPIdQueryResponse().getPIdList();
            pIdList.forEach(pIdListItem -> {
                sysPidjdDao.addPidPdd(pIdListItem.getPId())  ;
            });
            System.out.println(JsonUtil.transferToJson(response));
//            i--;
//        }

	}

    /**
     * authkey 必填，你在京东的授权，
     * unionid 必填，你的联盟Id
     * uniontype  可选，默认1，联盟类型 1:CPS 2:CPC
     * page  可选，默认1，页码值。
     * pagesize 可选，默认每页显示20条
     */
	@Test
	public void jd() {
        final String URL = "http://jdapi.apptimes.cn/";
//        String SERVER_URL = "https://router.jd.com/api";
//        String appKey = "1b2eadd4ad604021a9e48aa5726c503b";
//        String appSecret = "909a02d9f2e845578f6333a3a13ea5cd";
//        String accessToken = "";
//        JdClient client = new DefaultJdClient(SERVER_URL, accessToken, appKey, appSecret);
        String jdurl = URL + "querypid?";
        JSONObject temp = new JSONObject();
        Map<String, String> urlSign = new HashMap<>();
        JSONObject da = new JSONObject();
        List<Long> pidList = new ArrayList();
        StringBuilder pid = new StringBuilder();
        urlSign.put("unionid", "1001142862");
        urlSign.put("page", "1");
        urlSign.put("pagesize", "40");
        urlSign.put("authkey", "ece3b6ab1c8b87a7c8865dfe7ac1999750ff2bd682777ce215713a3922b0e6a3d6c05372abf1a06c");
        String linkStringByGet = null;
        try {
            linkStringByGet = NetUtils.createLinkStringByGet(urlSign);
            JSONObject data;
            String res = restTemplate.getForObject(jdurl + linkStringByGet, String.class);
            data = JSON.parseObject(res);
            JSONArray data1 = data.getJSONObject("data").getJSONArray("result");
            data1.forEach(o -> {
                JSONObject d=(JSONObject)o;
                pidList.add(d.getLong("id")) ;
            });
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        pidList.forEach(item->{
            sysPidjdDao.addPidJd(item);
        });



    }

}
