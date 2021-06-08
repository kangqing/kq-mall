package com.kangqing.mall.sms.controller.app;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.kangqing.common.result.Result;
import com.kangqing.mall.sms.pojo.SmsAdvert;
import com.kangqing.mall.sms.service.ISmsAdvertService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "【移动端】营销广告")
@RestController
@RequestMapping("/api.app/v1/adverts")
@Slf4j
@RequiredArgsConstructor
public class AdvertController {

    private final ISmsAdvertService iSmsAdvertService;

    @ApiOperation(value = "列表分页")
    @GetMapping
    public Result<?> list() {
        LambdaQueryWrapper<SmsAdvert> queryWrapper = new LambdaQueryWrapper<SmsAdvert>()
                .orderByAsc(SmsAdvert::getSort);
        List<SmsAdvert> data = iSmsAdvertService.list(queryWrapper);
        return Result.success(data);
    }
}
