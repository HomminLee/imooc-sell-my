package com.hommin.study.imoocsell.sevice.impl;

import com.hommin.study.imoocsell.dto.OrderDTO;
import com.hommin.study.imoocsell.enums.ResultEnum;
import com.hommin.study.imoocsell.exception.SellException;
import com.hommin.study.imoocsell.sevice.BuyerService;
import com.hommin.study.imoocsell.sevice.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Hommin
 * @ClassName: BuyerServiceImpl
 * @Description:
 * @data 2018年04月15日 上午9:58
 */
@Slf4j
@Service
public class BuyerServiceImpl  implements BuyerService {
    @Autowired
    private OrderService orderService;

    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {
        return findAndCheckOwner(openid, orderId);
    }

    @Override
    public OrderDTO cencelOrderOne(String openid, String orderId) {
        OrderDTO orderDTO = this.findAndCheckOwner(openid, orderId);
        if(orderDTO == null){
            log.error("[订单取消]查不到订单, orderId={}", orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderService.cancel(orderDTO);
    }

    private OrderDTO findAndCheckOwner(String openid, String orderId) {
        OrderDTO orderDTO = orderService.findOne(orderId);
        if(orderDTO == null){
            return null;
        }
        if (!orderDTO.getBuyerOpenid().equals(openid)) {
            log.error("[查询订单]订单的openid不一致, openid={}, orderDTO={}", openid, orderDTO);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDTO;
    }
}
