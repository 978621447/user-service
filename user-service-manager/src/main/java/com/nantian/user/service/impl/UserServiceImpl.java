package com.nantian.user.service.impl;

import com.nantian.user.dao.SampleUserMapper;
import com.nantian.user.dao.UserMapper;
import com.nantian.user.domain.SampleUser;
import com.nantian.user.domain.User;
import com.nantian.user.exception.BusinessException;
import com.nantian.user.service.IUserService;
import com.nantian.user.util.MD5Util;
import com.nantian.user.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author WangJinYi 2021/3/6
 */
@Service
public class UserServiceImpl implements IUserService {

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

    private void checkExists(User user) {
        String userName = user.getNamUser();
        List<User> users = userMapper.selectByUserName(userName);
        if (!users.isEmpty()) {
            throw new BusinessException("用户已存在：" + userName);
        }
    }

    private String encryptPwd(String originalPwd, String pwdSalt) {
        return MD5Util.getMd5(originalPwd + pwdSalt);
    }

}
