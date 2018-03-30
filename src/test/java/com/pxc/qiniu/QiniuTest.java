package com.pxc.qiniu;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import org.junit.Test;

import java.io.*;
import java.net.URLEncoder;
import java.util.UUID;

/**
 * Created by pxc on 2018/3/29.
 */
public class QiniuTest {

    //设置好账号的ACCESS_KEY和SECRET_KEY
    String ACCESS_KEY = "7zHabdxp3aC2NJEZrN5jCKa-K53QKWdZSoHUMkjw";
    String SECRET_KEY = "WZ2a0aXd0MC5DmoWCuBwqFKWOs35WlLZ-0GtdkWt";
    //要上传的空间
    String bucketname = "sell";
    //上传到七牛后保存的文件名
    String key = "my-java.png";
    //上传文件的路径
    String FilePath = "D:/test.gif";

    //密钥配置
    Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

    ///////////////////////指定上传的Zone的信息//////////////////
    //第一种方式: 指定具体的要上传的zone
    //注：该具体指定的方式和以下自动识别的方式选择其一即可
    //要上传的空间(bucket)的存储区域为华东时
    // Zone z = Zone.zone0();
    //要上传的空间(bucket)的存储区域为华北时
    // Zone z = Zone.zone1();
    //要上传的空间(bucket)的存储区域为华南时
    // Zone z = Zone.zone2();

    //第二种方式: 自动识别要上传的空间(bucket)的存储区域是华东、华北、华南。
    Zone z = Zone.zone1();
    Configuration c = new Configuration(z);

    //创建上传对象
    UploadManager uploadManager = new UploadManager(c);

    public static void main(String args[]) throws IOException {
        new QiniuTest().uploadInputStream();
    }

    //简单上传，使用默认策略，只需要设置上传的空间名就可以了
    public String getUpToken() {
        return auth.uploadToken(bucketname);
    }

    public void upload() throws IOException {
        try {
            //调用put方法上传
            Response res = uploadManager.put(FilePath, key, getUpToken());
            //打印返回的信息
            System.out.println(res.bodyString());
        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时打印的异常的信息
            System.out.println(r.toString());
            try {
                //响应的文本信息
                System.out.println(r.bodyString());
            } catch (QiniuException e1) {
                //ignore
            }
        }
    }

    public void downLoad(){
        String fileName = "my-java.png";
        String domainOfBucket = "http://p6e4qlpue.bkt.clouddn.com";
        String encodedFileName = null;
        try {
            encodedFileName = URLEncoder.encode(fileName, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String publicUrl = String.format("%s/%s", domainOfBucket, encodedFileName);
        String accessKey = "7zHabdxp3aC2NJEZrN5jCKa-K53QKWdZSoHUMkjw";
        String secretKey = "WZ2a0aXd0MC5DmoWCuBwqFKWOs35WlLZ-0GtdkWt";
        Auth auth = Auth.create(accessKey, secretKey);
        long expireInSeconds = 3600;//1小时，可以自定义链接过期时间
        String finalUrl = auth.privateDownloadUrl(publicUrl, expireInSeconds);
        System.out.println(finalUrl);

    }

    public void uploadInputStream(){
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        //设置好账号的ACCESS_KEY和SECRET_KEY
        String ACCESS_KEY = "7zHabdxp3aC2NJEZrN5jCKa-K53QKWdZSoHUMkjw";
        String SECRET_KEY = "WZ2a0aXd0MC5DmoWCuBwqFKWOs35WlLZ-0GtdkWt";
        //要上传的空间
        String bucketname = "sell";
        String key = "test.gif";
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        String upToken = auth.uploadToken(bucketname);
        try {
            FileInputStream fileInputStream = new FileInputStream(new File("D:/test.gif"));
            Response response = uploadManager.put(fileInputStream,key,upToken,null, null);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(putRet.key);
            System.out.println(putRet.hash);
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1(){
        System.out.println(UUID.randomUUID().toString());
    }
}
