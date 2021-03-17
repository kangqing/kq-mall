package com.kangqing.mallmbpg.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author yunqing
 * @since 2021-03-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Role对象", description="角色表")
public class Role extends Model<Role> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "角色id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "父节点id")
    private Long parentId;

    @ApiModelProperty(value = "所有父级节点和当前节点")
    private String roleIndex;

    @ApiModelProperty(value = "角色名称")
    private String name;

    @ApiModelProperty(value = "角色名称描述")
    private String description;

    @ApiModelProperty(value = "角色排序")
    private Integer seq;

    @ApiModelProperty(value = "乐观锁版本号")
    private Long version;

    @ApiModelProperty(value = "逻辑删除标识符， 是否删除0否1是")
    private Integer delCode;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updateTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
