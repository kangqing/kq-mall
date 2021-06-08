package com.kangqing.mall.oms.pojo.vo;

import com.kangqing.common.base.BaseVO;
import lombok.Data;

/**
 * 订单创建响应结果VO
 * @author kangqing
 * @since 2021/1/21
 */
@Data
public class OrderSubmitVO extends BaseVO {
    /**
     * 订单ID
     */
    private Long orderId;

    /**
     * 订单编号，进入支付页面显示
     */
    private String orderSn;

}
