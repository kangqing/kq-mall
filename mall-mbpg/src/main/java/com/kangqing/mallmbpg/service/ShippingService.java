package com.kangqing.mallmbpg.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kangqing.mallmbpg.pojo.Shipping;

import java.util.List;

/**
 * <p>
 * 收货地址表 服务类
 * </p>
 *
 * @author yunqing
 * @since 2020-05-12
 */
public interface ShippingService extends IService<Shipping> {

    String add(Shipping shipping);

    void del(String shippingId);

    List<Shipping> list();

    void update(Shipping shipping);

    Shipping findById(String shippingId);
}
