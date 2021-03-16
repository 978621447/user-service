package com.nantian.user.manager.service;

import com.nantian.user.api.domain.SampleUser;
import com.nantian.user.api.domain.User;

/**
 * @author WangJinYi 2021/3/6
 */
public interface IUserService {

    SampleUser getSampleUserById(String id);

    void registerUser(User user);

    String login(User loginUser);
}
