package com.kangqing.mallmbpg.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 操作日志筛选条件
 * @author kangqing
 * @since 2021.1.11 11:21
 */
@Data
public class SysLogInputDTO implements Serializable {

    /**
     * 日志详情
     */
    private String operDesc;

    /**
     * 操作人员
     */
    private String userId;

    /**
     * 操作类型
     */
    private String operType;

    /**
     * 操作模块
     */
    private String operModule;
}
