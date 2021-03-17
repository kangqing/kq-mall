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
 * 用户表
 * </p>
 *
 * @author yunqing
 * @since 2021-03-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="User对象", description="用户表")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "盐值")
    private String salt;

    @ApiModelProperty(value = "真实姓名")
    private String actualName;

    @ApiModelProperty(value = "性别: 0-女，1-男")
    private Integer sex;

    @ApiModelProperty(value = "email")
    private String email;

    @ApiModelProperty(value = "手机号码")
    private String phone;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "职位称呼")
    private String postName;

    @ApiModelProperty(value = "状态: 0-禁用，1-启用")
    private Integer status;

    @ApiModelProperty(value = "逻辑删除标志位，0正常，1删除")
    private Integer delCode;

    @ApiModelProperty(value = "乐观锁版本号")
    private Long version;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updateTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
