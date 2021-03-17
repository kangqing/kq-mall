package com.kangqing.mallmbpg.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kangqing.mallmbpg.pojo.Order;
import com.kangqing.mallmbpg.pojo.Shipping;

import java.util.List;

/**
 * @author kangqing
 * @since 2021/3/12 07:56
 */
public interface OrderService extends IService<Order> {

    List<Shipping> getShipping();
}
