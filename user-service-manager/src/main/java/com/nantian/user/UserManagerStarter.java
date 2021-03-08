package com.nantian.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

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
