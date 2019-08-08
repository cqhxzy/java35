package com.hxzy.entity;

import java.util.Date;

public class Users {
    private Integer uId;
    private String loginName;
    private String loginPwd;
    private String userName;
    private String email;
    private Date createTime;

    public Users() {
    }

    public Users(Integer uId, String loginName, String loginPwd, String userName, String email, Date createTime) {
        this.uId = uId;
        this.loginName = loginName;
        this.loginPwd = loginPwd;
        this.userName = userName;
        this.email = email;
        this.createTime = createTime;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Users{" +
                "uId=" + uId +
                ", loginName='" + loginName + '\'' +
                ", loginPwd='" + loginPwd + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
