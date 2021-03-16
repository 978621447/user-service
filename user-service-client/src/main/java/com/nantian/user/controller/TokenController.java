package com.nantian.user.controller;

import com.nantian.user.domain.JsonResp;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

/**
 * @author WangJinYi 2021/3/15
 */
@RestController
public class TokenController {

    @PostMapping("saveToken")
    public JsonResp saveToken(HttpServletRequest request, @RequestParam("token") String token) {
        request.getSession().setAttribute("token", token);
        return JsonResp.ok();
    }

}
