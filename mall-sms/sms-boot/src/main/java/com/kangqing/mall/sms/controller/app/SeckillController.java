package com.kangqing.mall.sms.controller.app;

import com.kangqing.common.result.Result;
import com.kangqing.mall.sms.pojo.vo.SmsSeckillSkuVO;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 秒杀活动管理
 * @author kangqing
 * @since 2021/3/7
 */
@Api(tags = "【移动端】秒杀活动管理")
@RestController
@RequestMapping("/api.app/v1/seckill")
@Slf4j
public class SeckillController {

    @Autowired
    private com.kangqing.mall.sms.service.ISeckillService ISeckillService;

    @GetMapping
    public Result<?> getCurrentSeckillSession() {
        List<SmsSeckillSkuVO> currentSeckills = ISeckillService.getCurrentSeckillSession();
        return Result.success();
    }
}
