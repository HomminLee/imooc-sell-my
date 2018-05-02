package com.hommin.study.imoocsell.converter;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.hommin.study.imoocsell.dataobject.OrderDetail;
import com.hommin.study.imoocsell.dto.OrderDTO;
import com.hommin.study.imoocsell.enums.ResultEnum;
import com.hommin.study.imoocsell.exception.SellException;
import com.hommin.study.imoocsell.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author Hommin
 * @data 2018年04月10日 下午9:08
 */
@Slf4j
public class OrderForm2OrderMasterConverter {

    public static OrderDTO converter(OrderForm orderForm){
        OrderDTO orderDto = new OrderDTO();
        orderDto.setBuyerName(orderForm.getName());
        orderDto.setBuyerAddress(orderForm.getAddress());
        orderDto.setBuyerPhone(orderForm.getPhone());
        orderDto.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetails = null;
        try {
            Gson gson = new Gson();
            orderDetails = gson.fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>() {   }.getType());
//            orderDetails = JSON.parseArray(orderForm.getItems(), OrderDetail.class);
        } catch (JsonSyntaxException e) {
           log.error("[转换对象]错误, string={}", orderForm.getItems());
           throw new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDto.setOrderDetailList(orderDetails);
        return orderDto;

    }
}
