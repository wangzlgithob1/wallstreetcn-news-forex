package com.crawler.wallstreetcnnewsforex;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@MapperScan("com.crawler.wallstreetcnnewsforex.dao")
@SpringBootApplication
@RestController
public class WallstreetcnNewsForexApplication {

    public static void main(String[] args) {
        SpringApplication.run(WallstreetcnNewsForexApplication.class, args);
    }

}
