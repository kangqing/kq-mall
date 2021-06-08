package com.kangqing.mall.sms.service;


import com.kangqing.mall.sms.pojo.vo.SmsSeckillSkuVO;

import java.util.List;

/**
 * 秒杀模块业务接口
 *
 * @author kangqing
 * @since 2021/3/5
 */
public interface ISeckillService {

    void updateSeckillSkuLatest3Days();

    /**
     * 获取当前时间秒杀活动商品列表
     * @return
     */
    List<SmsSeckillSkuVO> getCurrentSeckillSession();

}
