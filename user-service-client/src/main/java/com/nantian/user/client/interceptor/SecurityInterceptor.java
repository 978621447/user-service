package com.nantian.user.client.interceptor;

import com.nantian.user.api.domain.LoginInfo;
import com.nantian.user.client.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author WangJinYi 2021/3/10
 */
@Component
public class SecurityInterceptor extends HandlerInterceptorAdapter {

    private static Logger logger = LoggerFactory.getLogger(SecurityInterceptor.class);

    @Value("${url.login}")
    private String loginUrl;

    @Autowired
    private IUserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        if (isWhiteUrl(request.getRequestURL().toString())) {
            return true;
        }
        String token = request.getHeader("token");
        if (token == null) {
            token = (String) request.getSession().getAttribute("token");
        }
        LoginInfo loginInfo = userService.getLoginInfo(token);
        if (loginInfo == null) {
            response.sendRedirect(loginUrl);
            return false;
        } else {
            logger.debug("token = {}", token);
            return true;
        }
    }

    /**
     * 白名单url不拦截
     *
     * @param url url
     * @return true for white url
     */
    private boolean isWhiteUrl(String url) {
        String lowerUrl = url.toLowerCase();
        return url.contains("error")
                || url.contains("login")
                || url.contains("registerUser")
                || url.contains("saveToken")
                || lowerUrl.contains("swagger")
                || lowerUrl.contains("webjars")
                || lowerUrl.contains("v2")
                || url.endsWith("/manager/")
                || url.endsWith("/manager/csrf");
    }

}
