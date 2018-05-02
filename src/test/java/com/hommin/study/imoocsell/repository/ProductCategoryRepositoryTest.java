package com.hommin.study.imoocsell.repository;

import com.hommin.study.imoocsell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    public void findOne(){
        ProductCategory daoOne = productCategoryRepository.findOne(1);
        System.out.println(daoOne);
    }

    @Test
    public void save(){
        ProductCategory record = productCategoryRepository.findOne(3);
        record.setCategoryName("小米手环");
        record.setCategoryType(5);
        ProductCategory result = productCategoryRepository.save(record);
        Assert.assertNotNull(record);
    }

    @Test
    public void findProductCategoryByCategoryTypeIn(){
        List<Integer> integers = Arrays.asList(1, 5);
        List<ProductCategory> results = productCategoryRepository.findByCategoryTypeInAndCategoryName(integers, "小米手环");
        Assert.assertNotEquals(0, results);
    }

}