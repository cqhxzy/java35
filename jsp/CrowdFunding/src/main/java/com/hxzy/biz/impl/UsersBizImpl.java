package com.hxzy.biz.impl;

import com.hxzy.biz.UsersBiz;
import com.hxzy.dao.UsersDao;
import com.hxzy.dao.impl.UsersDaoImpl;
import com.hxzy.entity.Users;
import com.hxzy.util.PageUtil;
import com.hxzy.util.StringUtil;

import java.util.List;
import java.util.Map;

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
    public boolean validateLoginName(String loginName) {
        return usersDao.validateLoginName(loginName) == null;
    }

    @Override
    public List<Users> paging(int pageIndex, int pageSize, Map condition) {
        return usersDao.paging(pageIndex, pageSize, condition);
    }

    @Override
    public int pagingCount(Map condition) {
        return usersDao.pagingCount(condition);
    }

    /**
     * 分页查询
     * @param pageUtil
     * @param condition
     * @return
     */
    public PageUtil<Users> page(PageUtil pageUtil, Map condition){
        List<Users> paging = this.paging(pageUtil.getPageIndex(), pageUtil.getPageSize(), condition);  //分页查询出的数据
        int pagingCount = this.pagingCount(condition);      //总共有多少条数据

        pageUtil.setData(paging);
        pageUtil.setTotal(pagingCount);


        return pageUtil;
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
