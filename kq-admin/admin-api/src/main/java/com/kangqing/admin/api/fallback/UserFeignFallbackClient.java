package com.kangqing.admin.api.fallback;

import com.kangqing.admin.api.UserFeignClient;
import com.kangqing.admin.pojo.dto.UserDTO;
import com.kangqing.common.result.Result;
import com.kangqing.common.result.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author kangqing
 * @since 2021/5/18
 */
@Component
@Slf4j
public class UserFeignFallbackClient implements UserFeignClient {

    @Override
    public Result<UserDTO> getUserByUsername(String username) {
        log.error("feign远程调用系统用户服务异常后的降级方法");
        return Result.failed(ResultCode.DEGRADATION);
    }
}
