package com.hommin.study.imoocsell.config;

import com.lly835.bestpay.config.WxPayH5Config;
import com.lly835.bestpay.service.BestPayService;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author Hommin
 * @ClassName: PayConfig
 * @Description:
 * @data 2018年04月18日 上午9:08
 */
@Component
public class PayConfig {

    @Autowired
    private WechatAccountProperties wechatAccountProperties;

    @Bean
    public BestPayService bestPayService(){
        BestPayServiceImpl bestPayService = new BestPayServiceImpl();
        bestPayService.setWxPayH5Config(wxPayH5Config());
        return bestPayService;
    }

    @Bean
    public WxPayH5Config wxPayH5Config(){
        WxPayH5Config wxPayH5Config = new WxPayH5Config();
        wxPayH5Config.setAppId(wechatAccountProperties.getAppid());
        wxPayH5Config.setAppSecret(wechatAccountProperties.getAppsecret());
        wxPayH5Config.setMchId(wechatAccountProperties.getMchId());
        wxPayH5Config.setMchKey(wechatAccountProperties.getMchKey());
        wxPayH5Config.setNotifyUrl(wechatAccountProperties.getNotifyUrl());
        return wxPayH5Config;
    }

}
