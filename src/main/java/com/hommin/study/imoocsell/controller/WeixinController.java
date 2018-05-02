package com.hommin.study.imoocsell.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Hommin
 * @ClassName: WeixinController
 * @Description:
 * @data 2018年04月15日 下午2:36
 */
@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeixinController {

    @GetMapping("/auth")
    public String auth(@RequestParam("code")String  code){
        log.info("进入方法");
        log.info("[微信登录]获取code={}", code);
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx48458d7156023188&secret=3aca041bf480ca1325e7bf3ce14afe89&code="
                + code+"&grant_type=authorization_code";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);

        log.info("[微信登录]换取access_token={}", result);
        return result;
    }

}
