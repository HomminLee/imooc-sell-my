package com.hommin.study.imoocsell.exception;

import com.hommin.study.imoocsell.enums.ResultEnum;

/**
 * @author Hommin
 * @ClassName: SellException
 * @Description:
 * @data 2018年04月09日 上午9:45
 */
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
