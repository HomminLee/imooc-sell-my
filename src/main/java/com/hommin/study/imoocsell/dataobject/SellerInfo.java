package com.hommin.study.imoocsell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * 卖家详情
 *
 * @author Hommin
 * 2018年05月05日 下午5:14
 */
@Data
@Entity
@DynamicUpdate
public class SellerInfo {

    @Id
    @Column(name = "id")
    private String sellerId;

    private String username;

    private String password;

    private String openid;

    private Date createTime;

    private Date updateTime;
}
