package com.hxzy.biz;

import com.hxzy.entity.Users;

public interface UsersBiz extends CommonBiz<Users> {
    /**
     * 登录的方法
     * @param loginName
     * @param loginPwd
     * @return
     */
    Users login(String loginName,String loginPwd);

    /**
     * 验证账号是否存在
     * @param loginName
     * @return
     */
    boolean validateLoginName(String loginName);
}
