package com.kangqing.mall.oms.service;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;

/**
 * Order RabbitMQ 业务类
 * @author kangqing
 * @since 2021/2/4
 */
public interface OrderRabbitService {

    /**
     * 订单超时释放
     *
     * @param orderSn
     * @param message
     * @param channel
     */
    void releaseOrder(String orderSn, Message message, Channel channel);
}
