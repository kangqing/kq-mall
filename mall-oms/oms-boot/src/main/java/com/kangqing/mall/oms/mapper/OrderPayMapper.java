package com.kangqing.mall.oms.mapper;

import com.kangqing.mall.oms.pojo.domain.OmsOrderPay;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 支付信息表
 *
 * @author kangqing
 * @since 2020-12-30 22:31:10
 */
@Mapper
public interface OrderPayMapper extends BaseMapper<OmsOrderPay> {

}
