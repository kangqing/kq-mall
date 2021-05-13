package com.kangqing.common.redis.redisson;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Redisson 连接配置
 * @author kangqing
 * @since 2021/2/22
 */
@Component
@ConfigurationProperties(prefix = "redisson")
@Data
public class RedissonProperties {

    private String serverAddress;

    private String port;

    private String password;

}
