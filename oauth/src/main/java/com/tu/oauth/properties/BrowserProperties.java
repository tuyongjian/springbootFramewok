package com.tu.oauth.properties;

import com.tu.oauth.pojo.LoginType;

/**
 * @Description
 * @Classname BrowserProperties
 * @Date 2019/7/25 10:54
 * @Created by tuyongjian
 */
public class BrowserProperties {

    private String loginPage = "/browser-login.html";

    private LoginType loginType = LoginType.JSON;

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }
}