package com.kangqing.mall.oms.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author kangqing
 * @since 2021/3/13 11:59
 */
@AllArgsConstructor
public enum OrderStatusEnum  {

    PENDING_PAYMENT(101,"待支付"),
    USER_CANCEL(102,"用户取消"),
    AUTO_CANCEL(103,"系统自动取消"),

    PAID(201,"已支付"),
    APPLY_REFUND(202,"申请退款"),
    REFUNDED(203,"已退款"),

    PENDING_SHIPPED(301,"待发货"),

    DELIVERED(401,"已发货"),

    USER_RECEIVE(501,"用户收货"),
    AUTO_RECEIVE(502,"系统自动收货"),

    FINISHED(901,"已完成")
    ;

    @Getter
    private Integer code;

    @Getter
    private String text;


    public static OrderStatusEnum getValue(Integer code){
        for (OrderStatusEnum value : values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }

}
