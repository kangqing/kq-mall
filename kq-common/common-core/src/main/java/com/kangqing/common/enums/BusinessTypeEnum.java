package com.kangqing.common.enums;

import lombok.Getter;
import lombok.Setter;

/**
 * 业务类型枚举
 *
 * @author kangqing
 * @since 2021/5/12 13:05
 */
public enum BusinessTypeEnum {

    USER("user", 100),
    MEMBER("member", 200),
    ORDER("order", 300);

    @Getter
    @Setter
    private String code;

    @Getter
    @Setter
    private Integer value;

    BusinessTypeEnum(String code, Integer value) {
        this.code = code;
        this.value = value;
    }

    public static BusinessTypeEnum getValue(String code) {
        for (BusinessTypeEnum value : values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }
}
