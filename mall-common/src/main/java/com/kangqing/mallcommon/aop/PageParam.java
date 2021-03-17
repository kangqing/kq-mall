package com.kangqing.mallcommon.aop;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

/**
 * 分页信息
 * @author kangqing
 * @since 2021/01/01 20:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageParam {

    /**
     * 第几页
     */
    @Min(value = 1, message = "页码不能小于1")
    private Integer page;

    /**
     * 页容量
     */
    @Min(value = 1, message = "页容量不能小于1")
    private Integer limit;

    /**
     * 排序字段，默认使用ID来排序
     */
    private String sortField = "id";

    /**
     * 排序方式，默认升序
     */
    private String sortOrder = "DESC";


    /**
     * 构建分页信息, 主要用于构建 mybatis plus分页条件
     * @param pageDTO 分页信息
     * @return 返回IPage分页信息或者null
     */
    public static <T> IPage<T> buildPageCondition(PageParam pageDTO) {
        IPage<T> page = new Page<>();
        if(pageDTO.getLimit() != null && pageDTO.getPage() != null) {
            page.setCurrent(pageDTO.getPage()).setSize(pageDTO.getLimit());
        } else {
            page.setCurrent(-1).setSize(-1);
        }
        return page;
    }

}
