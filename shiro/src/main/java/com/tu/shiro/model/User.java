package com.tu.shiro.model;

/**
 * @Auther: tuyongjian
 * @Date: 2019/10/11 10:53
 * @Description:用户表
 */
public class User {

    private String userName;

    private String password;

    private String userId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
