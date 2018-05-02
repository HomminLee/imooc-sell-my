package com.hommin.study.imoocsell.sevice.impl;

import com.hommin.study.imoocsell.dataobject.ProductCategory;
import com.hommin.study.imoocsell.sevice.CategoryService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void findOne() {
        ProductCategory record = categoryService.findOne(1);
        Assert.assertNotNull(record);
    }

    @Test
    public void findAll() {
        List<ProductCategory> list = categoryService.findAll();
        Assert.assertNotEquals(0, list.size());
    }

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> list = categoryService.findByCategoryTypeIn(Arrays.asList(2, 5));

        Assert.assertNotEquals(0, list.size());
    }

    @Test
    @Transactional
    public void saveOrUpdate() {
        ProductCategory record = new ProductCategory();
        record.setCategoryName("娃哈哈");
        record.setCategoryType(3);
        Integer integer = categoryService.saveOrUpdate(record);
        assertNotEquals(new Integer(0), integer);
    }
}