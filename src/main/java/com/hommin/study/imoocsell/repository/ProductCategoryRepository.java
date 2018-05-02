package com.hommin.study.imoocsell.repository;

import com.hommin.study.imoocsell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author hommin
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    /**
     * 分为两个条件查询
     *  CategoryTypeIn： CategoryType在categoryTypes其中，对应第一个参数
     *  categoryName: categoryName等于categoryName，对应第二个参数
     * @param categoryTypes
     * @param categoryName
     * @return
     */
    List<ProductCategory> findByCategoryTypeInAndCategoryName(List<Integer> categoryTypes, String categoryName);

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypes);
}
