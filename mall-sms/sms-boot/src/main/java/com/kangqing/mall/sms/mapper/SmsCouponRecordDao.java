package com.kangqing.mall.sms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kangqing.mall.sms.pojo.domain.SmsCouponRecord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SmsCouponRecordDao extends BaseMapper<SmsCouponRecord> {
    int deleteByPrimaryKey(Long id);

    int insertSelective(SmsCouponRecord record);

    SmsCouponRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SmsCouponRecord record);

    int updateByPrimaryKey(SmsCouponRecord record);
}