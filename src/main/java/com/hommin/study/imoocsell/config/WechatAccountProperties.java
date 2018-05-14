package com.hommin.study.imoocsell.config;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Hommin
 * @ClassName: WechatAccountProperties
 * @Description:
 * @data 2018年04月15日 下午3:47
 */
@Component
@Data
public class WechatAccountProperties {

    /**
     * 公众平台id
     */
    private String appid;

    /**
     * 公众平台密钥
     */
    private String appsecret;

    /**
     * 开放平台id
     */
    private String openid;

    /**
     * 开放平台密钥
     */
    private String opensecret;

    /**
     * 商户号
     */
    private String mchId;

    /**
     * 商户密钥
     */
    private String mchKey;

    /**
     * 商户证书路径
     */
    private String keyPath;

    /**
     * 微信支付异步通知地址
     */
    private String notifyUrl;

    /**
     * 微信模版id
     */
    private Map<String, String> templateId;

}
