package com.hxzy.dao;

import com.hxzy.entity.Users;

public interface UsersDao extends CommonDao<Users> {

    /**
     * 登录的方法
     * @param loginName
     * @param loginPwd
     * @return
     */
    Users login(String loginName,String loginPwd);
}
