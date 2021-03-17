package com.kangqing.mallcommon.aop;


/**
 * 操作类型枚举类
 * @author kangqing
 * @since 2021/1/10 20:46
 */
public enum OperTypeEnum {

    DEFAULT(""),
    /**
     * 添加
     */
    ADD("ADD"),
    /**
     * 删除
     */
    DELETE("DELETE"),
    /**
     * 修改
     */
    UPDATE("UPDATE"),
    /**
     * 查询
     */
    QUERY("QUERY"),
    /**
     * 导出
     */
    EXPORT("EXPORT"),
    /**
     * 登录
     */
    LOGIN("LOGIN"),
    /**
     * 上传
     */
    UPLOAD("UPLOAD");

    OperTypeEnum(String type) {
        this.type = type;
    }

    private final String type;

    public String getType() {
        return this.type;
    }
}
