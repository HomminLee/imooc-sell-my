package com.hommin.study.imoocsell.controller;

import com.hommin.study.imoocsell.dataobject.ProductCategory;
import com.hommin.study.imoocsell.dataobject.ProductInfo;
import com.hommin.study.imoocsell.sevice.CategoryService;
import com.hommin.study.imoocsell.sevice.ProductService;
import com.hommin.study.imoocsell.utils.ResultVOUtil;
import com.hommin.study.imoocsell.vo.ProductInfoVO;
import com.hommin.study.imoocsell.vo.ProductVO;
import com.hommin.study.imoocsell.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Hommin
 * @ClassName: BuyerProductController
 * @Description: 买家端
 * @data 2018年04月08日 下午8:26
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public ResultVO list(){
        // 1. 查询所有上架商品
        List<ProductInfo> productUpAll = productService.findUpAll();

        // 2. 获取所有类目
        List<Integer> categoryTypeList = productUpAll.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        // 3. 数据拼装
        ArrayList<ProductVO> productList = new ArrayList<>();

        productCategoryList.forEach(item -> {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(item.getCategoryName());
            productVO.setCategoryType(item.getCategoryType());

            ArrayList<ProductInfoVO> productVoList = new ArrayList<>();
            productUpAll.forEach(productInfo -> {
                if(productInfo.getCategoryType().equals(item.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productVoList.add(productInfoVO);
                }
            });
            productVO.setProductInfoVOList(productVoList);
            productList.add(productVO);
        });

        return ResultVOUtil.success(productList);
    }


}
