package com.nantian.user.manager.controller;

import com.nantian.user.api.domain.JsonResp;
import com.nantian.user.api.domain.LoginInfo;
import com.nantian.user.api.util.RedisUtil;
import com.nantian.user.api.exception.*;
import com.nantian.user.manager.service.IRoleService;
import com.nantian.user.manager.domain.*;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author WangJinYi 2021/3/16
 */
@Api(tags = "角色管理相关接口")
@RestController
@RequestMapping("role")
public class RoleController {

    private static Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private IRoleService roleService;

    @Autowired
    private RedisUtil redisUtil;

    @ApiOperation("角色列表")
    @PostMapping("list")
    public JsonResp list(RoleInfoQO roleInfoQO) {
        try {
            Map<String, Object> data = roleService.list(roleInfoQO);
            return JsonResp.ok()
                    .putData("total", data.get("total"))
                    .putData("items", data.get("items"));
        } catch (BusinessException e) {
            return JsonResp.failure(e.getMessage());
        } catch (Exception e) {
            logger.error("获取角色列表异常", e);
            return JsonResp.failure("获取角色列表异常");
        }
    }

    @ApiOperation("新增角色")
    @PostMapping("create")
    public JsonResp create(RoleInfoDTO roleInfoDTO, HttpServletRequest request) {
        try {
            String token = request.getHeader("token");
            LoginInfo loginInfo = (LoginInfo) redisUtil.get(token);
            roleService.saveRoleInfo(roleInfoDTO, loginInfo);
            return JsonResp.ok();
        } catch (BusinessException e) {
            return JsonResp.failure(e.getMessage());
        } catch (Exception e) {
            logger.error("新增角色异常", e);
            return JsonResp.failure("新增角色异常");
        }
    }

    @ApiOperation("编辑角色")
    @PostMapping("update")
    public JsonResp update(RoleInfoDTO roleInfoDTO) {
        try {
            roleService.updateRoleInfo(roleInfoDTO);
            return JsonResp.ok();
        } catch (BusinessException e) {
            return JsonResp.failure(e.getMessage());
        } catch (Exception e) {
            logger.error("编辑角色异常", e);
            return JsonResp.failure("编辑角色异常");
        }
    }

    @ApiOperation("删除角色")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roleId", value = "角色id", defaultValue = "0", required = true)
    })
    @PostMapping("delete")
    public JsonResp delete(String roleId) {
        try {
            roleService.deleteRole(roleId);
            return JsonResp.ok();
        } catch (BusinessException e) {
            return JsonResp.failure(e.getMessage());
        } catch (Exception e) {
            logger.error("删除角色异常", e);
            return JsonResp.failure("删除角色异常");
        }
    }

}
