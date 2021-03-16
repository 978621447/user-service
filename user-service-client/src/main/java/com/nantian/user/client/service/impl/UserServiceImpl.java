package com.nantian.user.client.service.impl;

import com.nantian.user.client.service.IUserService;
import com.nantian.user.api.domain.LoginInfo;
import com.nantian.user.api.domain.SampleUser;
import com.nantian.user.api.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author WangJinYi 2021/3/8
 */
@Service("clientUserService")
public class UserServiceImpl implements IUserService {

    @Value("${user-manager.ip:127.0.0.1}")
    private String ip;
    @Value("${user-manager.port:18080}")
    private String port;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public SampleUser searchById(String id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://" + ip + ":" + port + "/manager/user/searchById?id=" + id;
        SampleUser sampleUser = restTemplate
                .getForEntity(url, SampleUser.class)
                .getBody();
        return sampleUser;
    }

    @Override
    public LoginInfo getLoginInfo(String token) {
        return (LoginInfo) redisUtil.get(token);
    }

}
