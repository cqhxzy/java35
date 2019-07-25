package demo1;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;  /*要使用assertThat,必须先静态导入hamcrest中的Matcher类*/

public class AssertThatTest {

    @Test
    public void test1(){
        String str = "hello java";
        //assertThat(excepted,actual); //期望值和实际值

        //allOf类似于逻辑运算符中的&&,同时满足多个条件
        //assertThat(str,allOf(startsWith("h"),endsWith("a")));

        int value = 10;
        //anyOf类似于|| ,或者
        //assertThat(value,anyOf(is(10),is(20),is(30)));  if(value == 10 || value == 20 || value == 30)

        //assertThat(value,anything("不管你是啥，我都匹配")); //什么东西都可以

        //验证某个集合中是否包含某个元素
        //assertThat(Arrays.asList("foo", "bar"), hasItem("ar"));

        //assertThat(value,equalTo(20));

        //assertThat(value,not(20));

        //assertThat(null,notNullValue());
        //assertThat(null,nullValue());
        //assertThat(Double.valueOf(2.8),closeTo(3.0,0.3));
        //assertThat(10,greaterThan(5));
        assertThat(10,lessThan(20));
    }
}
