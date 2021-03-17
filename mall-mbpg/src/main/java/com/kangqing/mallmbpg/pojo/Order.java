package com.kangqing.mallmbpg.pojo;

import java.math.BigDecimal;
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
 * @since 2021-03-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("mmall_order")
@ApiModel(value="Order对象", description="")
public class Order extends Model<Order> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "订单id")
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    @ApiModelProperty(value = "订单号")
    private String orderNo;

    @ApiModelProperty(value = "用户id")
    private String userId;

    private String shippingId;

    @ApiModelProperty(value = "实际付款金额,单位是元,保留两位小数")
    private BigDecimal payment;

    @ApiModelProperty(value = "支付类型,1-在线支付")
    private Integer paymentType;

    @ApiModelProperty(value = "运费,单位是元")
    private Integer postage;

    @ApiModelProperty(value = "订单状态:0-已取消-10-未付款，20-已付款，40-已发货，50-交易成功，60-交易关闭")
    private Integer status;

    @ApiModelProperty(value = "支付时间")
    private LocalDateTime paymentTime;

    @ApiModelProperty(value = "发货时间")
    private LocalDateTime sendTime;

    @ApiModelProperty(value = "交易完成时间")
    private LocalDateTime endTime;

    @ApiModelProperty(value = "交易关闭时间")
    private LocalDateTime closeTime;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
