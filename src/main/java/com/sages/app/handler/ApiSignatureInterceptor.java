package com.sages.app.handler;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.sages.app.constant.SystemConstant;
import com.sages.app.constant.enums.Status;
import com.sages.app.exception.TokenException;
import com.sages.app.service.WxLoginProxyService;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wanyifan
 * @date 2020/3/16
 */
@Configuration
public class ApiSignatureInterceptor extends HandlerInterceptorAdapter {
    private static final Log log = LogFactory.get();

    private static final String REDIRECT_URL = "/login.html";
    private static List<String> ALLOW_URI_LIST = new ArrayList<>();
    private static final String WX_ALLOW_URI = "api";

    static {
        ALLOW_URI_LIST.add("login");
    }

    private final WxLoginProxyService wxLoginProxyService;

    public ApiSignatureInterceptor(WxLoginProxyService wxLoginProxyService) {
        this.wxLoginProxyService = wxLoginProxyService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        for (String s : ALLOW_URI_LIST) {
            if (requestURI.contains(s)) {
                log.info("web 通过: {}",requestURI);
                return true;
            }
        }
        if (requestURI.contains(WX_ALLOW_URI)){
            String token = request.getHeader("token");
            if (wxLoginProxyService.checkToken(token)) {
                log.info("wx-api 通过: {}",requestURI);
                return true;
            }else {
                log.info("wx-api 拒绝: {}",request.getRequestURI());
                throw new TokenException(Status.UNAUTHORIZED);
            }
        }
        Object user = request.getSession().getAttribute(SystemConstant.SESSION_USER_KEY);
        if (user==null){
            response.sendRedirect(REDIRECT_URL);
            log.info("拒绝: {}",request.getRequestURI());
            throw new TokenException(Status.UNAUTHORIZED);
        }
        log.info("session 通过: {}",request.getRequestURI());
        return true;
    }
}
