package com.kangqing.mall.sms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kangqing.mall.sms.mapper.SmsSeckillSkuRelationMapper;
import com.kangqing.mall.sms.pojo.domain.SmsSeckillSkuRelation;
import com.kangqing.mall.sms.service.ISmsSeckillSkuRelationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 秒杀活动场次商品关联业务实现类
 * @author kangqing
 * @since 2021/3/5
 */
@Service
@Slf4j
public class SmsSeckillSkuRelationServiceImpl extends ServiceImpl<SmsSeckillSkuRelationMapper, SmsSeckillSkuRelation> implements ISmsSeckillSkuRelationService {
    @Override
    public List<SmsSeckillSkuRelation> selectBySessionId(Long sessionId) {
        log.info("根据秒杀活动场次ID查询关联商品列表，sessionId={}",sessionId);
        QueryWrapper<SmsSeckillSkuRelation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("session_id",sessionId);
        return this.list(queryWrapper);
    }
}
