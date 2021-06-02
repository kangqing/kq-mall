package com.kangqing.admin.service.impl;


import com.kangqing.admin.common.util.JWTUtils;
import com.kangqing.admin.service.ITokenService;
import com.kangqing.common.constant.AuthConstants;
import com.kangqing.common.domain.JWTPayload;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author kangqing
 * @since 2021-03-10
 */
@Service
@RequiredArgsConstructor
public class TokenServiceImpl implements ITokenService {


    StringRedisTemplate redisTemplate;

    @Override
    @SneakyThrows
    public boolean invalidateToken(String token) {

        JWTPayload payload = JWTUtils.getJWTPayload(token);

        // 计算是否过期
        long currentTimeSeconds = System.currentTimeMillis() / 1000;
        Long exp = payload.getExp();
        if (exp < currentTimeSeconds) { // token已过期，无需加入黑名单
            return true;
        }
        // 添加至黑名单使其失效
        redisTemplate.opsForValue().set(AuthConstants.TOKEN_BLACKLIST_PREFIX + payload.getJti(), null, (exp - currentTimeSeconds), TimeUnit.SECONDS);
        return true;
    }

    @Override
    public int getTokenStatus(String token) {
        JWTPayload payload = JWTUtils.getJWTPayload(token);

        // 计算是否过期
        long currentTimeSeconds = System.currentTimeMillis() / 1000;
        Long exp = payload.getExp();
        if (exp < currentTimeSeconds) { // token已过期  返回失效
            return 0;
        }

        // 判断是否存在黑名单
        String jti = payload.getJti();
        Boolean isExists = redisTemplate.hasKey(AuthConstants.TOKEN_BLACKLIST_PREFIX + jti);
        if (isExists) { // 被添加到黑名单  返回失效
            return 0;
        }
        return 1;
    }

}
