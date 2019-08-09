package com.hxzy.biz.impl;

import com.alibaba.fastjson.JSONObject;
import com.hxzy.biz.UsersBiz;
import com.hxzy.entity.Users;
import com.hxzy.util.PageUtil;
import org.hamcrest.Condition;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

    @Test
    public void valieDate(){
        UsersBiz usersBiz = new UsersBizImpl();
        boolean lisi = usersBiz.validateLoginName("2222");
        System.out.println(lisi);
    }

    @Test
    public void testPage(){
        UsersBiz usersBiz = new UsersBizImpl();
        Map condition = new LinkedHashMap();
        condition.put("email", "12346@qq.com");

        List<Users> paging = usersBiz.paging(1, 2, condition);
        System.out.println("第一页：");
        paging.stream().forEach(System.out::println);
        System.out.println();
        int i = usersBiz.pagingCount(condition);
        System.out.println("总共有多少条数据：" + i);
    }

    @Test
    public void test4(){
        UsersBiz usersBiz = new UsersBizImpl();
        PageUtil<Users> pageUtil = new PageUtil<>();
        pageUtil.setPageIndex(1);


        PageUtil<Users> page = ((UsersBizImpl) usersBiz).page(pageUtil, null);

        String s = JSONObject.toJSONString(page);
        System.out.println(s);
    }
}