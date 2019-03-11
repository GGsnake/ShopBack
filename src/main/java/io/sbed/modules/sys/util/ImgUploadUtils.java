package io.sbed.modules.sys.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Date;

import com.google.gson.Gson;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

/**上传图片到七牛云
 * @Description:
 * @Author: bao
 * @CreateDate: 2018/7/27 0027 下午 5:23
 */
public class ImgUploadUtils {
    public static String upload(byte[] file, String prefix, String suffix) throws IOException {
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone2());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传
        String accessKey = "Pj9hJWekBfxCfUgu4MuKlLvx6WQPX7HRbUcyDIXu";
        String secretKey = "dxoV_UMvQ_bOPLHnd_DEt1U4XfvX9Z7ELa1ke2wx";
        String bucket = "quanhuang";

        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = prefix + String.valueOf(new Date().getTime()) + suffix;


        ByteArrayInputStream byteInputStream = new ByteArrayInputStream(file);
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);

        Response response = uploadManager.put(byteInputStream, key, upToken, null, null);

        if (response.statusCode != 200){
            return "1";
        }
        //解析上传成功的结果
        DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
        byteInputStream.close();
       
        return putRet.key;

    }
}
