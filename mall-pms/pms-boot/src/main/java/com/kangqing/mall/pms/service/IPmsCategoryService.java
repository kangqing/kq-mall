package com.kangqing.mall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kangqing.common.web.vo.CascaderVO;
import com.kangqing.mall.pms.pojo.domain.PmsCategory;
import com.kangqing.mall.pms.pojo.vo.CategoryVO;

import java.util.List;

public interface IPmsCategoryService extends IService<PmsCategory> {

    List<CategoryVO> listForTree(PmsCategory category);

    List<CascaderVO> listForCascader(PmsCategory category);
}
