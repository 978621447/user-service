package com.nantian.user.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nantian.user.api.domain.RoleInfo;
import com.nantian.user.manager.dao.SampleUserMapper;
import com.nantian.user.manager.dao.UserMapper;
import com.nantian.user.manager.domain.UserInfoQO;
import com.nantian.user.manager.service.IUserService;
import com.nantian.user.manager.util.MD5Util;
import com.nantian.user.manager.util.UuidUtil;
import com.nantian.user.api.domain.LoginInfo;
import com.nantian.user.api.domain.SampleUser;
import com.nantian.user.api.domain.User;
import com.nantian.user.api.exception.BusinessException;
import com.nantian.user.api.util.DateUtils;
import com.nantian.user.api.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author WangJinYi 2021/3/6
 */
@Service("managerUserService")
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

    @Override
    public Map<String, Object> list(UserInfoQO userInfoQO) {
        Map<String, Object> result = new HashMap<>();
        PageHelper.startPage(userInfoQO.getPage(), userInfoQO.getLimit());
        User queryUser = new User();
        queryUser.setIdOrg(userInfoQO.getOrgId());
        queryUser.setNamUser(userInfoQO.getName());
        PageInfo<User> pageInfo = new PageInfo<>(userMapper.selectByCondition(queryUser));
        result.put("total", pageInfo.getTotal());
        result.put("items", pageInfo.getList());
        return result;
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
