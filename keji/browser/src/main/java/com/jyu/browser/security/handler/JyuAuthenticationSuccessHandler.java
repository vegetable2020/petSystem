package com.jyu.browser.security.handler;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.jyu.security.core.properties.SecurityProperties;
import com.jyu.security.core.support.LoginType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class JyuAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    private Logger logger= LoggerFactory.getLogger(getClass());
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        logger.info("认证成功！！！");
        if(LoginType.JSON.equals(securityProperties.getBrowser().getLoginType())){
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(objectMapper.writeValueAsString(authentication));
        }else {
            //修改当前类实现到接口为框架默认实现类：SavedRequestAwareAuthenticationSuccessHandler
            //调用父类到处理方法，让框架进行默认到处理
            super.onAuthenticationSuccess(request,response,authentication);
        }
    }
}
