package com.hommin.study.imoocsell.config;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author Hommin
 * @ClassName: WechatAccountProperties
 * @Description:
 * @data 2018年04月15日 下午3:47
 */
@Component
@Data
public class WechatAccountProperties {

    private String appid;

    private String appsecret;

    private String openid;

    private String opensecret;

    private String mchId;

    private String mchKey;

    private String keyPath;

    /**   微信支付完成后异步通知的地址   */
    private String notifyUrl;

}
