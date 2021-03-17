package com.kangqing.mall.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kangqing.mallmbpg.mapper.OrderMapper;
import com.kangqing.mallmbpg.pojo.Order;
import com.kangqing.mallmbpg.pojo.Shipping;
import com.kangqing.mallmbpg.service.OrderService;
import com.kangqing.mallmbpg.service.ShippingService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yunqing
 * @since 2021-03-12
 */
@Service
//设置3秒超时，重试次数3次
@DubboService(timeout = 3000, retries = 3)
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    /**
     * 消费 shippingService 服务
     */
    @DubboReference
    private ShippingService shippingService;

    @Override
    public List<Shipping> getShipping() {
        return shippingService.list();
    }
}
