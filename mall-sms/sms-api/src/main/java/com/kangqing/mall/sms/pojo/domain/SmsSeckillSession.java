package com.kangqing.mall.sms.pojo.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * sms_seckill_session
 * @author kangqing
 */
@Data
public class SmsSeckillSession implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 场次名称
     */
    private String name;

    /**
     * 每日开始时间
     */
    private Date startTime;

    /**
     * 每日结束时间
     */
    private Date endTime;

    /**
     * 启用状态 1-开启  0-关闭
     */
    private Boolean status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    @TableField(exist = false)
    private List<SmsSeckillSkuRelation> relations;

    private static final long serialVersionUID = 1L;
}