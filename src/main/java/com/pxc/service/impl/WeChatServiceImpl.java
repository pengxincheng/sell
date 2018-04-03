package com.pxc.service.impl;

import com.pxc.config.WechatConfig;
import com.pxc.service.WeChatService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;

/**
 * Created by pxc on 2018/4/3.
 */
@Service
public class WeChatServiceImpl implements WeChatService {

    @Autowired
    private WechatConfig wechatConfig;

    @Override
    public String getRedirectUrl(String state) {
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
        url = url.replace("APPID", wechatConfig.getAppId());
        url = url.replace("REDIRECT_URI", wechatConfig.getAppServer() + "/sell/wechat/userInfo");
        url = url.replace("SCOPE", "snsapi_userinfo");
        url = url.replace("STATE", URLEncoder.encode(state));
        return url;
    }
}
