package com.kangqing.mall.oms.pojo.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 订单提交实体类
 *
 * @author kangqing
 * @since 2021/1/16
 */
@Data
public class OrderConfirmDTO {

    private Long skuId;

    private Integer count;

}
