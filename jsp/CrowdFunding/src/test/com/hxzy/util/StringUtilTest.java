package com.hxzy.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilTest {

    @Test
    public void testEncrypt(){
        String encrypt = StringUtil.encrypt("123456");
        System.out.println(encrypt);
    }


}