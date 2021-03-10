package com.nantian.user.controller;

import com.nantian.user.domain.JsonResp;
import com.nantian.user.domain.SampleUser;
import com.nantian.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WangJinYi 2021/3/10
 */
@RestController
public class TestController {

    @Autowired
    private IUserService userService;

    @GetMapping("testInterceptor")
    public JsonResp testInterceptor(String id) {
        SampleUser sampleUser = userService.searchById(id);
        return JsonResp.ok().putData("sampleUser", sampleUser);
    }

}
