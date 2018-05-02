package com.hommin.study.imoocsell.controller;

import com.hommin.study.imoocsell.config.ProjectPorperties;
import com.hommin.study.imoocsell.enums.ResultEnum;
import com.hommin.study.imoocsell.exception.SellException;
import com.hommin.study.imoocsell.utils.ResultVOUtil;
import com.hommin.study.imoocsell.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URLEncoder;

/**
 * @author Hommin
 * @ClassName: WechatController
 * @Description: 使用第三方SDK方式访问微信
 * @data 2018年04月15日 下午3:34
 */
@Controller
@RequestMapping("/wechat")
@Slf4j
public class WechatController {

    @Autowired
    private WxMpService wxMpService;
    @Autowired
    private ProjectPorperties projectPorperties;

    @RequestMapping("authorize")
    public String authentication(@RequestParam("returnUrl") String state){
        // 1. 配置
        // 配置过程放于WechatConfig

        // 2. 使用wxMpService 调用方法
        String url = projectPorperties.getAddress() + "wechat/userInfo";
        String redirectUrl = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAUTH2_SCOPE_BASE, URLEncoder.encode(state));

        return "redirect:" + redirectUrl;
    }

    @RequestMapping("/userInfo")
    public String  userInfo(@RequestParam("code") String code, @RequestParam("state") String redirectUrl){
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken;
        try {
            wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
        } catch (WxErrorException e) {
            log.error("[微信获得授权]{}", e);
            throw new SellException(ResultEnum.WECHAT_MP_ERROR.getCode(), e.getError().getErrorMsg());
        }
        String openId = wxMpOAuth2AccessToken.getOpenId();
        log.info("[微信获得授权]openid={}", openId);

        return "redirect:" + redirectUrl + "?openid=" + openId;
    }
}
