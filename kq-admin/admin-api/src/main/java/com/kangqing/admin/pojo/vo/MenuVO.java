package com.kangqing.admin.pojo.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.kangqing.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class MenuVO extends BaseEntity {

    private Long id;

    private Long parentId;

    private String name;

    private String icon;

    private String path;

    private String component;

    private Integer sort;

    private Integer visible;

    private String redirect;

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private List<MenuVO> children;

}
