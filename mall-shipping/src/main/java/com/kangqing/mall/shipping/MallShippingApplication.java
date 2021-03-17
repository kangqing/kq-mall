package com.kangqing.mall.shipping;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableDubbo
@SpringBootApplication
@ComponentScan(basePackages = "com.kangqing")
@MapperScan("com.kangqing.mallmbpg.mapper")
public class MallShippingApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallShippingApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello, spring cloud alibaba";
    }

}
