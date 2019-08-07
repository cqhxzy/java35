package com.hxzy.entity;

import java.util.Objects;

/**
 * 用户信息
 */
public class UserInfo {
     private Integer uId;
     private Integer empId;
     private String loginName;
     private String loginPwd;

    public UserInfo() {
    }

    public UserInfo(Integer empId, String loginName, String loginPwd) {
        this.empId = empId;
        this.loginName = loginName;
        this.loginPwd = loginPwd;
    }

    public UserInfo(Integer uId, Integer empId, String loginName, String loginPwd) {
        this.uId = uId;
        this.empId = empId;
        this.loginName = loginName;
        this.loginPwd = loginPwd;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "uId=" + uId +
                ", empId=" + empId +
                ", loginName='" + loginName + '\'' +
                ", loginPwd='" + loginPwd + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfo userInfo = (UserInfo) o;
        return Objects.equals(uId, userInfo.uId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uId);
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
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
}
