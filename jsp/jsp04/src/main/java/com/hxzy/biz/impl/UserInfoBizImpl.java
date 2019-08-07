package com.hxzy.biz.impl;

import com.hxzy.biz.UserInfoBiz;
import com.hxzy.dao.UserInfoDao;
import com.hxzy.dao.impl.UserInfoDaoImpl;
import com.hxzy.entity.UserInfo;

public class UserInfoBizImpl implements UserInfoBiz {
    private UserInfoDao dao = new UserInfoDaoImpl();
    @Override
    public UserInfo login(String loginName, String loginPwd) {
        return dao.login(loginName,loginPwd);
    }
}
