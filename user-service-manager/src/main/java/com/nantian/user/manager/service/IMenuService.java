package com.nantian.user.manager.service;

import com.nantian.user.api.domain.MenuInfo;
import com.nantian.user.manager.domain.MenuInfoDTO;
import com.nantian.user.manager.domain.MenuInfoQO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author WangJinYi 2021/3/17
 */
public interface IMenuService {

    Map<String, Object> list(MenuInfoQO menuInfoQO);

    void create(MenuInfoDTO menuInfoDTO);

    void update(MenuInfoDTO menuInfoDTO);

    void delete(List<String> menuIds);
}
