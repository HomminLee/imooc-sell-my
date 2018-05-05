package com.hommin.study.imoocsell.repository;

import com.hommin.study.imoocsell.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Hommin
 * 2017-06-11 17:28
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo, String> {

    SellerInfo findByOpenid(String openid);
}
