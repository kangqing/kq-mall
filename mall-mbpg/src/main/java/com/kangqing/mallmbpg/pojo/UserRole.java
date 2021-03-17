package com.kangqing.mallmbpg.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author yunqing
 * @since 2021-03-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="UserRole对象", description="")
public class UserRole extends Model<UserRole> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "角色id")
    private Long roleId;

    @ApiModelProperty(value = "用户id")
    private Long userId;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
