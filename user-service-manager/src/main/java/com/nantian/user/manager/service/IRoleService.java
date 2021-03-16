package com.nantian.user.manager.service;

import com.nantian.user.api.domain.LoginInfo;
import com.nantian.user.manager.domain.*;
import java.util.Map;

/**
 * @author WangJinYi 2021/3/16
 */
public interface IRoleService {

    Map<String, Object> list(RoleInfoQO roleInfoQO);

    void saveRoleInfo(RoleInfoDTO roleInfoDTO, LoginInfo loginInfo);
}
