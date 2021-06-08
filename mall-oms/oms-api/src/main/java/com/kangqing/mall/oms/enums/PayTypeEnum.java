package com.kangqing.mall.oms.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 订单来源类型枚举
 * @author kangqing
 * @since 2021/1/16
 */
@AllArgsConstructor
public enum PayTypeEnum  {

    WEIXIN(1,"微信支付"),
    ALIPAY(2,"支付宝支付"),
    BALANCE(3,"会员余额支付")
    ;
    @Getter
    private Integer code;

    @Getter
    private String text;

    public static PayTypeEnum getByCode(Integer code){
        for (PayTypeEnum value : values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }
}
