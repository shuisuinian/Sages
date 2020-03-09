package com.sages.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @author wanyifan
 * @date 2019/12/19 14:51
 */
@SpringBootApplication
@MapperScan("com.sages.app.mapper")
public class SagesApplication {
    public static void main(String[] args) {
        SpringApplication.run(SagesApplication.class);
    }
}
