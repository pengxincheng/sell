package com.pxc.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by 廖师兄
 * 2017-07-03 00:50
 */
@RestController
@RequestMapping("/weixin")

public class WeixinController {

    private Logger logger = LoggerFactory.getLogger(WeixinController.class);

    @GetMapping("/auth")
    public void auth(@RequestParam("code") String code) {
        logger.info("进入auth方法。。。");
        logger.info("code={}", code);

        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxfef6001cf6a3364a&secret=bc017c09c20f4749e7efd0e614222b49&code=" + code + "&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        logger.info("response={}", response);
    }
}
