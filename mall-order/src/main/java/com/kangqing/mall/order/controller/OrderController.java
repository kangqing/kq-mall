package com.kangqing.mall.order.controller;

import com.kangqing.mallmbpg.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单
 * @author kangqing
 * @since 2021/3/12 07:55
 */
@RestController
public class OrderController {

    private OrderService orderService;

    @GetMapping("/getShipping")
    public Object getShipping() {
        return orderService.getShipping();
    }
}
