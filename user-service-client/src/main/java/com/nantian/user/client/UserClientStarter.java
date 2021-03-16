package com.nantian.user.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author WangJinYi 2021/3/8
 */
@SpringBootApplication(scanBasePackages = "com.nantian.user")
public class UserClientStarter {

    public static void main(String[] args) {
        SpringApplication.run(UserClientStarter.class, args);
    }

}
