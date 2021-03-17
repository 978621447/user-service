package com.nantian.user.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nantian.user.api.domain.MenuInfo;
import com.nantian.user.api.domain.RoleInfo;
import com.nantian.user.manager.dao.MenuInfoMapper;
import com.nantian.user.manager.domain.MenuInfoDTO;
import com.nantian.user.manager.domain.MenuInfoQO;
import com.nantian.user.manager.service.IMenuService;
import com.nantian.user.manager.util.UuidUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author WangJinYi 2021/3/17
 */
@Service
public class MenuServiceImpl implements IMenuService {

    private static Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);

    @Autowired
    private MenuInfoMapper menuInfoMapper;

    @Override
    public Map<String, Object> list(MenuInfoQO menuInfoQO) {
        Map<String, Object> result = new HashMap<>();
        PageHelper.startPage(menuInfoQO.getPage(), menuInfoQO.getLimit());
        PageInfo<MenuInfo> pageInfo = new PageInfo<>(menuInfoMapper.selectByCondition(menuInfoQO));
        result.put("total", pageInfo.getTotal());
        result.put("items", pageInfo.getList());
        return result;
    }

    @Override
    public void create(MenuInfoDTO menuInfoDTO) {
        MenuInfo menuInfo = new MenuInfo();
        menuInfo.setIdMenu(UuidUtil.newUuid());
        changeField(menuInfoDTO, menuInfo);
        menuInfoMapper.insertSelective(menuInfo);
    }

    /**
     * 变量赋值
     * @param menuInfoDTO 源对象
     * @param menuInfo 目标对象
     */
    private void changeField(MenuInfoDTO menuInfoDTO, MenuInfo menuInfo) {
        menuInfo.setNamMenu(menuInfoDTO.getName());
        menuInfo.setCodParntMenu(menuInfoDTO.getpCode());
        menuInfo.setCodMenuState(menuInfoDTO.getState());
        menuInfo.setVluMenuSeq(menuInfoDTO.getSeq());
        menuInfo.setCodMenuType(menuInfoDTO.getType());
        menuInfo.setTxtMenuUrl(menuInfoDTO.getMenuUrl());
        menuInfo.setTxtMenuDscr(menuInfoDTO.getDescription());
        menuInfo.setVluMenuIcon(menuInfoDTO.getIcon());
        menuInfo.setIndDlgt(menuInfoDTO.getPath());
        menuInfo.setCode(menuInfoDTO.getCode());
    }

    @Override
    public void update(MenuInfoDTO menuInfoDTO) {
        MenuInfo menuInfo = new MenuInfo();
        menuInfo.setIdMenu(menuInfoDTO.getId());
        changeField(menuInfoDTO, menuInfo);
        menuInfoMapper.updateByPrimaryKeySelective(menuInfo);
    }

    @Override
    public void delete(List<String> menuIds) {
        menuIds.forEach(i -> menuInfoMapper.deleteByPrimaryKey(i));
    }

}
