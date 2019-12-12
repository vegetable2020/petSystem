package com.jyu.browser.security;

import com.jyu.security.core.properties.SecurityProperties;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class BrowserSecurityController {
    //实例化请求缓存器对象
    private Logger logger= LoggerFactory.getLogger(getClass());
    //实例化跳转对象
    private RequestCache requestCache=new HttpSessionRequestCache();
    //注入属性配置对象
    private RedirectStrategy redirectStrategy=new DefaultRedirectStrategy();
    @Autowired
    private SecurityProperties securityProperties;
    @Autowired
    private SecurityProperties properties;
    @RequestMapping("/authentication/require")
    @ResponseStatus(code= HttpStatus.UNAUTHORIZED)
    public SimpleResponse requireAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //从请求缓存中获取请求对象
        SavedRequest savedRequest= requestCache.getRequest(request,response);
        if(null!=savedRequest){
            String target=savedRequest.getRedirectUrl();
            logger.info("登录页面是："+properties.getBrowser().getLoginPage());
            logger.info("引发跳转的路径是："+target);
            if(StringUtils.endsWith(target,".html")){
                //通过redirectStrategy进行请求的跳转
                redirectStrategy.sendRedirect(request,response,securityProperties.getBrowser().getLoginPage());
            }
        }
        //如果代码执行到此，说明请求需要返回的是json数据
        return new SimpleResponse("访问的资源需要认证，请引导用户到登录页面！");
    }
}
