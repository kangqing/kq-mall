package com.kangqing.mall.sms.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kangqing.common.web.exception.BizException;
import com.kangqing.common.web.util.RequestUtils;
import com.kangqing.mall.sms.pojo.domain.SmsCoupon;
import com.kangqing.mall.sms.pojo.domain.SmsCouponRecord;
import com.kangqing.mall.sms.pojo.enums.CouponStateEnum;
import com.kangqing.mall.sms.mapper.SmsCouponRecordDao;
import com.kangqing.mall.sms.service.ICouponRecordService;
import com.kangqing.mall.sms.service.ISmsCouponService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

import static com.kangqing.mall.sms.pojo.constant.AppConstants.COUPON_LOCK;


/**
 * 优惠券领券记录业务实现类
 * @author kangqing
 * @since 2021/3/15
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class CouponRecordServiceImpl extends ServiceImpl<SmsCouponRecordDao, SmsCouponRecord> implements ICouponRecordService {

    private final ISmsCouponService couponService;

    private final RedissonClient redissonClient;

    @Override
    public void add(String couponId) {
        Long userId = RequestUtils.getUserId();
        RLock lock = redissonClient.getLock(COUPON_LOCK + couponId);
        lock.lock();

        try {
            SmsCoupon coupon = couponService.getById(couponId);
            this.couponCheck(coupon, userId);
            // 封装优惠券领取记录对象
            SmsCouponRecord couponRecord = new SmsCouponRecord();
            BeanUtils.copyProperties(coupon, couponRecord);
            couponRecord.setStartTime(new Date());
            couponRecord.setEndTime(DateUtil.offsetDay(new Date(), coupon.getValidDays()));
            couponRecord.setUseState(CouponStateEnum.NEW.name());
            couponRecord.setUserId(RequestUtils.getUserId());
            couponRecord.setUserName(RequestUtils.getUsername());
            couponRecord.setCouponId(coupon.getId());
            couponRecord.setId(null);

            // 高并发下扣减库存
            //高并发下扣减劵库存，采用乐观锁,当前stock做版本号,延伸多种防止超卖的问题,一次只能领取1张，TODO
            int rows = couponService.updateTakeStock(couponId);
            if (rows == 1) {
                //库存扣减成功才保存
                this.save(couponRecord);
            } else {
                log.warn("发放优惠券失败，coupon={}，loginUser={}", coupon, userId);
                throw new BizException("发放优惠券失败");
            }
        } finally {
            lock.unlock();
        }
    }

    /**
     * 优惠券检查
     *
     * @param couponEntity
     * @param userId
     */
    private void couponCheck(SmsCoupon couponEntity, long userId) {

        //优惠券不存在
        if (couponEntity == null) {
            throw new BizException("优惠券不存在");
        }
        //库存不足
        if ((couponEntity.getPublishCount() - couponEntity.getTakeCount()) <= 0) {
            throw new BizException("优惠券已经被领光了");
        }
        //是否在领取时间范围
        long time = System.currentTimeMillis();
        long start = couponEntity.getStartTime().getTime();
        long end = couponEntity.getEndTime().getTime();
        if (time < start || time > end) {
            throw new BizException("优惠券不在领券时间范围内");
        }
        //用户是否超过限制
        int recordNum = this.count(new QueryWrapper<SmsCouponRecord>()
                .eq("coupon_id", couponEntity.getId())
                .eq("user_id", userId));

        if (recordNum >= couponEntity.getLimitCount()) {
            throw new BizException("优惠券已经达到领券次数限制");
        }
    }
}
