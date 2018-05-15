package com.hommin.study.imoocsell.exception.handler;

import com.hommin.study.imoocsell.exception.ResponseBankException;
import com.hommin.study.imoocsell.exception.SellException;
import com.hommin.study.imoocsell.utils.ResultVOUtil;
import com.hommin.study.imoocsell.vo.ResultVO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Hommin
 * 2018年05月15日 下午8:21
 */
@ControllerAdvice
public class SellExceptionHandler {


    @ExceptionHandler(value = SellException.class)
    public ResultVO handlerForSellException(SellException e){
        return ResultVOUtil.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(ResponseBankException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handlerForResponseBankException(){

    }

}
