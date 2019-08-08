package com.hxzy.util;

import com.hxzy.entity.Users;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ConvertTest {

    @Test
    public void test(){
        Users users = new Users();
        try {
            ConvertUtils.register(new DateLocaleConverter(Locale.getDefault(),"yyyy-MM-dd HH:mm:ss"), Date.class);

            BeanUtils.setProperty(users,"createTime","2018-08-08");

            System.out.println(users);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
