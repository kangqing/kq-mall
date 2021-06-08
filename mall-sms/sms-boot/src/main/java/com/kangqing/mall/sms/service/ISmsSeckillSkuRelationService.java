package com.kangqing.mall.sms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kangqing.mall.sms.pojo.domain.SmsSeckillSkuRelation;

import java.util.List;

/**
 * 秒杀活动场次商品关联业务接口
 *
 * @author kangqing
 * @since 2021/3/5
 */
public interface ISmsSeckillSkuRelationService extends IService<SmsSeckillSkuRelation> {

    /**
     * 根据秒杀活动ID获取关联商品
     * @param sessionId 秒杀活动场次ID
     * @return 关联商品列表
     */
    List<SmsSeckillSkuRelation> selectBySessionId(Long sessionId);
}
