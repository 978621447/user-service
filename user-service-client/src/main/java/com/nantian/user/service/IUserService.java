package com.nantian.user.service;

import com.nantian.user.domain.SampleUser;

/**
 * @author WangJinYi 2021/3/8
 */
public interface IUserService {

    SampleUser searchById(String id);

    String login(String userName, String password);

}
