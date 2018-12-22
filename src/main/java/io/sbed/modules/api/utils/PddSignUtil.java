package io.sbed.modules.api.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

/**
 * Created by liujupeng on 2018/11/2.
 */
@ConfigurationProperties(prefix = "sys.jwt")
@Component
public class PddSignUtil {
    private String secret;
    private String client_id;

    /**
     * 计算sign
     * @param algo
     * @return
     */
    public static String pddSign(String algo) {
        String sign = DigestUtils.md5DigestAsHex(algo.getBytes());
        return sign;
    }

}
