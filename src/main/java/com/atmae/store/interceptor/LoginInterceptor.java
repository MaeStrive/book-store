package com.atmae.store.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Mae
 */
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 检测全局Session是否有uid数据，如果有则方行，没有重定向到登录页面
     *
     * @param request  请求对象
     * @param response 响应对象
     * @param handler  处理器(url+Controller:映射)
     * @return true表示放行当前的请求 false表示拦截当前的请求
     * @throws Exception 异常
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("userId");
        if (user == null) {
            /** 说明用户没有登录 则重定向到登陆页*/
            response.sendRedirect("/login");
            return false;
        }
            /** 表示放行*/
        return true;
    }
}
