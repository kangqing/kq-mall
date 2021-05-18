package com.kangqing.admin.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.kangqing.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class SysDictItem extends BaseEntity {

    @TableId(type= IdType.AUTO)
    private Long id;

    private String name;

    private String value;

    private String dictCode;

    private String sort;

    private Integer status;

    private Integer defaulted;

    private String remark;

}
