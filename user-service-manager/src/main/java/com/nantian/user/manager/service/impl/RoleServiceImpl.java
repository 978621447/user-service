package com.nantian.user.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nantian.user.api.domain.LoginInfo;
import com.nantian.user.api.domain.RoleInfo;
import com.nantian.user.api.domain.User;
import com.nantian.user.manager.dao.RoleInfoMapper;
import com.nantian.user.manager.domain.*;
import com.nantian.user.api.util.DateUtils;
import com.nantian.user.manager.service.IRoleService;
import com.nantian.user.manager.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author WangJinYi 2021/3/16
 */
@Service
public class RoleServiceImpl implements IRoleService {

    private static Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Autowired
    private RoleInfoMapper roleInfoMapper;

    @Override
    public Map<String, Object> list(RoleInfoQO roleInfoQO) {
        Map<String, Object> result = new HashMap<>();
        PageHelper.startPage(roleInfoQO.getPage(), roleInfoQO.getLimit());
        PageInfo<RoleInfo> pageInfo = new PageInfo<>(roleInfoMapper.selectByCondition(roleInfoQO));
        result.put("total", pageInfo.getTotal());
        result.put("items", pageInfo.getList());
        return result;
    }

    @Override
    public void saveRoleInfo(RoleInfoDTO roleInfoDTO, LoginInfo loginInfo) {
        User loginUser = loginInfo.getUser();
        RoleInfo record = new RoleInfo();
        record.setIdRole(UuidUtil.newUuid());
        record.setNamRole(roleInfoDTO.getName());
        record.setCodRoleState(roleInfoDTO.getState());
        record.setIdParntRole(roleInfoDTO.getPid());
        record.setIdRes(roleInfoDTO.getAppId());
        record.setIdOrg(roleInfoDTO.getOrgId());
        record.setVluRoleSeq(roleInfoDTO.getSeq());
        record.setCodRoleType(roleInfoDTO.getType());
        record.setTxtRoleDscr(roleInfoDTO.getDescription());
        record.setIdCrtor(loginUser.getIdCrtor());
        record.setTimeCrt(DateUtils.DATE_FORMAT_19.format(LocalDateTime.now()));
        roleInfoMapper.insertSelective(record);
    }

    @Override
    public void updateRoleInfo(RoleInfoDTO roleInfoDTO) {
        RoleInfo record = new RoleInfo();
        record.setIdRole(roleInfoDTO.getRoleId());
        record.setNamRole(roleInfoDTO.getName());
        record.setCodRoleState(roleInfoDTO.getState());
        record.setIdParntRole(roleInfoDTO.getPid());
        record.setIdRes(roleInfoDTO.getAppId());
        record.setIdOrg(roleInfoDTO.getOrgId());
        record.setTxtRoleDscr(roleInfoDTO.getDescription());
        roleInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public void deleteRole(String roleId) {
        roleInfoMapper.deleteByPrimaryKey(roleId);
    }

}
