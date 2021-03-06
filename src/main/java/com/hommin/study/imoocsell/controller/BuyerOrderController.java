package com.hommin.study.imoocsell.controller;

import com.hommin.study.imoocsell.converter.OrderForm2OrderMasterConverter;
import com.hommin.study.imoocsell.dto.OrderDTO;
import com.hommin.study.imoocsell.enums.ResultEnum;
import com.hommin.study.imoocsell.exception.SellException;
import com.hommin.study.imoocsell.form.OrderForm;
import com.hommin.study.imoocsell.sevice.BuyerService;
import com.hommin.study.imoocsell.sevice.OrderService;
import com.hommin.study.imoocsell.sevice.WebSocketService;
import com.hommin.study.imoocsell.utils.ResultVOUtil;
import com.hommin.study.imoocsell.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Hommin
 * @data 2018年04月10日 下午8:52
 */
@RestController
@Slf4j
@RequestMapping("/buyer/order")
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    @SuppressWarnings("all")
    private BuyerService buyerService;

    @Autowired
    private WebSocketService webSocketService;

    // 创建订单
    @PostMapping("/create")
    public ResultVO<Map<String, String>> createOrder(@Valid OrderForm orderForm, BindingResult result){
        if(result.hasErrors()){
            log.error("[订单创建]参数不正确, orderFrom={}", orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(), result.getFieldError().getDefaultMessage());
        }

        OrderDTO orderDTO = OrderForm2OrderMasterConverter.converter(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("[订单创建] 购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }

        OrderDTO createResult = orderService.create(orderDTO);
        if(createResult == null){
            log.error("[订单创建] 创建失败");
            throw new SellException(ResultEnum.CREAT_ERROR);
        }

        Map<String, String> map = new HashMap<>();
        map.put("orderId", createResult.getOrderId());

        // 发送websocket消息
        webSocketService.sendMessage(String.format("您有新的订单, 订单号为%s", orderDTO.getOrderId()));


        return ResultVOUtil.success(map);

    }

    //订单列表
    @GetMapping("/list")
    public ResultVO<List<OrderDTO>> list(@RequestParam("openid") String openid,
                                         @RequestParam(value = "page", defaultValue = "0") Integer page,
                                         @RequestParam(value = "size", defaultValue = "10") Integer size) {
        if (StringUtils.isEmpty(openid)) {
            log.error("【查询订单列表】openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        PageRequest request = new PageRequest(page, size);
        Page<OrderDTO> orderDTOPage = orderService.findList(openid, request);

        return ResultVOUtil.success(orderDTOPage.getContent());
    }

    //订单详情
    @GetMapping("/detail")
    public ResultVO<OrderDTO> detail(@RequestParam("openid") String openid,
                                     @RequestParam("orderId") String orderId) {
        OrderDTO orderDTO = buyerService.findOrderOne(openid, orderId);
        return ResultVOUtil.success(orderDTO);
    }

    //取消订单
    @PostMapping("/cancel")
    public ResultVO cancel(@RequestParam("openid") String openid,
                           @RequestParam("orderId") String orderId) {
        OrderDTO orderDTO = buyerService.cencelOrderOne(openid, orderId);
        return ResultVOUtil.success();
    }
}
