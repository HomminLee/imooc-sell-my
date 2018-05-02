package com.hommin.study.imoocsell.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author Hommin
 * @ClassName: OrderForm
 * @Description:
 * @data 2018年04月10日 下午8:56
 */
@Data
public class OrderForm {

    /**   购买者姓名   */
    @NotNull(message = "姓名不能为空")
    private String name;

    /**   购买者电话   */
    @NotNull(message = "电话不能为空")
    private String phone;

    /**   购买者地址   */
    @NotNull(message = "地址不能为空")
    private String address;

    /**   购买者的openid   */
    @NotNull(message = "openid不能为空")
    private String openid;

    /**   购买的商品   */
    @NotNull(message = "购物车不能为空")
    private String items;
}
