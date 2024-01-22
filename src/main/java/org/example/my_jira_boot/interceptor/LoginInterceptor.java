package org.example.my_jira_boot.interceptor;

import cn.hutool.core.util.StrUtil;
import lombok.extern.log4j.Log4j2;
import org.example.my_jira_boot.util.JWTUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Log4j2
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authorization = request.getHeader("Authorization");
        String user = request.getHeader("User");
        if (StrUtil.isBlank(authorization) || !StrUtil.startWith(authorization,"Bearer")) {
            log.error("验证失败");
            return false;
        }
        //authorization去掉前面的Bearer
        String token = authorization.substring(7);
        log.info("token="+token);
        log.info("user="+user);
        //登录校验===>验证token和user
        if (JWTUtil.verifyTokenByRSA256(token,user)) {
            log.info("验证通过==>user="+user);
            return true;
        } else {
            log.error("验证失败");
            return false;
        }
    }
}
