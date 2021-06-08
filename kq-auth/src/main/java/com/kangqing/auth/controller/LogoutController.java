package com.kangqing.auth.controller;

import cn.hutool.json.JSONObject;
import com.kangqing.common.constant.AuthConstants;
import com.kangqing.common.result.Result;
import com.kangqing.common.web.util.RequestUtils;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;


@Api(tags = "注销")
@RestController
@RequestMapping("/oauth")
@RequiredArgsConstructor
@Slf4j
public class LogoutController {

    private final RedisTemplate<String, Object> redisTemplate;

    @DeleteMapping("/logout")
    public Result<?> logout() {
        JSONObject jsonObject = RequestUtils.getJwtPayload();
        String jti = jsonObject.getStr(AuthConstants.JWT_JTI); // JWT唯一标识
        long exp = jsonObject.getLong(AuthConstants.JWT_EXP); // JWT过期时间戳

        long currentTimeSeconds = System.currentTimeMillis() / 1000;

        if (exp < currentTimeSeconds) { // token已过期，无需加入黑名单
            return Result.success();
        }
        redisTemplate.opsForValue().set(AuthConstants.TOKEN_BLACKLIST_PREFIX + jti,
                null, (exp - currentTimeSeconds), TimeUnit.SECONDS);
        return Result.success();
    }

}
