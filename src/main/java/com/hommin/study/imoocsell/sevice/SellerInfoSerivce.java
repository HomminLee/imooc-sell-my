package com.hommin.study.imoocsell.sevice;

import com.hommin.study.imoocsell.dataobject.SellerInfo;

/**
 * 卖家信息service
 *
 * @author Hommin
 * 2018年05月05日 下午5:21
 */
public interface SellerInfoSerivce {

    /**
     * 通过openid查找卖家
     * @param openId 微信开放平台openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openId);

}
