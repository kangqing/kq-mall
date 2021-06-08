package com.kangqing.mall.sms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 异步+定时 配置
 *
 * @author kangqing
 * @since 2021/3/5
 */
@EnableScheduling
@EnableAsync
@Configuration
public class ScheduledConfig {
}
