package com.kangqing.mall.sms.service;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kangqing.mall.sms.pojo.domain.SmsSeckillSession;

import java.util.List;

/**
 * 秒杀活动场次业务接口
 *
 * @author kangqing
 * @since 2021/3/5
 */
public interface ISmsSeckillSessionService extends IService<SmsSeckillSession> {

    /**
     * 根据起始时间和结束时间查询秒杀活动列表
     * @param startTime 起始时间
     * @param endTime 结束时间
     * @return 秒杀活动列表
     */
    List<SmsSeckillSession> selectByTime(DateTime startTime, DateTime endTime);
}
