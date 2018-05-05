package com.hommin.study.imoocsell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Hommin
 * @ClassName: ProjectPorperties
 * @Description:
 * @data 2018年04月15日 下午3:44
 */
@Data
@Component
@ConfigurationProperties(prefix = "imooc.sell")
public class ProjectProperties {

    private ProjectUrlProperties projectUrl;

    /**   微信账号参数   */
    private WechatAccountProperties wechat;


}
