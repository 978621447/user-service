package com.nantian.user.manager.controller;

import com.nantian.user.api.exception.BusinessException;
import com.nantian.user.manager.service.IUserService;
import com.nantian.user.api.domain.JsonResp;
import com.nantian.user.api.domain.SampleUser;
import com.nantian.user.api.domain.User;
import com.nantian.user.api.util.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @author WangJinYi 2021/3/6
 */
@Api(tags = "用户管理相关接口")
@RestController
@RequestMapping("user")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("searchById")
    public SampleUser searchById(@RequestParam(name = "id") String id) {
        return userService.getSampleUserById(id);
    }

    @ApiOperation("添加用户的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "namUser", value = "用户账号", defaultValue = "admin", required = true),
            @ApiImplicitParam(name = "vluUserPwd", value = "用户密码", defaultValue = "123456", required = true)
    })
    @PostMapping("registerUser")
    public JsonResp registerUser(User user) {
        try {
            assertNotNull(user.getNamUser(), "用户名为空");
            assertNotNull(user.getVluUserPwd(), "密码为空");
            userService.registerUser(user);
        } catch (BusinessException e) {
            return JsonResp.failure(e.getMessage());
        } catch (Exception e) {
            logger.error("用户注册异常", e);
            return JsonResp.failure("用户注册异常");
        }
        return JsonResp.ok();
    }

    @ApiOperation("用户登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "namUser", value = "用户账号", defaultValue = "admin", required = true),
            @ApiImplicitParam(name = "vluUserPwd", value = "用户密码", defaultValue = "123456", required = true)
    })
    @PostMapping("login")
    public JsonResp login(User loginUser) {
        try {
            assertNotNull(loginUser.getNamUser(), "用户名为空");
            assertNotNull(loginUser.getVluUserPwd(), "密码为空");
            String token = userService.login(loginUser);
            return JsonResp.ok().putData("token", token);
        } catch (BusinessException e) {
            return JsonResp.failure(e.getMessage());
        } catch (Exception e) {
            logger.error("登录异常", e);
            return JsonResp.failure("登录异常");
        }
    }

    @ApiOperation("用户登出接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "token", defaultValue = "ac1c4336bcf241929f92da7eb6abc5d4admin20210311214857", required = true)
    })
    @PostMapping("logout")
    public JsonResp logout(String token) {
        try {
            if (redisUtil.get(token) == null) {
                return JsonResp.failure("用户令牌无效，退出登录失败！");
            } else {
                redisUtil.del(token);
                return JsonResp.ok("退出登录成功！");
            }
        } catch (BusinessException e) {
            return JsonResp.failure(e.getMessage());
        } catch (Exception e) {
            logger.error("退出登录异常", e);
            return JsonResp.failure("退出登录异常");
        }
    }

    private void assertNotNull(Object o, String msg) {
        if (StringUtils.isEmpty(o)) {
            throw new BusinessException(msg);
        }
    }
}













