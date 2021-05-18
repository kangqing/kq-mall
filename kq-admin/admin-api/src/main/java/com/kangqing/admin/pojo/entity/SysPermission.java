package com.kangqing.admin.pojo.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.kangqing.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class SysPermission extends BaseEntity {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private String perm;
    private Long moduleId;
    private String method;
    private Integer type;

    // 拥有资源权限角色ID集合
    @TableField(exist = false)
    private List<Long> roleIds;
}
