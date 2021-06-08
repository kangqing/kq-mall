package com.kangqing.mall.pms.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 库存数量
 * @author kangqing
 * @since 2021-03-07 15:14
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SkuLockDTO {

    private Long skuId;

    private Integer count;

    private String orderToken;

    private Boolean locked;

}
