package com.hommin.study.imoocsell.config;

import me.chanjar.weixin.mp.api.WxMpConfigStorage;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Hommin
 * @ClassName: WechatConfig
 * @Description:
 * @data 2018年04月15日 下午3:41
 */
@Configuration
public class WechatConfig {

    @Autowired
    private ProjectProperties projectProperties;

    @Bean
    public WxMpService wxMpService(){
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxMpConfigStorag());
        return wxMpService;
    }

    @Bean
    public WxMpConfigStorage wxMpConfigStorag(){
        WxMpConfigStorage wxMpConfigStorag = new WxMpInMemoryConfigStorage();
        ((WxMpInMemoryConfigStorage) wxMpConfigStorag).setAppId(projectProperties.getWechat().getAppid());
        ((WxMpInMemoryConfigStorage) wxMpConfigStorag).setSecret(projectProperties.getWechat().getAppsecret());
        return wxMpConfigStorag;
    }

    @Bean
    public WxMpService wxOpenService(){
        WxMpService wxOpenService = new WxMpServiceImpl();
        wxMpService().setWxMpConfigStorage(wxOpenConfigStorage());
        return wxOpenService;
    }

    @Bean
    public WxMpConfigStorage wxOpenConfigStorage(){
        WxMpConfigStorage wxMpConfigStorag = new WxMpInMemoryConfigStorage();
        ((WxMpInMemoryConfigStorage) wxMpConfigStorag).setAppId(projectProperties.getWechat().getOpenid());
        ((WxMpInMemoryConfigStorage) wxMpConfigStorag).setSecret(projectProperties.getWechat().getOpensecret());
        return wxMpConfigStorag;
    }

}
