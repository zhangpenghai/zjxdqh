package com.zjxdqh.happchargeserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Yorking
 * @date 2019/05/05
 */

@SpringBootApplication
@ComponentScan(basePackages = {"com.zjxdqh.happchargeserver", "com.zjxdqh.tools.redis"})
public class HappyChargeServiceApplication {


    public static void main(String[] args) {
        SpringApplication.run(HappyChargeServiceApplication.class, args);
    }
}
