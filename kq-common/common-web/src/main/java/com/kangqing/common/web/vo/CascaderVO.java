package com.kangqing.common.web.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 级联控件值对象
 *
 * @author kangqing
 * @since 2021/05/17
 */
@Data
@Accessors(chain = true)
public class CascaderVO {

    private String value;

    private String label;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<CascaderVO> children;
}
