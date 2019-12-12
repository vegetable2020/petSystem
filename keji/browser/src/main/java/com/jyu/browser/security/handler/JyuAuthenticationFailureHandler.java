package com.jyu.browser.security.handler;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.jyu.security.core.properties.SecurityProperties;
import com.jyu.security.core.support.LoginType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JyuAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    private Logger logger= LoggerFactory.getLogger(getClass());
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        logger.info("认证失败！！！");
        if(LoginType.JSON.equals(securityProperties.getBrowser().getLoginType())){
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(objectMapper.writeValueAsString(exception));
        }else {
            // 修改当前类实现接口为继承：SimpleUrlAuthenticationFailureHandler
            //调用父类到失败处理方法进行框架默认处理
            super.onAuthenticationFailure(request,response,exception);
        }
    }
}
