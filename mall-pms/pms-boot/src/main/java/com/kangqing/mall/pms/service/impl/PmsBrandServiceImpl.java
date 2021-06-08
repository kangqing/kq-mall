package com.kangqing.mall.pms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kangqing.mall.pms.mapper.PmsBrandMapper;
import com.kangqing.mall.pms.pojo.domain.PmsBrand;
import com.kangqing.mall.pms.service.IPmsBrandService;
import org.springframework.stereotype.Service;

@Service
public class PmsBrandServiceImpl extends ServiceImpl<PmsBrandMapper, PmsBrand> implements IPmsBrandService {
}
