package com.nantian.user.manager.dao;


import com.nantian.user.api.domain.MenuInfo;
import com.nantian.user.manager.domain.MenuInfoQO;

import java.util.List;

public interface MenuInfoMapper {
    int deleteByPrimaryKey(String idMenu);

    int insert(MenuInfo record);

    int insertSelective(MenuInfo record);

    MenuInfo selectByPrimaryKey(String idMenu);

    List<MenuInfo> selectByCondition(MenuInfoQO menuInfoQO);

    int updateByPrimaryKeySelective(MenuInfo record);

    int updateByPrimaryKey(MenuInfo record);
}