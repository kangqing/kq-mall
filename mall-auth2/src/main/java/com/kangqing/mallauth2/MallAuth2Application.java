package com.kangqing.mallauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.kangqing.mallmbpg", "com.kangqing.mallcommon",
        "com.kangqing.mallauth2"})
public class MallAuth2Application {

    public static void main(String[] args) {
        SpringApplication.run(MallAuth2Application.class, args);
    }

}
