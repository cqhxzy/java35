package com.hxzy.biz.impl;

import com.hxzy.biz.UsersBiz;
import com.hxzy.entity.Users;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class UsersBizImplTest {

    @Test
    public void save() {
        UsersBiz usersBiz = new UsersBizImpl();

        Users users = new Users();
        users.setLoginName("zhangsan");
        users.setLoginPwd("123456");
        users.setUserName("张三");
        users.setEmail("12346@qq.com");
        users.setCreateTime(new Date());


        boolean save = usersBiz.save(users);
        assertThat(save,is(true));
    }

    @Test
    public void login(){
        UsersBiz usersBiz = new UsersBizImpl();
        Users zhangsan = usersBiz.login("zhangsan", "123456");
        System.out.println(zhangsan);
        assertThat(zhangsan,notNullValue());
    }
}