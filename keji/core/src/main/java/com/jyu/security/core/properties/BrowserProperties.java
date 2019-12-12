package com.jyu.security.core.properties;


import com.jyu.security.core.support.LoginType;

/**
 * 浏览器属性配置
 */
public class BrowserProperties {
    private String loginPage="/math-signIn.html";
    private LoginType loginType=LoginType.JSON;

    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }
}
