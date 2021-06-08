package com.kangqing.mall.sms.service.impl;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kangqing.mall.sms.mapper.SmsSeckillSessionMapper;
import com.kangqing.mall.sms.pojo.domain.SmsSeckillSession;
import com.kangqing.mall.sms.service.ISmsSeckillSessionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 秒杀活动场次管理业务实现类
 * @author kangqing
 * @since 2021/3/5
 */
@Service
@Slf4j
public class SmsSeckillSessionServiceImpl extends ServiceImpl<SmsSeckillSessionMapper, SmsSeckillSession> implements ISmsSeckillSessionService {
    @Override
    public List<SmsSeckillSession> selectByTime(DateTime startTime, DateTime endTime) {
        log.info("根据起始时间和结束时间查询秒杀活动列表, startTime={}, endTime={}", startTime, endTime);
        QueryWrapper<SmsSeckillSession> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status", 1).between("start_time", startTime, endTime).orderByAsc("start_time");

        return this.list(queryWrapper);
    }
}
