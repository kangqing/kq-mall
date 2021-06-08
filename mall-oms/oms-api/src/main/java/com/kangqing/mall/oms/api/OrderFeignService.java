package com.kangqing.mall.oms.api;

import com.kangqing.common.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author kangqing
 * @since 2021/3/13 11:59
 */
@FeignClient("mall-oms")
public interface OrderFeignService {

    /**
     * 修改订单状态
     */
    @PutMapping("/api.admin/v1/orders/{id}")
    Result updateOrderStatus(@PathVariable Long id, @RequestParam Integer status);

}
