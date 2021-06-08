package com.kangqing.admin.api;

import com.kangqing.admin.api.fallback.UserFeignFallbackClient;
import com.kangqing.admin.pojo.dto.UserDTO;
import com.kangqing.common.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @FeignClient 声明了此客户端是对kq-admin中的rest方法的调用
 */
@FeignClient(value = "kq-admin", fallback = UserFeignFallbackClient.class)
public interface UserFeignClient {

    @GetMapping("/api.admin/v1/users/username/{username}")
    Result<UserDTO> getUserByUsername(@PathVariable String username);

    @GetMapping("/api.admin/v1/users/me")
    Result<?> getCurrentUser();
}
