package com.hommin.study.imoocsell.controller;

import com.hommin.study.imoocsell.dto.OrderDTO;
import com.hommin.study.imoocsell.enums.ResultEnum;
import com.hommin.study.imoocsell.exception.SellException;
import com.hommin.study.imoocsell.sevice.OrderService;
import com.hommin.study.imoocsell.sevice.PaySerivce;
import com.lly835.bestpay.model.PayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author Hommin
 * @ClassName: PayController
 * @Description:
 * @data 2018年04月18日 下午10:18
 */
@Controller
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private PaySerivce paySerivce;

    @GetMapping("/creat")
    public String creat(@RequestParam("orderId")String orderId,
                        @RequestParam("returnUrl")String returnUrl,
                        Model model){
        // 1. 查询订单 并校验
        OrderDTO orderDTO = orderService.findOne(orderId);
        if(orderDTO == null){
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        // 2. 发起支付
        PayResponse payResponse = paySerivce.creat(orderDTO);
        model.addAttribute("payResponse", payResponse);
        model.addAttribute("returnUrl", returnUrl);

        return "/pay/creat";
    }

    @PostMapping("/notify")
    public String notify(@RequestBody String notifyData){
        PayResponse notify = paySerivce.notify(notifyData);
        //返回给微信处理结果
        return "pay/success";
    }

}
