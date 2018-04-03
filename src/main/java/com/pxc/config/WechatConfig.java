package com.pxc.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by pxc on 2018/4/3.
 */
@ConfigurationProperties(prefix = "wechatconfig")
@Component
public class WechatConfig {

    private String appId;

    private String appSecret;

    private String appServer;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getAppServer() {
        return appServer;
    }

    public void setAppServer(String appServer) {
        this.appServer = appServer;
    }
}
