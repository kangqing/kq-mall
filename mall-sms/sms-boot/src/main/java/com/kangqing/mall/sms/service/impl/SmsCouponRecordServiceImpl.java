package com.kangqing.mall.sms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kangqing.mall.sms.mapper.SmsCouponRecordDao;
import com.kangqing.mall.sms.pojo.domain.SmsCouponRecord;
import com.kangqing.mall.sms.service.ISmsCouponRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 优惠券领取记录业务实现类
 * @author kangqing
 * @since 2021/3/14
 */
@Slf4j
@Service
public class SmsCouponRecordServiceImpl extends ServiceImpl<SmsCouponRecordDao, SmsCouponRecord> implements ISmsCouponRecordService {
}
