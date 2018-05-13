package com.hommin.study.imoocsell.exception.handler;

import com.hommin.study.imoocsell.exception.AuthenticatiolnErrorException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 登录异常处理器
 *
 * @author Hommin
 * 2018年05月13日 上午10:37
 */
@ControllerAdvice
public class AuthenticatiolnErrorExceptionHandler {

    @ExceptionHandler(value = AuthenticatiolnErrorException.class)
    public ModelAndView handlerAuthorizeException() {
        return new ModelAndView("//跳转页面");
    }
}
