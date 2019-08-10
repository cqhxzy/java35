package com.hxzy.biz;

import com.hxzy.entity.Users;

import java.util.List;
import java.util.Map;

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

    /**
     * 分页查询
     * @param pageIndex
     * @param pageSize
     * @return
     */
    List<Users> paging(int pageIndex, int pageSize, Map condition);

    int pagingCount(Map condition);
}
