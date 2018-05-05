package com.hommin.study.imoocsell.controller;

import com.hommin.study.imoocsell.config.ProjectProperties;
import com.hommin.study.imoocsell.constant.CookieConstant;
import com.hommin.study.imoocsell.constant.RedisConstant;
import com.hommin.study.imoocsell.dataobject.SellerInfo;
import com.hommin.study.imoocsell.enums.ResultEnum;
import com.hommin.study.imoocsell.sevice.SellerInfoSerivce;
import com.hommin.study.imoocsell.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 卖家信息controller
 *
 * @author Hommin
 * 2018年05月05日 下午6:10
 */
@Controller
@RequestMapping("/seller")
public class SellerUserController {

    @Autowired
    private ProjectProperties projectProperties;

    @Autowired
    private SellerInfoSerivce sellerInfoSerivce;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/login")
    public String login(HttpServletResponse response,
                        @RequestParam("openid") String openid,
                        Model model){
        // 1. 数据库找openid 是否存在, 若不存在, 跳转错误页面;
        SellerInfo sellerInfoByOpenid = sellerInfoSerivce.findSellerInfoByOpenid(openid);
        if(sellerInfoByOpenid == null){
            model.addAttribute("msg", ResultEnum.LOGIN_FAIL.getMessage());
            model.addAttribute("url",  projectProperties.getProjectUrl().getSeller() + "/sell/seller/order/list");
            return "/common/error";
        }

        // 2. 生成token, 并放入session
        String token = UUID.randomUUID().toString();
        stringRedisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX, token), openid, RedisConstant.EXPIRE, TimeUnit.SECONDS);

        // 3. 将token写回浏览器(cookie)
        CookieUtil.set(response, CookieConstant.TOKEN, token, CookieConstant.EXPIRE);
        return "redirect:" + projectProperties.getProjectUrl().getSeller() + "/sell/seller/order/list";
    }

}
