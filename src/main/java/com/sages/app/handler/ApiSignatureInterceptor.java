package com.sages.app.handler;

import com.sages.app.constant.SystemConstant;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wanyifan
 * @date 2020/3/16
 */
@Configuration
public class ApiSignatureInterceptor extends HandlerInterceptorAdapter {

    private static final String ALLOW_URI = "login";
    private static final String REDIRECT_URL = "/login.html";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(request.getRequestURI());
        if (request.getRequestURI().contains(ALLOW_URI)) {
            return true;
        }

        Object user = request.getSession().getAttribute(SystemConstant.SESSION_USER_KEY);
        if (user==null){
            response.sendRedirect(REDIRECT_URL);
            return false;
        }
        return true;
    }
}
