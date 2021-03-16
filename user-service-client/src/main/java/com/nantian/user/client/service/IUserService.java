package com.nantian.user.client.service;

import com.nantian.user.api.domain.LoginInfo;
import com.nantian.user.api.domain.SampleUser;

/**
 * @author WangJinYi 2021/3/8
 */
public interface IUserService {

    SampleUser searchById(String id);

    LoginInfo getLoginInfo(String token);

}
