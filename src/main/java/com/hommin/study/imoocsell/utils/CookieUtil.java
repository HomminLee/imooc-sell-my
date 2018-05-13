package com.hommin.study.imoocsell.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * cookie工具类
 * Created by 廖师兄
 * 2017-07-30 16:31
 */
public class CookieUtil {

    /**
     * 设置
     * @param response
     * @param name
     * @param value
     * @param maxAge
     */
    public static void set(HttpServletResponse response,
                           String name,
                           String value,
                           int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }

    public static Cookie get(HttpServletRequest request, String name) {
        Map<String, Cookie> cookieMap = readCookieMap(request);
        if(cookieMap.containsKey(name)){
            return cookieMap.get(name);
        } else {
            return null;
        }
    }

    /**
     * 将cookie读取出来, 封装为一个map 方便查找
     * @param request
     * @return
     */
    private static Map<String , Cookie> readCookieMap(HttpServletRequest request){
        HashMap<String , Cookie> cookieMap = new HashMap<>(10);
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            cookieMap.put(cookie.getName(), cookie);
        }
        return cookieMap;
    }
}
