package com.hommin.study.imoocsell.controller;

import com.hommin.study.imoocsell.dataobject.ProductInfo;
import com.hommin.study.imoocsell.sevice.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * 买家端商品controller
 *
 * @author Hommin
 * 2018年05月05日 下午4:34
 */
@RestController
@RequestMapping("/seller/product")
public class SellerProductController {
    @Autowired
    private ProductService productService;

    /**
     * 列表
     * @param page 页码
     * @param size 分页数量
     * @param map 跳转参数
     * @return 返回ModelAndView
     */
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "10") Integer size,
                             Map<String, Object> map) {
        PageRequest request = new PageRequest(page - 1, size);
        Page<ProductInfo> productInfoPage = productService.findAll(request);
        map.put("productInfoPage", productInfoPage);
        map.put("currentPage", page);
        map.put("size", size);
        return new ModelAndView("product/list", map);
    }
}
