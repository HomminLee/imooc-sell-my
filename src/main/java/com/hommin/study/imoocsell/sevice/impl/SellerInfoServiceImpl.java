package com.hommin.study.imoocsell.sevice.impl;

import com.hommin.study.imoocsell.dataobject.SellerInfo;
import com.hommin.study.imoocsell.repository.SellerInfoRepository;
import com.hommin.study.imoocsell.sevice.SellerInfoSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 卖家信息的service impl
 *
 * @author Hommin
 * 2018年05月05日 下午5:22
 */
@Service
public class SellerInfoServiceImpl implements SellerInfoSerivce{

    @Autowired
    private SellerInfoRepository repository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openId) {
        return repository.findByOpenid(openId);
    }
}
