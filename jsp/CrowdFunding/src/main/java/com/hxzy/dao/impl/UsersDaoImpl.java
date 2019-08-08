package com.hxzy.dao.impl;

import com.hxzy.dao.UsersDao;
import com.hxzy.entity.Users;
import com.hxzy.util.JDBCUtil;

import java.util.List;

/**
 * 数据访问层的实现
 */
public class UsersDaoImpl extends JDBCUtil implements UsersDao {
    @Override
    public Users login(String loginName, String loginPwd) {
        String sql = "select uId,loginName,userName,email,createTime from t_users where loginName = ? and loginPwd = ?";
        List<Users> users = super.queryAll(Users.class, sql, loginName,loginPwd);
        return users.size() > 0 ? users.get(0) : null;
    }

    @Override
    public int save(Users users) {
        String sql = "insert into t_users (loginName,loginPwd,userName,email,createTime) values (?,?,?,?,?)";
        Object[] params = {users.getLoginName(),users.getLoginPwd(),users.getUserName(),users.getEmail(),users.getCreateTime()};
        return super.executeUpdate(sql,params);
    }

    @Override
    public int update(Users users) {
        return 0;
    }

    @Override
    public int deleteById(Integer id) {
        String sql = "delete from t_users where uid = ?";
        return super.executeUpdate(sql, id);
    }

    @Override
    public Users findById(Integer id) {
        String sql = "select uId,loginName,userName,email,createTime from t_users where uid = ?";
        List<Users> users = super.queryAll(Users.class, sql, id);
        return users.size() > 0 ? users.get(0) : null;
    }
}
