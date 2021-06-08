package com.kangqing.mall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kangqing.mall.pms.pojo.domain.PmsSpec;

import java.util.List;

public interface IPmsSpecService extends IService<PmsSpec> {

    List<PmsSpec> listBySpuId(Long spuId);

}
