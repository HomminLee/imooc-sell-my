package com.hommin.study.imoocsell.mapper;

import com.hommin.study.imoocsell.dataobject.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryMapperTest {

    @Autowired
    @SuppressWarnings("all")
    private ProductCategoryMapper productCategoryMapper;
    @Test
    public void insert() throws Exception {
        productCategoryMapper.insert("最游记", 110);
    }

    @Test
    public void select(){
        ProductCategory productCategory = productCategoryMapper.selectByCategoryType(110);
        Assert.notNull(productCategory, "查询结果为空");
    }
}