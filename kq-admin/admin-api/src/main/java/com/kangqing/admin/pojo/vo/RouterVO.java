package com.kangqing.admin.pojo.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author kangqing
 * @since 2020-11-06
 */
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RouterVO {

    private String path;

    private String component;

    private String redirect;

    private boolean alwaysShow;

    private String name;

    private Boolean hidden;

    private Meta meta;

    @Data
    @AllArgsConstructor
    public static class Meta {
        private String title;
        private String icon;
        private List<Integer> roles;
    }
    private List<RouterVO> children;

}