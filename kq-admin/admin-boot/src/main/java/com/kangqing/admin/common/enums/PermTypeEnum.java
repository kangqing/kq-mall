package com.kangqing.admin.common.enums;

import lombok.Getter;
import lombok.Setter;

/**
 * 权限类型
 *
 * @author kangqing
 * @since 2021-02-05 10:10
 */

public enum PermTypeEnum {

    ROUTE(1, "路由权限"),
    BUTTON(2, "按钮权限");

    @Getter
    @Setter
    private Integer value;

    PermTypeEnum(Integer value, String desc) {
        this.value = value;
    }
}