package com.nantian.user.service.impl;

import com.nantian.user.dao.SampleUserMapper;
import com.nantian.user.dao.UserMapper;
import com.nantian.user.domain.LoginInfo;
import com.nantian.user.domain.SampleUser;
import com.nantian.user.domain.User;
import com.nantian.user.exception.BusinessException;
import com.nantian.user.service.IUserService;
import com.nantian.user.util.DateUtils;
import com.nantian.user.util.MD5Util;
import com.nantian.user.util.RedisUtil;
import com.nantian.user.util.UuidUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * @author WangJinYi 2021/3/6
 */
@Service
public class UserServiceImpl implements IUserService {

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private SampleUserMapper sampleUserMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public SampleUser getSampleUserById(String id) {
        return sampleUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public void registerUser(User user) {
        checkExists(user);
        String originalPwd = user.getVluUserPwd();
        String pwdSalt = UuidUtil.newUuid();
        user.setIdUser(UuidUtil.newUuid());
        user.setVluUserPwd(encryptPwd(originalPwd, pwdSalt));
        user.setPwdSalt(pwdSalt);
        user.setCodUserState("0");
        userMapper.insertSelective(user);
    }

    @Override
    public String login(User loginUser) {
        User user = userMapper.selectByUserName(loginUser.getNamUser());
        validLogin(loginUser, user);
        String token = generateToken(user);
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setUser(user);
        redisUtil.set(token, loginInfo, 7 * 24 * 60 * 60);
        return token;
    }

    private void validLogin(User loginUser, User user) {
        if (user == null) {
            throw new BusinessException("用户不存在！");
        } else if (!truePwd(loginUser.getVluUserPwd(), user.getVluUserPwd(), user.getPwdSalt())) {
            throw new BusinessException("用户名/密码错误！");
        } else if (!"0".equals(user.getCodUserState())) {
            throw new BusinessException("用户已被冻结！");
        }
    }

    private String generateToken(User user) {
        return UuidUtil.newUuid() + user.getNamUser() + DateUtils.DATE_FORMAT_14.format(LocalDateTime.now());
    }

    private boolean truePwd(String loginPwd, String encryptPwd, String pwdSalt) {
        String encryptLoginPwd = encryptPwd(loginPwd, pwdSalt);
        return encryptLoginPwd.equals(encryptPwd);
    }

    private void checkExists(User user) {
        String userName = user.getNamUser();
        User existsUser = userMapper.selectByUserName(userName);
        if (existsUser != null) {
            throw new BusinessException("用户已存在：" + userName);
        }
    }

    private String encryptPwd(String originalPwd, String pwdSalt) {
        return MD5Util.getMd5(originalPwd + pwdSalt);
    }

}
