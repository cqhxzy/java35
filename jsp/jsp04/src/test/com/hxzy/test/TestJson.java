package com.hxzy.test;

import com.alibaba.fastjson.JSONObject;
import com.hxzy.vo.AjaxResult;
import org.junit.Test;

public class TestJson {

    @Test
    public void test1(){
        AjaxResult result = new AjaxResult();
        result.setFlag(false);
        result.setData("用户名或密码错误");

        //Object o = JSONObject.toJSON(result);

        String s = JSONObject.toJSONString(result); //将一个java对象直接转换为json字符串
        System.out.println(s);
    }
}
