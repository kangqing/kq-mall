package com.kangqing.mall.sms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kangqing.mall.sms.pojo.domain.SmsCouponRecord;

/**
 * 优惠券领券记录业务接口
 *
 * @author kangqing
 * @since 2021/3/15
 */
public interface ICouponRecordService extends IService<SmsCouponRecord> {

    /**
     * 用户领券
     * @param couponId
     */
    void add(String couponId);
}
