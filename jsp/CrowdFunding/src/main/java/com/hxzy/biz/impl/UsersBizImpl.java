package com.hxzy.biz.impl;

import com.hxzy.biz.UsersBiz;
import com.hxzy.dao.UsersDao;
import com.hxzy.dao.impl.UsersDaoImpl;
import com.hxzy.entity.Users;
import com.hxzy.util.StringUtil;

/**
 * 业务逻辑层的实现
 */
public class UsersBizImpl implements UsersBiz {

    //调用数据访问层
    private UsersDao usersDao = new UsersDaoImpl();

    @Override
    public Users login(String loginName, String loginPwd) {
        String encrypt = StringUtil.encrypt(loginPwd); //加密密码
        return usersDao.login(loginName,encrypt);
    }

    @Override
    public boolean save(Users users) {
        String encrypt = StringUtil.encrypt(users.getLoginPwd()); //加密密码
        users.setLoginPwd(encrypt);
        return usersDao.save(users) > 0;
    }

    @Override
    public boolean update(Users users) {

        return false;
    }

    @Override
    public boolean deleteById(Integer id) {

        return usersDao.deleteById(id) > 0;
    }

    @Override
    public Users findById(Integer id) {
        return usersDao.findById(id);
    }
}
