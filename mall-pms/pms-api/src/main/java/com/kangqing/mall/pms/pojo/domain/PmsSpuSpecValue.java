package com.kangqing.mall.pms.pojo.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.kangqing.common.base.BaseEntity;
import lombok.Data;

/**
 * @author kangqing
 * @since 2020-11-06
 */
@Data
public class PmsSpuSpecValue extends BaseEntity {

    @TableId(type = IdType.INPUT)
    private Long id;
    private Long spuId;
    private Long specId;
    private String value;
}
