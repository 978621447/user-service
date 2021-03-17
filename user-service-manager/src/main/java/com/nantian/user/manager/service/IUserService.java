package com.nantian.user.manager.service;

import com.nantian.user.api.domain.SampleUser;
import com.nantian.user.api.domain.User;
import com.nantian.user.manager.domain.UserInfoQO;

import java.util.Map;

/**
 * @author WangJinYi 2021/3/6
 */
public interface IUserService {

    SampleUser getSampleUserById(String id);

    void registerUser(User user);

    String login(User loginUser);

    Map<String, Object> list(UserInfoQO userInfoQO);
}
