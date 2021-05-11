package com.kangqing.common.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 基础分页对象
 *
 * @author kangqing
 * @since 2021/5/11 22:53
 */
@Data
public class BasePageQuery {

    @ApiModelProperty(value = "当前页", example = "1")
    private int pageNum = 1;

    @ApiModelProperty(value = "每页记录数", example = "10")
    private int pageSize = 10;
}