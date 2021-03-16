package com.nantian.user.manager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author WangJinYi 2021/3/6
 */
@SpringBootApplication
@MapperScan("com.nantian.user.**.dao")
public class UserManagerStarter {

    public static void main(String[] args) {
        SpringApplication.run(UserManagerStarter.class, args);
    }

}
