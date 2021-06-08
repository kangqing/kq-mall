package com.kangqing.mall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kangqing.mall.pms.pojo.bo.app.ProductBO;
import com.kangqing.mall.pms.pojo.domain.PmsSpu;


public interface IProductService extends IService<PmsSpu> {

    ProductBO getProductById(Long id);
}
