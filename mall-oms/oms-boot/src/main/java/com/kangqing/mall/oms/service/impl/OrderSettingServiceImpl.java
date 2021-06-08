package com.kangqing.mall.oms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kangqing.mall.oms.mapper.OrderSettingMapper;
import com.kangqing.mall.oms.pojo.domain.OmsOrderSetting;
import com.kangqing.mall.oms.service.IOrderSettingService;
import org.springframework.stereotype.Service;


@Service
public class OrderSettingServiceImpl extends ServiceImpl<OrderSettingMapper, OmsOrderSetting> implements IOrderSettingService {

}
