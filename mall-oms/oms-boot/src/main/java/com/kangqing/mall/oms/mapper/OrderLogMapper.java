package com.kangqing.mall.oms.mapper;

import com.kangqing.mall.oms.pojo.domain.OmsOrderLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单操作历史记录
 *
 * @author kangqing
 * @since 2020-12-30 22:31:10
 */
@Mapper
public interface OrderLogMapper extends BaseMapper<OmsOrderLog> {

}
