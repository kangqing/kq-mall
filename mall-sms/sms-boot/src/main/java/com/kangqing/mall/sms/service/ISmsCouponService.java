package com.kangqing.mall.sms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kangqing.common.base.BasePageQuery;
import com.kangqing.mall.sms.pojo.domain.SmsCoupon;
import com.kangqing.mall.sms.pojo.form.CouponForm;
import com.kangqing.mall.sms.pojo.vo.SmsCouponVO;

/**
 * @author huawei
 * @since 2021/3/14
 */
public interface ISmsCouponService extends IService<SmsCoupon> {

    /**
     * 获取优惠券详情
     *
     * @param couponId 优惠券ID
     */
    SmsCouponVO detail(String couponId);

    /**
     * 新增优惠券
     *
     * @param form 新增提交表单
     */
    void add(CouponForm form);

    /**
     * 修改优惠券
     *
     * @param form 修改优惠券提交表单
     */
    void modify(CouponForm form);

    IPage<SmsCoupon> pageQuery(Page<SmsCoupon> page, BasePageQuery query);

    /**
     * 根据已领券数量
     * @param couponId
     * @return
     */
    int updateTakeStock(String couponId);
}
