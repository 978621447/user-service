package com.nantian.user.manager.service.impl;


import com.nantian.user.api.domain.SampleUser;
import com.nantian.user.api.domain.LoginInfo;
import com.nantian.user.client.service.IUserService;
import com.nantian.user.api.util.JSONUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author WangJinYi 2021/3/8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    private static Logger logger = LoggerFactory.getLogger(UserServiceImplTest.class.getName());

    @Autowired
    private IUserService userService;

    @Test
    public void searchById() {
        String id = "1";
        SampleUser sampleUser = userService.searchById(id);
        logger.info(JSONUtils.objToJson(sampleUser));
    }

    @Test
    public void getLoginInfo() {
        String token = "e32fba83a6584b6c990cea548695ab66admin20210309162245";
        LoginInfo loginInfo = userService.getLoginInfo(token);
        logger.info(JSONUtils.objToJson(loginInfo));
    }

}