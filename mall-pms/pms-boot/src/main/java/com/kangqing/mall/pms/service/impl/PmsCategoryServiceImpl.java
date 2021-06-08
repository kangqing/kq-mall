package com.kangqing.mall.pms.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kangqing.common.web.vo.CascaderVO;
import com.kangqing.mall.pms.mapper.PmsCategoryMapper;
import com.kangqing.mall.pms.pojo.domain.PmsCategory;
import com.kangqing.mall.pms.pojo.vo.CategoryVO;
import com.kangqing.mall.pms.service.IPmsCategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PmsCategoryServiceImpl extends ServiceImpl<PmsCategoryMapper, PmsCategory> implements IPmsCategoryService {

    @Override
    public List<CategoryVO> listForTree(PmsCategory category) {
        List<PmsCategory> categoryList = this.list(
                new LambdaQueryWrapper<PmsCategory>()
                        .eq(category.getStatus() != null, PmsCategory::getStatus, category.getStatus())
                        .orderByAsc(PmsCategory::getSort)
        );

        Long parentId = 0l;

        if (category.getParentId() != null) {
            parentId = category.getParentId();
        }

        List<CategoryVO> list = recursionForTreeList(parentId, categoryList);
        return list;
    }

    private static List<CategoryVO> recursionForTreeList(Long parentId, List<PmsCategory> categoryList) {
        List<CategoryVO> list = new ArrayList<>();
        Optional.ofNullable(categoryList)
                .ifPresent(categories ->
                        categories.stream().filter(category ->
                                category.getParentId().equals(parentId))
                                .forEach(category -> {
                                    CategoryVO categoryVO = new CategoryVO();
                                    BeanUtil.copyProperties(category, categoryVO);
                                    List<CategoryVO> children = recursionForTreeList(category.getId(), categoryList);
                                    categoryVO.setChildren(children);
                                    list.add(categoryVO);
                                }));
        return list;
    }


    @Override
    public List<CascaderVO> listForCascader(PmsCategory category) {
        List<PmsCategory> categoryList = this.list(
                new LambdaQueryWrapper<PmsCategory>()
                        .eq(category.getStatus() != null, PmsCategory::getStatus, category.getStatus())
        );
        List<CascaderVO> list = recursionForCascaderList(0l, categoryList);
        return list;
    }

    private List<CascaderVO> recursionForCascaderList(Long parentId, List<PmsCategory> categoryList) {
        List<CascaderVO> list = new ArrayList<>();
        Optional.ofNullable(categoryList)
                .ifPresent(categories ->
                        categories.stream().filter(category ->
                                category.getParentId().equals(parentId))
                                .forEach(category -> {
                                    CascaderVO categoryVO = new CascaderVO()
                                            .setLabel(category.getName())
                                            .setValue(category.getId().toString());
                                    BeanUtil.copyProperties(category, categoryVO);
                                    List<CascaderVO> children = recursionForCascaderList(category.getId(), categoryList);
                                    categoryVO.setChildren(children);
                                    list.add(categoryVO);
                                })
                );
        return list;
    }
}
