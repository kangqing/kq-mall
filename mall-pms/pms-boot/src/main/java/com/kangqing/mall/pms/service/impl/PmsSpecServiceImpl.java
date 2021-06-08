package com.kangqing.mall.pms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kangqing.mall.pms.pojo.domain.PmsSpec;
import com.kangqing.mall.pms.service.IPmsSpecService;
import com.kangqing.mall.pms.mapper.PmsSpecMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kangqing
 * @since 2020-11-06
 */
@Service
public class PmsSpecServiceImpl extends ServiceImpl<PmsSpecMapper, PmsSpec> implements IPmsSpecService {

    @Override
    public List<PmsSpec> listBySpuId(Long spuId) {
        List<PmsSpec> list = this.baseMapper.listBySpuId(spuId);
        return list;
    }
}
