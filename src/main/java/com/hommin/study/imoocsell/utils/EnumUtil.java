package com.hommin.study.imoocsell.utils;

import com.hommin.study.imoocsell.enums.CodeEnum;

/**
 * @author Hommin
 * @ClassName: EnumUtil
 * @Description:
 * @data 2018年04月19日 下午9:57
 */
public class EnumUtil<T> {

    public static <T extends CodeEnum> T getEnumByCode(Integer code, Class<T> clazz){
        for (T each : clazz.getEnumConstants()) {
            if(each.getCode().equals(code)){
                return each;
            }
        }
        return null;
    }

}
