package com.nantian.user.config;

import com.nantian.user.interceptor.SecurityInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author WangJinYi 2021/3/10
 */
@Configuration
public class WebAppConfig implements WebMvcConfigurer {

    @Autowired
    private SecurityInterceptor  securityInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册自己的拦截器并设置拦截的请求路径
        registry.addInterceptor(securityInterceptor)
                .excludePathPatterns("/error")
                .excludePathPatterns("/login**")
                .excludePathPatterns("/register**")
                .excludePathPatterns("/saveToken**")
                .addPathPatterns("/**");
    }

}