package com.hommin.study.imoocsell.sevice;

import com.hommin.study.imoocsell.dto.OrderDTO;

/**
 * @author Hommin
 * @ClassName: BuyerService
 * @Description:
 * @data 2018年04月15日 上午9:56
 */
public interface BuyerService {

    OrderDTO findOrderOne(String openid, String orderId);

    OrderDTO cencelOrderOne(String openid, String orderId);
}
