package com.nantian.user.manager.dao;

import com.nantian.user.api.domain.User;
import com.nantian.user.manager.domain.UserInfoQO;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(String idUser);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String idUser);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByUserName(String userName);

    List<User> selectByCondition(User user);
}