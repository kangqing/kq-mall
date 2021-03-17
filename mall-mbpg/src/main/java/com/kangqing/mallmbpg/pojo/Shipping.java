package com.kangqing.mallmbpg.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author yunqing
 * @since 2021-03-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("mmall_shipping")
@ApiModel(value="Shipping对象", description="")
public class Shipping extends Model<Shipping> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "收货姓名")
    private String receiverName;

    @ApiModelProperty(value = "收货固定电话")
    private String receiverPhone;

    @ApiModelProperty(value = "收货移动电话")
    private String receiverMobile;

    @ApiModelProperty(value = "省份")
    private String receiverProvince;

    @ApiModelProperty(value = "城市")
    private String receiverCity;

    @ApiModelProperty(value = "区/县")
    private String receiverDistrict;

    @ApiModelProperty(value = "详细地址")
    private String receiverAddress;

    @ApiModelProperty(value = "邮编")
    private String receiverZip;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
