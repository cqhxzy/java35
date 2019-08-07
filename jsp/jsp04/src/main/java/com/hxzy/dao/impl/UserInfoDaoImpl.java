package com.hxzy.dao.impl;

import com.hxzy.dao.UserInfoDao;
import com.hxzy.entity.UserInfo;
import com.hxzy.util.JDBCUtil;

import java.util.List;

public class UserInfoDaoImpl extends JDBCUtil implements UserInfoDao {
    @Override
    public UserInfo login(String loginName, String loginPwd) {
        String sql = "select uId,empId,loginName from usersInfo where loginName=? and loginPwd=?";
        List<UserInfo> userinfo = super.queryAll(UserInfo.class, sql, loginName, loginPwd);
        return userinfo.size() > 0 ? userinfo.get(0) : null;
    }
}
