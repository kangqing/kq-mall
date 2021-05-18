package com.kangqing.admin;

import com.kangqing.common.elasticsearch.service.ElasticSearchService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ElasticSearchTests {

    @Autowired
    private ElasticSearchService elasticSearchService;

    @Test
    public void count() {
        long count = elasticSearchService.count(null, "kq-auth-login-2021-05-18");
        log.info(String.valueOf(count));
    }
}
