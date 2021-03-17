package com.kangqing.mallmbpg.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author kangqing
 * @ClassName: SysLogOutpDTO
 * @Description: 日志输出实体类
 * @date 2018-12-07 14:59
 */
@Data
public class SysLogOutDTO implements Serializable {

    private Long id;

    /**
     * 日志类型  根据系统模块来定义日志类型
     */
    private String operModule;

    /**
     * 操作类型： 添加-1 删除-2 更新-3 查看-4
     */
    private String operType;

    /**
     * 日志描述
     */
    private String operDesc;

    /**
     * 操作人员名称
     */
    private String username;

    /**
     * 访问IP
     */
    private String logIp;

    /**
     * 请求方法
     */
    private String logMethod;

    /**
     * 响应时间
     */
    private Long spendTime;

    /**
     * 异常码
     */
    private String exceptionName;

    /**
     * 异常描述
     */
    private String exceptionMsg;

    /**
     * 创建时间
     */
    private Date createTime;

}
