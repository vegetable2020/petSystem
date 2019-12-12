package com.jyu.browser.security;


import com.jyu.browser.security.handler.JyuAuthenticationFailureHandler;
import com.jyu.browser.security.handler.JyuAuthenticationSuccessHandler;
import com.jyu.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private SecurityProperties securityProperties;
    @Autowired
    private JyuAuthenticationSuccessHandler mathAuthenticationSuccessHandler;
    @Autowired
    private JyuAuthenticationFailureHandler mathAuthenticationFailureHandler;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()//改变认证方式
                .loginPage("/authentication/require")
                .loginProcessingUrl("/authentication/form")
                .successHandler(mathAuthenticationSuccessHandler)
                .failureHandler(mathAuthenticationFailureHandler)
                .and()//并且语法
                .authorizeRequests()//授权
                .antMatchers( "/authentication/require", securityProperties.getBrowser().getLoginPage(),"/static/Login.css").permitAll()
                .anyRequest()//任何请求必须经过授权
                .authenticated()
                .and()
                .csrf().disable();//关闭默认跨站防护
    }
}
