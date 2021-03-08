package com.nantian.user.service;

import com.nantian.user.domain.SampleUser;
import com.nantian.user.domain.User;

/**
 * @author WangJinYi 2021/3/6
 */
public interface IUserService {

    SampleUser getSampleUserById(String id);

    void registerUser(User user);
}
