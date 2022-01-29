package com.atmae.store.config;

import com.atmae.store.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * 处理器拦截器的注册
 * @author Mae
 */
@Configuration
public class LoginInterceptorConfigurer implements WebMvcConfigurer {
    @Override
    /** 将自定义拦截器进行注册*/
    public void addInterceptors(InterceptorRegistry registry) {
        /** 自定义拦截器对象*/
        HandlerInterceptor interceptor=new LoginInterceptor();
        /** 配置白名单:存放在List集合中*/
        List<String> patterns =new ArrayList<>();
        patterns.add("/assets/**");
        patterns.add("/users/login");
        patterns.add("/users/register");
        patterns.add("/register");
        patterns.add("/login");
        patterns.add("/index");
        patterns.add("/district/**");
        /** 完成拦截器的注册*/
        /** 要拦截url  /**： 表示项目下所有的请求被拦截*/
        registry.addInterceptor(interceptor).addPathPatterns("/**")
                .excludePathPatterns(patterns);
    }
}
