package com.pxc.controller;

import com.pxc.service.WeChatService;
import me.chanjar.weixin.common.api.WxConsts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by pxc on 2018/4/3.
 */
@Controller
@RequestMapping("/wechat")
public class WeChatController {

    private final Logger logger = LoggerFactory.getLogger(WeChatController.class);

    @Autowired
    private WeChatService weChatService;

    @GetMapping("/authorize")
    public String authorize(@RequestParam("returnUrl") String returnUrl) {
        logger.info("入参：" + returnUrl);
        String redirectUrl = weChatService.getRedirectUrl(returnUrl);
        logger.info("redirectUrl：" + redirectUrl);
        return "redirect:" + redirectUrl;
    }

    @GetMapping("/userInfo")
    public String userInfo(@RequestParam("code") String code,
                           @RequestParam("state") String returnUrl) {
       /* WxMpOAuth2AccessToken wxMpOAuth2AccessToken = new WxMpOAuth2AccessToken();
        try {
            wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
        } catch (WxErrorException e) {
            log.error("【微信网页授权】{}", e);
            throw new SellException(ResultEnum.WECHAT_MP_ERROR.getCode(), e.getError().getErrorMsg());
        }

        String openId = wxMpOAuth2AccessToken.getOpenId();*/

        return "redirect:" + returnUrl + "?openid=" + "123";
    }
}
