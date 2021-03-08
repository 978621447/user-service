package com.nantian.user.dao;

import com.nantian.user.domain.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(String idUser);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String idUser);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectByUserName(String userName);
}