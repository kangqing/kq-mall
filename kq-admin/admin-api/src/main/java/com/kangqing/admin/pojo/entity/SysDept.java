package com.kangqing.admin.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.kangqing.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysDept extends BaseEntity {

    @TableId(type= IdType.AUTO)
    private Long id;

    private String name;

    private Long parentId;

    private String treePath;

    private Integer sort;

    private Integer status;

    private Integer deleted;

    private String leader;

    private String mobile;

    private String email;

}
