package com.kangqing.mall.pms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kangqing.mall.pms.pojo.bo.admin.ProductBO;
import com.kangqing.mall.pms.pojo.domain.PmsSpu;

import java.util.List;


public interface IPmsSpuService extends IService<PmsSpu> {

    IPage<PmsSpu> list(Page<PmsSpu> page, PmsSpu spu);

    boolean add(ProductBO productBO);

    ProductBO getBySpuId(Long id);

    boolean removeBySpuIds(List<Long> spuIds);

    boolean updateById(ProductBO productBO);

    com.kangqing.mall.pms.pojo.bo.app.ProductBO getProductByIdForApp(Long id);
}
