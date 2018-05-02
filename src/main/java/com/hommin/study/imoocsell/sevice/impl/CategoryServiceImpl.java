package com.hommin.study.imoocsell.sevice.impl;

import com.hommin.study.imoocsell.repository.ProductCategoryRepository;
import com.hommin.study.imoocsell.dataobject.ProductCategory;
import com.hommin.study.imoocsell.sevice.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Hommin
 * @ClassName: CategoryServiceImpl
 * @Description:
 * @data 2018年04月07日 下午9:43
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public ProductCategory findOne(Integer id) {
        return productCategoryRepository.findOne(id);
    }

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryRepository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypes) {
        return productCategoryRepository.findByCategoryTypeIn(categoryTypes);
    }

    @Override
    public Integer saveOrUpdate(ProductCategory record) {
        ProductCategory category = productCategoryRepository.save(record);
        return category != null ? 1 : 0;
    }
}
