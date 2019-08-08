package com.hxzy.util;

import com.hxzy.entity.Users;
import com.sun.media.sound.SoftTuning;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ConvertTest {

    @Test
    public void test() {
        Users users = new Users();
        try {
            ConvertUtils.register((clazz,value) ->{
                if (value != null) {
                    try {
                        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(value.toString());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }//内部类：value接收data转换成string类型
                //SimpleDateFormat中的parse方法可以  把String型的字符串转换成特定格式的date类
                return null;
            }, Date.class);

            //BeanUtils.setProperty(users, "uId", 10);
            BeanUtils.setProperty(users, "createTime", new Timestamp(System.currentTimeMillis()));

            System.out.println(users);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
