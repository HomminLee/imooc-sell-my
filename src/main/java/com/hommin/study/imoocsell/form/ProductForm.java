package com.hommin.study.imoocsell.form;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Created by 廖师兄
 * 2017-07-23 17:20
 */
@Data
public class ProductForm {


    private String productId;

    /** 名字. */
    @NotNull(message = "商品名称不能为空")
    private String productName;

    /** 单价. */
    @NotNull(message = "商品单价不能为空")
    private BigDecimal productPrice;

    /** 库存. */
    @NotNull(message = "商品库存不能为空")
    private Integer productStock;

    /** 描述. */
    private String productDescription;

    /** 小图. */
    private String productIcon;

    /** 类目编号. */
    @NotNull(message = "商品所属类目不能为空")
    private Integer categoryType;
}
