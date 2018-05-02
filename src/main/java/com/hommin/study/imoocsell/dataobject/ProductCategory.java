package com.hommin.study.imoocsell.dataobject;


import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author Hommin
 * @ClassName: ProductCategory
 * @Description:
 * @data 2018年04月07日 上午11:16
 *
 * table: product_category
 */
//@javax.persistence.Table(name = "s_product_category") 如果数据库表明和类名不符合，可以使用Table注解进行对应
@Entity
@DynamicUpdate
@Data
public class ProductCategory {

    /**
     * 类目id
     */
    @Id
    @GeneratedValue
    private Integer categoryId;

    /**
     * 类目名称
     */
    private String categoryName;
    /**
     *  类目类型
     */
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;
}
