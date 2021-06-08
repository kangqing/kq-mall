package com.kangqing.mall.pms.pojo.dto;

import lombok.Data;

/**
 * @author kangqing
 * @since 2021/1/13
 */
@Data
public class SkuDTO {

    private Long id;
    private String code;
    private String name;
    private String pic;
    private Long price;

    private Integer stock;
    private String spuName;

}
