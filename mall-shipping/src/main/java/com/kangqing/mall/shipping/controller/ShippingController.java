package com.kangqing.mall.shipping.controller;

import com.kangqing.mallcommon.aop.OperLog;
import com.kangqing.mallcommon.aop.OperTypeEnum;
import com.kangqing.mallcommon.result.JsonResult;
import com.kangqing.mallmbpg.pojo.Shipping;
import com.kangqing.mallmbpg.service.ShippingService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 收货地址
 * @author kangqing
 * @since 2021/3/11 21:00
 */
@RestController
@RequiredArgsConstructor
public class ShippingController {

    private final ShippingService shippingService;

    @PostMapping("/add")
    @ApiOperation("添加收货地址")
    @OperLog(operModule = "收货地址模块", operType = OperTypeEnum.ADD, operDesc = "添加收货地址")
    public JsonResult<?> add(Shipping shipping) {

        String add = shippingService.add(shipping);
        if (add == null) {
            return JsonResult.fail("添加收货地址失败");
        }
        return JsonResult.success(add);
    }

    @PostMapping("/del")
    @ApiOperation("删除收货地址")
    @OperLog(operModule = "收货地址模块", operType = OperTypeEnum.DELETE, operDesc = "删除收货地址")
    public JsonResult<?> del(String shippingId) {
        shippingService.del(shippingId);
        return JsonResult.success();
    }

    @GetMapping("/list")
    @ApiOperation("获取当前用户的收货地址列表")
    @OperLog(operModule = "收货地址模块", operType = OperTypeEnum.QUERY, operDesc = "获取当前用户的收货地址列表")
    public JsonResult<?> list() {
        return JsonResult.success(shippingService.list());
    }

    @PostMapping("/update")
    @ApiOperation("更新收货地址")
    @OperLog(operModule = "收货地址模块", operType = OperTypeEnum.UPDATE, operDesc = "更新收货地址")
    public JsonResult<?> update(Shipping shipping) {
        shippingService.update(shipping);
        return JsonResult.success();
    }

    @GetMapping("/findById")
    @ApiOperation("查询当前账户的某个收货地址")
    @OperLog(operModule = "收货地址模块", operType = OperTypeEnum.QUERY, operDesc = "查询当前账户的某个收货地址")
    public JsonResult<?> findById(String shippingId) {
        Shipping byId = shippingService.findById(shippingId);
        if(byId == null) {
            return JsonResult.fail("只能查询自己的收货地址");
        }
        return JsonResult.success(byId);
    }
}
