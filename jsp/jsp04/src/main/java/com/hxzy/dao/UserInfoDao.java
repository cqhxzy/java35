package com.hxzy.dao;

import com.hxzy.entity.UserInfo;

public interface UserInfoDao {
    /**
     * 登录
     * @param loginName
     * @param loginPwd
     * @return
     */
    UserInfo login(String loginName,String loginPwd);
}
