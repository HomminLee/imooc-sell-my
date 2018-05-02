package com.hommin.study.imoocsell.sevice;

import com.hommin.study.imoocsell.dto.OrderDTO;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;

/**
 * @author Hommin
 * @ClassName: PaySerivce
 * @Description:
 * @data 2018年04月18日 下午10:08
 */
public interface PaySerivce {

    /**
     * 发起支付(发起支付只是在微信页面上支付弹窗,待用户支付完成后,返回结果,且这结果并不可靠, 需要异步通知来实际确定支付结果)
     * @param orderDTO
     * @return
     */
    PayResponse creat(OrderDTO orderDTO);

    /**
     *  微信支付完成后的结果异步通知
     * @param notifyData
     * @return
     */
    PayResponse notify(String notifyData);

    /**
     * 退款
     * @return
     */
    RefundResponse refund(OrderDTO orderDTO);
}
