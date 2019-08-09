package com.hxzy.dao;

import com.hxzy.entity.Users;

import java.util.List;
import java.util.Map;

public interface UsersDao extends CommonDao<Users> {

    /**
     * 登录的方法
     * @param loginName
     * @param loginPwd
     * @return
     */
    Users login(String loginName,String loginPwd);

    /**
     * 根据登录账号查询用户
     * @param loginName
     * @return
     */
    Users validateLoginName(String loginName);

    /**
     * 分页查询
     * @param pageIndex
     * @param pageSize
     * @return
     */
    List<Users> paging(int pageIndex, int pageSize, Map condition);

    int pagingCount(Map condition);
}
