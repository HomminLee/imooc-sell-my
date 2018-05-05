package com.hommin.study.imoocsell.form;


import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author Hommin
 * 2018年04月07日 上午11:16
 */
@Data
public class CategoryForm {

    /**
     * 类目id
     */
    private Integer categoryId;

    /**
     * 类目名称
     */
    @NotNull(message = "类目名称不能为空")
    private String categoryName;
    /**
     *  类目类型
     */
    @NotNull(message = "类目类型不能为空")
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;
}
