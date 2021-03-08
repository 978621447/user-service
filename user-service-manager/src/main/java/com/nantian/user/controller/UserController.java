package com.nantian.user.controller;

import com.nantian.user.domain.JsonResp;
import com.nantian.user.domain.SampleUser;
import com.nantian.user.domain.User;
import com.nantian.user.exception.BusinessException;
import com.nantian.user.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @author WangJinYi 2021/3/6
 */
@RestController
@RequestMapping("user")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    @GetMapping("searchById")
    public SampleUser searchById(@RequestParam(name = "id") String id) {
        return userService.getSampleUserById(id);
    }

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

    private void assertNotNull(Object o, String msg) {
        if (StringUtils.isEmpty(o)) {
            throw new BusinessException(msg);
        }
    }
}













