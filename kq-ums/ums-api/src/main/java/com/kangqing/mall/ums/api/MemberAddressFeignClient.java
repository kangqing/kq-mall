package com.kangqing.mall.ums.api;


import com.kangqing.common.result.Result;
import com.kangqing.mall.ums.pojo.domain.UmsAddress;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 获取会员地址信息
 *
 * @author kangqing
 * @since 2021/05/19
 */
@FeignClient(name = "mall-ums",contextId = "address")
public interface MemberAddressFeignClient {

    /**
     * 获取地址详情
     */
    @GetMapping("/api.app/v1/addresses/{id}")
    Result<UmsAddress> getById(@PathVariable("id") Long id);


    @GetMapping("/api.app/v1/addresses")
    Result<List<UmsAddress>> list(@RequestParam Long memberId);

}


