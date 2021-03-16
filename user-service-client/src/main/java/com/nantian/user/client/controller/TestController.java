package com.nantian.user.client.controller;

import com.nantian.user.client.service.IUserService;
import com.nantian.user.api.domain.JsonResp;
import com.nantian.user.api.domain.SampleUser;
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
