package com.nantian.user.manager.dao;


import com.nantian.user.api.domain.RoleInfo;
import com.nantian.user.manager.domain.*;

import java.util.List;

public interface RoleInfoMapper {
    int deleteByPrimaryKey(String idRole);

    int insert(RoleInfo record);

    int insertSelective(RoleInfo record);

    RoleInfo selectByPrimaryKey(String idRole);

    int updateByPrimaryKeySelective(RoleInfo record);

    int updateByPrimaryKey(RoleInfo record);

    List<RoleInfo> selectByCondition(RoleInfoQO roleInfoQO);
}