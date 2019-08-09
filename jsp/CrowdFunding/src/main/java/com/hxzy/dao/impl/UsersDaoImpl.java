package com.hxzy.dao.impl;

import com.alibaba.druid.util.ResultSetConsumer;
import com.hxzy.dao.UsersDao;
import com.hxzy.entity.Users;
import com.hxzy.util.JDBCUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

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
    public Users validateLoginName(String loginName) {
        String sql = "select uId,loginName,userName,email,createTime from t_users where loginName = ?";
        List<Users> users = super.queryAll(Users.class, sql, loginName);
        return users.size() > 0 ? users.get(0) : null;
    }

    @Override
    public List<Users> paging(int pageIndex, int pageSize, Map condition) {

        StringBuilder builder = new StringBuilder();
        builder.append("select uId,loginName,userName,email,createTime from t_users")
                .append(" where 1 = 1");
        if (condition != null) {//动态拼接sql语句
            builder = dynSql(builder.toString(),condition);
        }
        builder.append(" limit ?, ?");
        String sql = builder.toString();

        Object[] objects = new Object[0]; //为了避免空指针异常
        if (condition != null) {
           objects = condition.keySet().stream().map(key -> condition.get(key)).toArray();
        }
        Object[] params = Arrays.copyOf(objects,objects.length + 2);
        params[params.length - 2] = (pageIndex - 1) * pageSize;
        params[params.length - 1] = pageSize;

        return super.queryAll(Users.class,sql,params);
    }

    private StringBuilder dynSql(String sql,Map condition){
        //动态拼接sql语句
        StringBuilder builder = new StringBuilder(sql);

        if (condition != null) {
            Set set = condition.keySet();
            set.stream().forEach(key->{
                builder.append(" and " +  key + " = ? ");
            });
        }
        return builder;
    }

    @Override
    public int pagingCount(Map condition) {
        StringBuilder builder = new StringBuilder();
        builder.append("select count(*) userCount from t_users")
                .append(" where 1 = 1");
        if (condition != null) {//动态拼接sql语句
            builder = dynSql(builder.toString(),condition);
        }
        String sql = builder.toString();

        Object[] objects = null;
        if (condition != null) {
            objects = condition.keySet().stream().map(key -> condition.get(key)).toArray();
        }

        List<Map<String, Object>> list = super.queryAll(builder.toString(), objects);
        Long l = (Long) list.get(0).get("userCount");
        return l.intValue() ;
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
