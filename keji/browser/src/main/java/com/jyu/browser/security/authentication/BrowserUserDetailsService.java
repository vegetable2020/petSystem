package com.jyu.browser.security.authentication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class BrowserUserDetailsService implements UserDetailsService {
    private Logger logger= LoggerFactory.getLogger(getClass());
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("登录名："+username);
        //再次根据传来的username加载用户信息
        //User user=new User(username,"123456", AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
        //模拟用户账户被锁
        //User user=new User(username,"123456", true,true,true,true,AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
        //模拟数据库密码加密
        String encodePwd=passwordEncoder.encode("123456");
        System.out.println("原生密码为：123456");
        User user=new User(username,encodePwd, true,true,true,true,AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
        System.out.println("加密密码为："+encodePwd);
        return user;

    }
}
