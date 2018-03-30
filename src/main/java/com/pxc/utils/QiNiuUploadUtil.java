package com.pxc.utils;

import com.google.gson.Gson;
import com.pxc.config.QiNiuConfig;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.UUID;

/**
 * Created by pxc on 2018/3/30.
 */
public class QiNiuUploadUtil {

    private static final Logger logger = LoggerFactory.getLogger(QiNiuUploadUtil.class);

    public static String uploadByInputStream(InputStream inputStream) {

        String key = UUID.randomUUID().toString() + ".png";
        Auth auth = Auth.create(QiNiuConfig.ACCESS_KEY, QiNiuConfig.SECRET_KEY);

        //要上传的空间(bucket)的存储区域为华北时
        Zone z = Zone.zone1();
        Configuration c = new Configuration(z);
        //创建上传对象
        UploadManager uploadManager = new UploadManager(c);
        String upToken = auth.uploadToken(QiNiuConfig.BUCKET_NAME);
        try {
            Response response = uploadManager.put(inputStream, key, upToken, null, null);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            return QiNiuConfig.BUCKET_URL + putRet.key;
        } catch (QiniuException ex) {
            Response r = ex.response;
            logger.error(r.toString());
            try {
                logger.error(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
            return null;
        }

    }
}
