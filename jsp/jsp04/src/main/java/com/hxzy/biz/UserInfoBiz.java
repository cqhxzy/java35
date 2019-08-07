package com.hxzy.biz;

import com.hxzy.entity.UserInfo;

public interface UserInfoBiz {
    /**
     * 登录
     * @param loginName
     * @param loginPwd
     * @return
     */
    UserInfo login(String loginName, String loginPwd);
}
