package com.hommin.study.imoocsell.aspect;

import com.hommin.study.imoocsell.constant.CookieConstant;
import com.hommin.study.imoocsell.exception.AuthenticatiolnErrorException;
import com.hommin.study.imoocsell.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * aspect-登录判断
 *
 * @author Hommin
 * 2018年05月13日 上午10:22
 */
@Aspect
@Component
@Slf4j
public class LoginAspect {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Pointcut("execution(public * com.hommin.study.imoocsell.controller.Seller*.*(..))" +
            " && !execution(public * com.hommin.study.imoocsell.controller.SellerUserController.*(..))")
    private void loginAuthentication() {
    }

    @Before("loginAuthentication()")
    public void doVerify() {
        // 从request中找到cookie
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);

        // 若不存在 ,异常
        if (cookie == null) {
            log.info("[登录校验] 找不到cookie");
            throw new AuthenticatiolnErrorException();
        }

        // 从redis中找到entity, 若不存在, 异常
        String tokenString = redisTemplate.opsForValue().get(cookie.getValue());
        if (StringUtils.isEmpty(tokenString)) {
            log.info("[登录校验] redis中找不到token");
            throw new AuthenticatiolnErrorException();
        }

    }


}
