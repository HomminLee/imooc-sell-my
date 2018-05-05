package com.hommin.study.imoocsell.sevice.impl;

import com.hommin.study.imoocsell.dataobject.SellerInfo;
import com.hommin.study.imoocsell.sevice.SellerInfoSerivce;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerInfoSerivceTest {
    @Autowired
    private SellerInfoSerivce sellerInfoSerivce;

    private static final String OPENID = "hommins`openid";
    @Test
    public void findSellerInfoByOpenid() throws Exception {
        SellerInfo info = sellerInfoSerivce.findSellerInfoByOpenid(OPENID);
        Assert.notNull(info, "找不到该用户");
    }

}