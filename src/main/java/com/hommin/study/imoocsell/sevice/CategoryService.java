package com.hommin.study.imoocsell.sevice;

import com.hommin.study.imoocsell.dataobject.ProductCategory;

import java.util.List;

/**
 * @author Hommin
 * @ClassName: CategoryService
 * @Description:
 * @data 2018年04月07日 下午9:37
 */
public interface CategoryService {

    /**
     * 通过id查找
     * @param id
     * @return
     */
    ProductCategory findOne(Integer id);

    /**
     * 查找所有
     * @return
     */
    List<ProductCategory> findAll();

    /**
     * 查找所有categoryType 存在于该集合中
     * @param categoryTypes
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypes);

    /**
     * 保存或更新
     * @return
     */
    Integer saveOrUpdate(ProductCategory record);

}
