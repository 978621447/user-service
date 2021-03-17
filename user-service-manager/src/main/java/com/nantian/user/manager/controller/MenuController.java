package com.nantian.user.manager.controller;

import com.nantian.user.api.domain.JsonResp;
import com.nantian.user.api.domain.MenuInfo;
import com.nantian.user.api.exception.BusinessException;
import com.nantian.user.manager.domain.MenuInfoDTO;
import com.nantian.user.manager.domain.MenuInfoQO;
import com.nantian.user.manager.domain.RoleInfoQO;
import com.nantian.user.manager.service.IMenuService;
import com.nantian.user.manager.service.impl.RoleServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author WangJinYi 2021/3/17
 */
@Api(tags = "菜单管理相关接口")
@RestController
@RequestMapping("menu")
public class MenuController {

    private static Logger logger = LoggerFactory.getLogger(MenuController.class);

    @Autowired
    private IMenuService menuService;

    @ApiOperation("菜单列表")
    @PostMapping("list")
    public JsonResp list(MenuInfoQO menuInfoQO) {
        try {
            Map<String, Object> data = menuService.list(menuInfoQO);
            return JsonResp.ok()
                    .putData("total", data.get("total"))
                    .putData("items", data.get("items"));
        } catch (BusinessException e) {
            return JsonResp.failure(e.getMessage());
        } catch (Exception e) {
            logger.error("获取菜单列表异常", e);
            return JsonResp.failure("获取菜单列表异常");
        }
    }

    @ApiOperation("新增菜单")
    @PostMapping("create")
    public JsonResp create(MenuInfoDTO menuInfoDTO) {
        try {
            menuService.create(menuInfoDTO);
            return JsonResp.ok();
        } catch (BusinessException e) {
            return JsonResp.failure(e.getMessage());
        } catch (Exception e) {
            logger.error("新增菜单异常", e);
            return JsonResp.failure("新增菜单异常");
        }
    }

    @ApiOperation("编辑菜单")
    @PostMapping("update")
    public JsonResp update(MenuInfoDTO menuInfoDTO) {
        try {
            menuService.update(menuInfoDTO);
            return JsonResp.ok();
        } catch (BusinessException e) {
            return JsonResp.failure(e.getMessage());
        } catch (Exception e) {
            logger.error("编辑菜单异常", e);
            return JsonResp.failure("编辑菜单异常");
        }
    }

    @ApiOperation("删除菜单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "menuIds", value = "菜单id，例：[\"111\",\"222\",\"3333\"]", defaultValue = "", required = true)
    })
    @PostMapping("delete")
    public JsonResp delete(@RequestBody List<String> menuIds) {
        try {
            menuService.delete(menuIds);
            return JsonResp.ok();
        } catch (BusinessException e) {
            return JsonResp.failure(e.getMessage());
        } catch (Exception e) {
            logger.error("删除菜单异常", e);
            return JsonResp.failure("删除菜单异常");
        }
    }

}
