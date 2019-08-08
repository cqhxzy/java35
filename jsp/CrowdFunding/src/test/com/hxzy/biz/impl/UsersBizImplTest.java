package com.hxzy.biz.impl;

import com.hxzy.biz.UsersBiz;
import com.hxzy.entity.Users;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class UsersBizImplTest {

    @Test
    public void save() {
        UsersBiz usersBiz = new UsersBizImpl();

        Users users = new Users();
        users.setLoginName("lisi");
        users.setLoginPwd("123456");
        users.setUserName("李四");
        users.setEmail("12346@qq.com");
        users.setCreateTime(new Date());


        boolean save = usersBiz.save(users);
        assertThat(save,is(true));
    }

    @Test
    public void login(){
        UsersBiz usersBiz = new UsersBizImpl();
        Users zhangsan = usersBiz.login("lisi", "123456");
        System.out.println(zhangsan);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(zhangsan.getCreateTime());
        System.out.println(format);
        assertThat(zhangsan,notNullValue());
    }
}