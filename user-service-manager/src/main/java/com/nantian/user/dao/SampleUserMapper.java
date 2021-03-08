package com.nantian.user.dao;

import com.nantian.user.domain.SampleUser;

public interface SampleUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(SampleUser record);

    int insertSelective(SampleUser record);

    SampleUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SampleUser record);

    int updateByPrimaryKey(SampleUser record);
}